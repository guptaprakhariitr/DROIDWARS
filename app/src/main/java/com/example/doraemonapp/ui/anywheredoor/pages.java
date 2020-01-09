package com.example.doraemonapp.ui.anywheredoor;

import com.google.gson.annotations.SerializedName;
import java.lang.String;
import java.util.List;


public class pages {
    @SerializedName("title")
    String title;
    @SerializedName("thumbnail")
    thumbnail thumbnail;
    @SerializedName("terms")
    terms terms;
    public String getTitle()
    {
        return title;
    }
    public thumbnail getThumbnail()
    {
        return thumbnail;
    }
    public terms getTerms(){
        return terms ;
    }
}
