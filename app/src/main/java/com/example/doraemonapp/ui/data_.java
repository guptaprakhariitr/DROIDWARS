package com.example.doraemonapp.ui;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class data_ {
@SerializedName("Events")
    List<Event> Events;
public List<Event> getEvents() {
    return  Events;
}
}
