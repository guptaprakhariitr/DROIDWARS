package com.example.doraemonapp.ui;
import com.google.gson.annotations.SerializedName;
public class Event {
    @SerializedName("text")
    String text;
    @SerializedName("year")
    String year;
    public String gettext() {
        return text;
    }
    public String  getyear() {
        return year;
    }
}
