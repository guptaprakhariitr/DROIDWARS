package com.example.doraemonapp.ui;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
public class APIclient {
    private static final String baseURl ="https://history.muffinlabs.com";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().
                    baseUrl(baseURl).
                    addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
