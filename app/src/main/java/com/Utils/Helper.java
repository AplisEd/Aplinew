package com.Utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import com.crashlytics.android.Crashlytics;
import com.edu.aplis.DemoApplication;
import com.edu.aplis.R;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;
import com.google.android.material.snackbar.Snackbar;

import java.util.Calendar;



public class Helper {

    private static Tracker sTracker;

    public static void logUser(Activity activity) {
        DemoApplication application = (DemoApplication) activity.getApplication();
        sTracker = application.getDefaultTracker();

        // TODO: Use the current user's information
        // You can call any combination of these three methods
       /* if (SharedPreference.getInstance().getLoggedInUser() != null) {
            Crashlytics.setUserIdentifier(SharedPreference.getInstance().getLoggedInUser().getId());
            Crashlytics.setUserEmail(SharedPreference.getInstance().getLoggedInUser().getEmail());
            Crashlytics.setUserName(SharedPreference.getInstance().getLoggedInUser().getName());
            sTracker.setScreenName("Image~" + SharedPreference.getInstance().getLoggedInUser().getName());

        } else {*/
            Crashlytics.setUserIdentifier(String.valueOf(Calendar.getInstance().getTimeInMillis()));
            Crashlytics.setUserEmail("g@email.com");
            Crashlytics.setUserName("Abc");
            sTracker.setScreenName("Image~" + "Abc");
       // }
        sTracker.send(new HitBuilders.ScreenViewBuilder().build());
    }

    public static void showSnackBar(View view, CharSequence text) {
        try {
            if (view != null) {
                final Snackbar snackbar = Snackbar.make(view, text, Snackbar.LENGTH_INDEFINITE);
                View sbView = snackbar.getView();
                TextView textView = (TextView) sbView.findViewById(R.id.snackbar_text);
                textView.setTextColor(Color.parseColor(Const.SNACKBAR_TEXT_COLOR));
                textView.setMaxLines(5);
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        snackbar.dismiss();
                    }
                }, 4000);
                snackbar.show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isNetworkConnected(Context ctx) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo ni = connectivityManager.getActiveNetworkInfo();
            return ni != null && ni.isAvailable() && ni.isConnected();
        } catch (Exception e) {
            return false;
        }
    }
}
