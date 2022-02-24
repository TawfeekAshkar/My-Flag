package com.example.myflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MiddleActivity extends AppCompatActivity {

    Spinner spinnerColor;
    Button setBtn;

    SharedPreferences flagColor;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_middle);

        setBtn=findViewById(R.id.setBtn);
        spinnerColor=findViewById(R.id.spinnerColor);

        flagColor = getSharedPreferences("flag_Color",MODE_PRIVATE);
        editor = flagColor.edit();

        String [] color ={"White","Green","Yellow"};
        ArrayAdapter<String> spinnerAdapter=new ArrayAdapter<String>(MiddleActivity.this,R.layout.support_simple_spinner_dropdown_item,color);
        spinnerColor.setAdapter(spinnerAdapter);

        setBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chosenColor = spinnerColor.getSelectedItem().toString();
                editor.putString("middle_Color",chosenColor);
                editor.commit();
                finish();
            }
        });
    }
}