package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class MainActivity extends Activity {

    private long backBtnTime = 0;
    Button b1;

    @Override
    public void onBackPressed() {
        long curTime = System.currentTimeMillis();
        long gapTime = curTime - backBtnTime;

        if(0 <= gapTime && 2000 >= gapTime) {
            moveTaskToBack(true);
            finish();
            android.os.Process.killProcess(android.os.Process.myPid());
        }
        else {
            backBtnTime = curTime;
            Toast.makeText(this, "한번 더 누르면 종료됩니다.",Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button user_signup_button, user_login_button, owner_signup_button, owner_login_button;
        EditText edit1, edit2;
        String str1, str2;

        user_signup_button = (Button) findViewById(R.id.layout1_b3);
        user_signup_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, user_signup1.class);
                startActivity(intent);
            }
        });

        owner_signup_button = (Button) findViewById(R.id.layout1_b4);
        owner_signup_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, owner_signup1.class);
                startActivity(intent);
            }
        });

        user_login_button = (Button) findViewById(R.id.layout1_b1);
        user_login_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, user_login.class);
                startActivity(intent);
            }
        });

        owner_login_button = (Button) findViewById(R.id.layout1_b2);
        owner_login_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, owner_login.class);
                startActivity(intent);
            }
        });


        Intent intent = new Intent(this, mainloading.class);
        startActivity(intent);


        /*public void main_login_button1(View v){
        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"));
        startActivity(myIntent);
    }*/
        b1 = (Button) findViewById(R.id.web);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://laudaryservice.s3-website.ap-northeast-2.amazonaws.com/"));
                startActivity(intent);
            }
        });
    }
}
