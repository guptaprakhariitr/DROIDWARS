package com.example.doraemonapp.ui.anywheredoor;

import com.google.gson.annotations.SerializedName;

public class thumbnail {
@SerializedName("source")
    String source;
@SerializedName("width")
    int width;
@SerializedName("height")
    int height;
public String getSource() {
    return source;
}
public int getWidth()
{
    return  width;
}
public int getHeight()
{
    return height;
}
}
