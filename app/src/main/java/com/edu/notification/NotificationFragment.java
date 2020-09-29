package com.edu.notification;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.ActivityOptionsCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Utils.Const;
import com.Utils.Helper;
import com.edu.aplis.R;
import com.edu.book.CourseDetail;
import com.edu.discover.Books;
import com.edu.discover.ClickAdapter;
import com.edu.fav.FavBookAdapter;
import com.edu.fav.FavRetrofitModel;
import com.edu.preference.PrefrenceUtils;
import com.edu.retrofitapi.Api;
import com.edu.retrofitapi.RetrofitClient;
import com.edu.search.BooksSearch;
import com.edu.webservice.Cons;
import com.edu.webservice.ResponceQueues;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.X509TrustManager;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificationFragment extends Fragment implements  ClickAdapter {
    Context context;
    ArrayList<NotificationData> notificationList;
    RecyclerView recyclerView;
    String uniqure_url = "";
    NotificationAdapter notificationAdapter;
    TextView noContentFoundTV;
    ProgressBar progressBar;
    RelativeLayout coordinatorLayout;
    ClickAdapter clickAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_notification, container, false);

        context = getActivity();
        clickAdapter=this;
        recyclerView = rootView.findViewById(R.id.recyclerview);
        coordinatorLayout = rootView.findViewById(R.id.coordinatorLayout);
        noContentFoundTV=rootView.findViewById(R.id.noContentFoundTV);
        progressBar = rootView.findViewById(R.id.progressBar);
        notificationList = new ArrayList<>();

        DividerItemDecoration itemDecorator = new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL);
        itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.divider));

        recyclerView.addItemDecoration(itemDecorator);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(linearLayoutManager);
        uniqure_url = Cons.GET_FAVURL;

        makeHttpCall();

        return  rootView;
    }

    private void makeHttpCall( ) {
        if (Helper.isNetworkConnected(context)) {
            progressBar.setVisibility(View.VISIBLE);

            Api api = RetrofitClient.getClient(context).create(Api.class);

            Call<JsonObject> call = api.getNotificationList(PrefrenceUtils.readString(context, PrefrenceUtils.PREF_USER_TYPE, ""));
            call.enqueue(new Callback<JsonObject>() {
                @Override
                public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                    try {
                        Gson gson = new Gson();
                        progressBar.setVisibility(View.GONE);
                        if (response.body() != null) {
                            JsonObject jsonObject = response.body();
                            Log.e("notification Response", jsonObject.toString());
                            JSONObject jsonResponse = null;

                            try {
                                jsonResponse = new JSONObject(jsonObject.toString());
                                if (jsonResponse.optInt(Const.STATUS)==1) {
                                    JSONObject jsonObject1 = jsonResponse.getJSONObject(Const.DATA);
                                    JSONArray dataarray = jsonObject1.getJSONArray("list");
                                    if (dataarray.length() > 0) {
                                        int i = 0;
                                        while (i < dataarray.length()) {
                                            JSONObject singledatarow = dataarray.getJSONObject(i);
                                            NotificationData response1 = gson.fromJson(singledatarow.toString(), NotificationData.class);
                                            notificationList.add(response1);
                                            i++;
                                        }
                                    }
                                } else {
                                    progressBar.setVisibility(View.GONE);
                                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                                }
                                InitNotificationAdapter(); // at the time to get newtag notifications

                            } catch (JSONException e) {
                                e.printStackTrace();
                                progressBar.setVisibility(View.GONE);
                            }
                        }

                    } catch (Exception e) {
                        Log.e("discovererror", e + "");
                        progressBar.setVisibility(View.GONE);

                    }

                }

                @Override
                public void onFailure(Call<JsonObject> call, Throwable t) {
                    Log.e("errordo", t.getMessage());
                    progressBar.setVisibility(View.GONE);
                }
            });
        }
        else {

            Toast.makeText(context, R.string.Retry_with_Internet_connection, Toast.LENGTH_LONG).show();}
    }

    private void InitNotificationAdapter() {
        if (notificationList.size() > 0) {
            notificationAdapter = new NotificationAdapter(context, notificationList, clickAdapter);
            recyclerView.setAdapter(notificationAdapter);
            noContentFoundTV.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
        } else {
            noContentFoundTV.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
        }

    }


    @Override
    public void clickoncard(ImageView view, int position, String id, String content, String title, String long_desc, List<Books> booksList, String image_Ar, String discover_id) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(),view,"cover_image");

        startActivity(new Intent(context, CourseDetail.class).putExtra("book_id", id).putExtra("cover_image",content),activityOptionsCompat.toBundle());
    }




}
