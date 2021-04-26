package com.example.testjetpack;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    MutableLiveData<String> userName;

    public LiveData<String> getUserName() {
        if(userName==null){
            userName=new MutableLiveData<>();
        }
        return userName;
    }
}
