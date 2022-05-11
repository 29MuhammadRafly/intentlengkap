package com.example.myintentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private  int REQUEST_CODE = 100;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnMoveActivity = findViewById(R.id.btn_move_activity);
        btnMoveActivity.setOnClickListener(this);

        Button btnMoveData = findViewById(R.id.btn_move_data);
        btnMoveData.setOnClickListener(this);

        Button btnMoveActivityObject = findViewById(R.id.btn_move_object);
        btnMoveActivityObject.setOnClickListener(this);

        Button btnDialNumber = findViewById(R.id.btn_dial_number);
        btnDialNumber.setOnClickListener(this);

        Button btnMoveForResult = findViewById(R.id.btn_move_for_result);
        btnMoveForResult.setOnClickListener(this);
        tvResult = (TextView) findViewById(R.id.tv_result);
    }



    @Override
    public void onClick (View v) {
        switch (v.getId())  {
            case R.id.btn_move_activity:
                Intent moveIntent = new Intent(MainActivity.this,MoveActivity.class);
                startActivity(moveIntent);
                break;

            case R.id.btn_move_data:
                Intent Mdata = new Intent(MainActivity.this,MoveActivity.class);
                Mdata.putExtra( "data1", "bisa pindah");
                Mdata.putExtra("data2", "bisa ");
                startActivity(Mdata);
                break;

            case R.id.btn_move_object:
                 Person manusia = new Person("Rafly ", "fly@gmail.com ", "Malang", 21);
                 Intent intent_object = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                 intent_object.putExtra(MoveWithObjectActivity.EXTRA_PERSON, manusia);
                 startActivity(intent_object);
                 break;

            case R.id.btn_dial_number:
                String phoneNumber ="082134799995";
                //Uri adalah data yang dikirim ke intent aplikasi lain yaitu dial
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;

            case R.id.btn_move_for_result:
                Intent moveForResultIntent = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResultIntent, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQUEST_CODE){
            if (resultCode==MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                tvResult.setText("Hasil: "+selectedValue);
            }
        }
    }
}