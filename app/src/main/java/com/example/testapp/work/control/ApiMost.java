package com.example.testapp.work.control;

import com.example.testapp.work.api.Example;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiMost {
    @Headers("Content-Type: text/json")
    @GET("svc/mostpopular/v2/mostemailed/Sports/30.json?api-key=85a27b39c92648b8be34ba9af8ea45b8")
    Call<Example> mostEmailed();

    @Headers("Content-Type: text/json")
    @GET("svc/mostpopular/v2/mostshared/Sports/30.json?api-key=85a27b39c92648b8be34ba9af8ea45b8")
    Call<Example> mostShared();

    @Headers("Content-Type: text/json")
    @GET("svc/mostpopular/v2/mostviewed/Sports/30.json?api-key=85a27b39c92648b8be34ba9af8ea45b8")
    Call<Example> mostViewed();
}
