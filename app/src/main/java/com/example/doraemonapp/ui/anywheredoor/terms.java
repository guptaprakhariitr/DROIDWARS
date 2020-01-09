package com.example.doraemonapp.ui.anywheredoor;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class terms {
    @SerializedName("description")
    List<String> description;
    public List<String> getDescription()
    {
        return description;
    }
}
