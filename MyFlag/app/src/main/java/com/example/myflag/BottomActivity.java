package com.example.myflag;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class BottomActivity extends AppCompatActivity {

    Button setBTN;
    RadioButton redRb,blueRb,greenRb;

    SharedPreferences flagColor;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom);

        setBTN = findViewById(R.id.setBTN);
        redRb = findViewById(R.id.redRb);
        blueRb = findViewById(R.id.blueRb);
        greenRb = findViewById(R.id.greenRb);

        flagColor = getSharedPreferences("flag_Color",MODE_PRIVATE);
        editor = flagColor.edit();

        setBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String chosenColor = "";
                if (redRb.isChecked()) {
                    chosenColor = "Red";
                }
                else if (blueRb.isChecked()) {
                    chosenColor = "Blue";
                }
                else if (greenRb.isChecked()) {
                    chosenColor = "Green";
                }
                editor.putString("bottom_Color",chosenColor);
                editor.commit();
                finish();
            }
        });

    }
}
