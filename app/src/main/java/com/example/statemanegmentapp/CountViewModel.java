package com.example.statemanegmentapp;

import androidx.lifecycle.ViewModel;

public class CountViewModel extends ViewModel{
    int count = 0;

    public int getCount() {
        return count;
    }

    public  void incrementCount(){
        count++;
    }
}
