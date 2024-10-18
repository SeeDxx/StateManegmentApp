package com.example.statemanegmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.lifecycle.ViewModelProvider;


public class MainActivity extends AppCompatActivity {

    private StateViewModel stateViewModel;
    private TextView textViewCount;
    private TextView test;
    private Switch switchButton;
    private CheckBox checkBox;
    private EditText editText;
    private TextView textChange;

    private static final String KEY_COUNT = "count";
    private int count = 0;


    @Override
    protected void onResume(){
        super.onResume();
        textUpdate();
        testText();
    }

    @Override
    protected void onPause(){
        super.onPause();
        textUpdate();
        testText();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        switchButton = findViewById(R.id.switchButton);
        checkBox = findViewById(R.id.checkBox);
        textChange = findViewById(R.id.textChange);
        editText = findViewById(R.id.editText);
        test = findViewById(R.id.test);


        stateViewModel = new ViewModelProvider(this).get(StateViewModel.class);
        updateCountText();
        checkBoxUpdate();
        switchUpdate();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                stateViewModel.incrementCount();

                updateCountText();
            }
        });
        switchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (switchButton.isChecked()){
                    stateViewModel.switchTrue();
                    switchUpdate();
                } else {
                    stateViewModel.switchFalse();
                    switchUpdate();
                }
            }
        });
        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (checkBox.isChecked()){
                    stateViewModel.checkBoxTrue();
                    checkBoxUpdate();
                } else {
                    stateViewModel.checkBoxFalse();
                    checkBoxUpdate();
                }
            }
        });
    }

    private void textUpdate(){
        stateViewModel.textUpdate(editText.getText().toString());
    }

    private void testText(){
        test.setText(stateViewModel.testText());
    }

    private void updateCountText(){
        textViewCount.setText("Licznik: " + stateViewModel.getCount());
    }

    private void checkBoxUpdate(){
        if (stateViewModel.checkBoxStatus()){
            textChange.setVisibility(View.VISIBLE);
        } else {
            textChange.setVisibility(View.INVISIBLE);
        }
    }

    private void switchUpdate(){
        if (stateViewModel.switchStatus()){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }


}

