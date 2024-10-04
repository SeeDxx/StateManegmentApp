package com.example.statemanegmentapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.CheckBox;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private CountViewModel countViewModel;
    private TextView textViewCount;
    private TextView switchButton;
    private TextView checkBox;
    private TextView editText;

    private static final String KEY_COUNT = "count";
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewCount = findViewById(R.id.textViewCount);
        Button buttonIncrement = findViewById(R.id.buttonIncrement);
        switchButton = findViewById(R.id.switchButton);
        checkBox = findViewById(R.id.checkBox);
        editText = findViewById(R.id.editText);

        countViewModel = new ViewModelProvider(this).get(CountViewModel.class);
        updateCountText();

        buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                countViewModel.incrementCount();

                updateCountText();
            }
        });
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (switchButton.isChecked()){

                }
            }
        });
    }


    private void updateCountText(){
        textViewCount.setText("Licznik: " + countViewModel.getCount());
    }

}

