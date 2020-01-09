package com.example.doraemonapp.ui;
import com.example.doraemonapp.ui.Data;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface APIinterface {
    @GET("/date")
    Call<Data> getHistoryData() ;
}
