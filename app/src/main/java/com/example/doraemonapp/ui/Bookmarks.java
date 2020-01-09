package com.example.doraemonapp.ui;



public class Bookmarks {
   private String bmdata,id;
    public Bookmarks()
    {

    }
    public Bookmarks(String bmdata,String id)
    {
        this.bmdata=bmdata;
        this.id=id;
    }

    public void setBmdata(String bmdata) {
        this.bmdata = bmdata;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBmdata() {
        return bmdata;
    }
public String getId()
{
    return id;
}
}
