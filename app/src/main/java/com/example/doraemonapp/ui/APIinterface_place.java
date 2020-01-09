package com.example.doraemonapp.ui;
import com.example.doraemonapp.ui.anywheredoor.Data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface APIinterface_place {
@GET("/w/api.php")
    Call<Data> getLocationData(@Query("action")String action,@Query("formatversion")String version,@Query("prop")String  prop, @Query("titles") String location,@Query("format")String format);
}
