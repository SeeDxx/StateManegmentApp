package com.example.statemanegmentapp;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel{
    int count = 0;
    boolean check = false;

    public boolean checkBoxStatus(){
        return check;
    }

    public int getCount() {
        return count;
    }

    public void incrementCount(){
        count++;
    }
}
