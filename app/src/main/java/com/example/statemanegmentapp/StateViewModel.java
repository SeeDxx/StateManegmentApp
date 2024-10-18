package com.example.statemanegmentapp;

import androidx.lifecycle.ViewModel;

public class StateViewModel extends ViewModel{
    int count = 0;
    boolean statusBox;
    boolean statusSwitch;
    String input;




    public void textUpdate(String test){
        input = test;
    }

    public String testText(){
        return input;
    }


    public void checkBoxTrue(){
        statusBox = true;
    }

    public void checkBoxFalse(){
        statusBox = false;
    }

    public boolean checkBoxStatus(){
        return statusBox;
    }



    public void switchTrue(){
        statusSwitch = true;
    }

    public void switchFalse(){
        statusSwitch = false;
    }

    public boolean switchStatus(){
        return statusSwitch;
    }



    public int getCount() {
        return count;
    }

    public void incrementCount(){
        count++;
    }



}
