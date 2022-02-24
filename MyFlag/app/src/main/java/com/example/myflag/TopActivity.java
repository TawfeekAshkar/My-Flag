package com.example.myflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TopActivity extends AppCompatActivity {

    Button redBtn,blueBtn,greenBtn;

    SharedPreferences flagColor;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top);

        redBtn=findViewById(R.id.redBtn);
        blueBtn=findViewById(R.id.blueBtn);
        greenBtn=findViewById(R.id.greenBtn);

        flagColor = getSharedPreferences("flag-Color",MODE_PRIVATE);
        editor = flagColor.edit();

        redBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               editor.putString("top_Color","Red");
               editor.commit();
               finish();
            }
        });
        blueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("top_Color","Blue");
                editor.commit();
                finish();
            }
        });
        greenBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("top_Color","Green");
                editor.commit();
                finish();
            }
        });
    }
}