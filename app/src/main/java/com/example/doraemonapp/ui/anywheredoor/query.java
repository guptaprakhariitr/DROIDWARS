package com.example.doraemonapp.ui.anywheredoor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class query {
    @SerializedName("pages")
    List<pages> pages;
    public List<pages> getPages(){
        return pages;
    }
}
