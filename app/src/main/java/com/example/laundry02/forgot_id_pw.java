package com.example.laundry02;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.database.CursorJoiner;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;


public class forgot_id_pw extends Activity {

    Button signup_back, checkemail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_id_pw);

        signup_back = (Button) findViewById(R.id.layout2_b1);

        signup_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(forgot_id_pw.this, MainActivity.class);
                startActivity(intent);
            }
        });

        checkemail = (Button) findViewById(R.id.layout2_b2);
        checkemail.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(forgot_id_pw.this);
                builder.setTitle("알림");
                builder.setMessage("이메일을 확인하세요.");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(forgot_id_pw.this, MainActivity.class);
                        Toast.makeText(getApplicationContext(), "메인으로 이동합니다.", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();                                                       //빌더를 이용하여 AlertDialog객체를 생성합니다.
                alert.show();
            }
        });

        checkemail = (Button) findViewById(R.id.layout2_b3);
        checkemail.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                AlertDialog.Builder builder = new AlertDialog.Builder(forgot_id_pw.this);
                builder.setTitle("알림");
                builder.setMessage("이메일을 확인하세요.");
                builder.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(forgot_id_pw.this, MainActivity.class);
                        Toast.makeText(getApplicationContext(), "메인으로 이동합니다.", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                    }
                });
                AlertDialog alert = builder.create();                                                       //빌더를 이용하여 AlertDialog객체를 생성합니다.
                alert.show();

            }
        });

        /*AlertDialog.Builder builder = new AlertDialog.Builder(forgot_id_pw.this);
        builder.setTitle("알림");
        builder.setMessage("이메일을 확인하세요.");                                         //메시지를 지정합니다.

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                //"YES" Button Click
                Toast.makeText(getApplicationContext(), "YES Button Click", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //"NO" Button Click
                Toast.makeText(getApplicationContext(), "NO Button Click", Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alert = builder.create();                                                       //빌더를 이용하여 AlertDialog객체를 생성합니다.
        alert.show();*/
    }
}
