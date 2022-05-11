package com.example.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move);

        if (getIntent()!=null){
            TextView txt_data1 = findViewById(R.id.txt_dt1);
            TextView txt_data2 = findViewById(R.id.txt_dt2);

            txt_data1.setText(getIntent().getStringExtra("data1"));
            txt_data2.setText(getIntent().getStringExtra("data2"));
        }
    }
}