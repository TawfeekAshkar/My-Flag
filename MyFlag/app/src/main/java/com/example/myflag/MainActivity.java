 package com.example.myflag;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

 public class MainActivity extends AppCompatActivity {

     Button topBtn;
     Button middleBtn;
     Button bottomBtn;
     EditText CountryName;

     SharedPreferences country_Name;
     SharedPreferences.Editor editor;
     SharedPreferences flagColor;

     @Override
    protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);

         topBtn = findViewById(R.id.topBtn);
         middleBtn = findViewById(R.id.middleBtn);
         bottomBtn = findViewById(R.id.bottomBtn);
         CountryName = findViewById(R.id.CountryName);

         country_Name = getPreferences(MODE_PRIVATE);
         editor = country_Name.edit();

         flagColor = getSharedPreferences("flag-Color",MODE_PRIVATE);

         topBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent topActivityIntent = new Intent(MainActivity.this, TopActivity.class);
                 startActivity(topActivityIntent);
             }
         });
         middleBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent midActivityIntent = new Intent(MainActivity.this, MiddleActivity.class);
                 startActivity(midActivityIntent);
             }
         });
         bottomBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent bottomActivityIntent = new Intent(MainActivity.this, BottomActivity.class);
                 startActivity(bottomActivityIntent);
             }
         });
     }
     @Override
     protected void onResume() {
         super.onResume();

         String countryName = country_Name.getString("countryName", "");
         CountryName.setText(countryName);
         editor.putString("countryName",countryName);
         editor.commit();

         String topColorBtn = flagColor.getString("top_Color","Gray");
         String middleColorBtn = flagColor.getString("middle_Color","Gray");
         String bottomColorBtn = flagColor.getString("bottom_Color","Gray");

         if (topColorBtn.equals("Gray")) {
             topBtn.setText("Choose the top color >>>");
             topBtn.setBackgroundColor(Color.GRAY);
         }
         else if(topColorBtn.equals("Red")) {
             topBtn.setText("");
             topBtn.setBackgroundColor(Color.RED);
         }
         else if(topColorBtn.equals("Blue")) {
             topBtn.setText("");
             topBtn.setBackgroundColor(Color.BLUE);
         }
         else if(topColorBtn.equals("Green")) {
             topBtn.setText("");
             topBtn.setBackgroundColor(Color.GREEN);
         }
         else if (middleColorBtn.equals("Gray")) {
             middleBtn.setText("Choose the middle color >>>");
             middleBtn.setBackgroundColor(Color.GRAY);
         }
         else if(middleColorBtn.equals("White")) {
             middleBtn.setText("");
             middleBtn.setBackgroundColor(Color.WHITE);
         }
         else if(middleColorBtn.equals("Green")) {
             middleBtn.setText("");
             middleBtn.setBackgroundColor(Color.GREEN);
         }
         else if(middleColorBtn.equals("Yellow")) {
             middleBtn.setText("");
             middleBtn.setBackgroundColor(Color.YELLOW);
         }
//         if (topColorBtn.equals("Gray")) {
//             topBtn.setText("Choose the top color >>>");
//             topBtn.setBackgroundColor(Color.GRAY);
//         }
//         else if(topColorBtn.equals("Red")) {
//             topBtn.setText("");
//             topBtn.setBackgroundColor(Color.RED);
//         }
//         else if(topColorBtn.equals("Blue")) {
//             topBtn.setText("");
//             topBtn.setBackgroundColor(Color.BLUE);
//         }
//         else if(topColorBtn.equals("Green")) {
//             topBtn.setText("");
//             topBtn.setBackgroundColor(Color.GREEN);
//         }
//

         }
     }

