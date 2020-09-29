package com.edu.retrofitapi;

import android.content.Context;
import android.util.Log;

import com.edu.aplis.R;
import com.edu.preference.PrefrenceUtils;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static Retrofit retrofit = null;
    private static Context mcontext;
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(60, TimeUnit.MINUTES)
            .readTimeout(60,TimeUnit.MINUTES);

    public static Retrofit getClient(Context context){
        if(retrofit == null){

            mcontext=context;
            retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .client(trustcustom())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
//.client(trustcustom())
    private static OkHttpClient trustcustom(){
        OkHttpClient okHttpClient=null;
        try {
            // Load CAs from an InputStream
// (could be from a resource or ByteArrayInputStream or ...)
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
// From https://www.washington.edu/itconnect/security/ca/load-der.crt
            InputStream caInput = new BufferedInputStream(mcontext.getResources().openRawResource(R.raw.certfile));
            Certificate ca;
            try {
                ca = cf.generateCertificate(caInput);
                System.out.println("ca=" + ((X509Certificate) ca).getSubjectDN());
            } finally {
                caInput.close();
            }

// Create a KeyStore containing our trusted CAs
            String keyStoreType = KeyStore.getDefaultType();
            KeyStore keyStore = KeyStore.getInstance(keyStoreType);
            keyStore.load(null, null);
            keyStore.setCertificateEntry("ca", ca);

// Create a TrustManager that trusts the CAs in our KeyStore
            String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
            TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
            tmf.init(keyStore);

// Create an SSLContext that uses our TrustManager
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, tmf.getTrustManagers(), null);

            Log.e("HeaderValue",PrefrenceUtils.readString(mcontext, PrefrenceUtils.PREF_DEVIC_TOKEN,""));
// Tell the okhttp to use a SocketFactory from our SSLContext
            okHttpClient = new OkHttpClient.Builder().sslSocketFactory(context.getSocketFactory()
            )
                    .addInterceptor(new Interceptor() {
                        @Override
                        public Response intercept(Chain chain) throws IOException {
                            Request newRequest = chain.request().newBuilder()
                                    .addHeader("Authorization", " Bearer " + PrefrenceUtils.readString(mcontext, PrefrenceUtils.PREF_DEVIC_TOKEN, ""))
                                    .build();
                            return chain.proceed(newRequest);

                        }
                    }).build();
        }
        catch (Exception e){
            Log.e("CATCHerror",e+"");
        }

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpClient.addInterceptor(interceptor).connectTimeout(60, TimeUnit.MINUTES).readTimeout(60, TimeUnit.MINUTES) .writeTimeout(1, TimeUnit.MINUTES).build();
    }



    static OkHttpClient client = new OkHttpClient.Builder().addInterceptor(new Interceptor()           {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request newRequest  = chain.request().newBuilder()
                    .addHeader("Authorization", " Bearer " + PrefrenceUtils.readString(mcontext,PrefrenceUtils.PREF_DEVIC_TOKEN,""))
                    .build();
            return chain.proceed(newRequest);
        }
    }).build();


}
