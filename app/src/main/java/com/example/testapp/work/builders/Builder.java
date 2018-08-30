package com.example.testapp.work.builders;

import android.app.Application;

import com.example.testapp.work.BuildConfig;
import com.example.testapp.work.control.ApiMost;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Builder extends Application{
    private static final String BASE_URL="https://developer.nytimes.com/most_popular_api_v2.json#/Console/GET/";
    private static final String API_KEY="85a27b39c92648b8be34ba9af8ea45b8";
    private static  ApiMost apiMost;
   // private Retrofit retrofit;

    public  void onCreate() {
        super.onCreate();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://developer.nytimes.com/")
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        apiMost = retrofit.create(ApiMost.class);

    }
    public static ApiMost getApiMost(){
        return apiMost;
    }
    public static Gson gson(){
        return new Gson();
    }

}
