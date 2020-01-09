package com.example.doraemonapp.ui;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIinterface_random {
    @GET("/date/{month}/{day}")
    Call<Data> getRandomHistory(@Path("month")int month,@Path("day")int day);
}

