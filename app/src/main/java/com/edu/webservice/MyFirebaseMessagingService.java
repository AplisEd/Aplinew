package com.edu.webservice;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.Utils.Const;
import com.edu.aplis.R;
import com.edu.home.HomeActivity;
import com.edu.home.HomeActivityNew;
import com.edu.preference.PrefrenceUtils;
import com.edu.reset.EmailResponse;
import com.edu.reset.Verify_Activity;
import com.edu.retrofitapi.Api;
import com.edu.retrofitapi.RetrofitClient;
import com.edu.retrofitapi.UserAccount;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.google.gson.Gson;
import com.google.gson.JsonObject;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    String refreshedToken;
    public static final String CHANNEL_ID = "Aplis";
    private static final String TAG = MyFirebaseMessagingService.class.getSimpleName();
    private NotificationUtils notificationUtils;

    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("FCM_Token",s);
        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        // Saving reg id to shared preferences
        storeRegIdInPref(refreshedToken);

        // sending reg id to your server
        sendRegistrationToServer(refreshedToken);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage == null)
            return;
        Log.e("On recieve","true");
        // Check if message contains a notification payload.
        if (remoteMessage.getNotification() != null) {
            try {
                JSONObject json = new JSONObject(remoteMessage.getNotification().getBody());
                Log.e("response",json.toString());
                handleDataMessage(json);
                }
             catch (JSONException e) {
                e.printStackTrace();
            }
        }

        // Check if message contains a data payload.
      /*  if (remoteMessage.getData().size() > 0) {
            Log.e(TAG, "Data Payload: " + remoteMessage.getData().toString());

            try {
                if (remoteMessage.getData().containsKey(Const.MESSAGE) && remoteMessage.getData().containsKey(Const.TYPE)) {

                    JSONObject json = new JSONObject(remoteMessage.getData().get(Const.MESSAGE).toString());
                    if (SharedPreference.getInstance().getBoolean(Const.IS_USER_LOGGED_IN) && !SharedPreference.getInstance().getBoolean(Const.IS_NOTIFICATION_BLOCKED)) {
                        handleDataMessage(json);
                    }
                } else if (remoteMessage.getData().containsKey(Const.MESSAGE) && remoteMessage.getData().size() == 1) {
                    Intent intent = new Intent(this, FeedsActivity.class);
                    JSONObject json = new JSONObject(remoteMessage.getData().get(Const.MESSAGE).toString());
                    handleDataMessage(json);
                   // showNotification(remoteMessage.getData().get(Const.MESSAGE), getString(R.string.app_name), intent);
                }
            } catch (Exception e) {
                Log.e(TAG, "Exception: " + e.getMessage());
            }
        }*/
    }
    private void storeRegIdInPref(String token) {
      //  SharedPreference.getInstance().putString(Const.FIREBASE_TOKEN_ID, token);
    }
    private void sendRegistrationToServer(final String token) {
        // sending gcm token to server
        PrefrenceUtils.readString(this, PrefrenceUtils.PREF_ID, "");
        Log.e(TAG, "sendRegistrationToServer: " + PrefrenceUtils.readString(this, PrefrenceUtils.PREF_ID, ""));
        Api api = RetrofitClient.getClient(this).create(Api.class);
        Call<JsonObject> call = api.sendFcmTokenToServer(PrefrenceUtils.readString(this, PrefrenceUtils.PREF_ID, ""),token);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                try {
                    JSONObject jsonObject = new JSONObject(new Gson().toJson(response.body()));
                    Log.e(TAG, "Server Response : " + jsonObject.optString(Const.MESSAGE));

                }
                catch (Exception e){
                    Log.e("account_detail",   e+"");
                }
            }
            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                Log.e("errordo",t.getMessage());
            }
        });


    }
    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = getString(R.string.channel_name);
            String description = getString(R.string.channel_description);
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }



    private void handleDataMessage(JSONObject json) {
        Log.e("Notifiaction_json",json.toString());

        createNotificationChannel();
        Intent intent = null;
        String message = json.optString(Const.MESSAGE);
        handleNotification(message);
        intent = new Intent(this, HomeActivity.class);
        intent.putExtra(Const.FRAG_TYPE, Const.NOTIFICATION);
        startActivity(intent);
        showNotification(message, getString(R.string.app_name), intent);
    }



    private void handleNotification(String message) {
        // app is in foreground, broadcast the push message
        Intent pushNotification = new Intent();
        pushNotification.setAction("android.intent.action.MAIN");
        pushNotification.putExtra(Const.MESSAGE, message);
        sendBroadcast(pushNotification);

        // play notification sound
        NotificationUtils notificationUtils = new NotificationUtils(getApplicationContext());
        notificationUtils.playNotificationSound();

    }
    public void showNotification(String pushMessage, String pushTitle, Intent intent) {

        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(Bitmap.createScaledBitmap(icon, 120, 120, false))
                .setContentTitle(pushTitle)
                .setContentText(pushMessage)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(pushMessage))
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setVibrate(new long[]{500, 500, 500, 500, 500})
                .setContentIntent(pendingIntent);


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        Random random = new Random();
        int notificationId = random.nextInt(10000);
     //   ShortcutBadger.applyCount(getApplicationContext(), SharedPreference.getInstance().getInt(Const.NOTIFICATION_COUNT));
        notificationManager.notify(notificationId/* ID of notification */, notificationBuilder.build());
    }

}