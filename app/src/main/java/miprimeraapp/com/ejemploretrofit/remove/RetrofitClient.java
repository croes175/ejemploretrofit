package miprimeraapp.com.ejemploretrofit.remove;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit=null;
    static OkHttpClient okHttpClient=new OkHttpClient.Builder()
            .connectTimeout(1,TimeUnit.MINUTES)
            .readTimeout(30,TimeUnit.SECONDS)
            .writeTimeout(15,TimeUnit.SECONDS)
            .build();
    public static Retrofit getClient(String url)
    {if(retrofit==null) {
retrofit=new Retrofit.Builder().baseUrl(url).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build();

    }
Log.d("RETROFIT","LOAD"+retrofit.baseUrl());
    return retrofit;


    }



}
