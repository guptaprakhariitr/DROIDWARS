package com.example.doraemonapp.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Bookmarklistmodel extends ViewModel {

    private MutableLiveData<String> mText;

    public Bookmarklistmodel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");

    }

    public LiveData<String> getText() {
        return mText;
    }
}