package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class owner_login extends Activity {
    private Button findyourid, owner_login;
    private EditText owner_id1, owner_password1;
    private long backBtnTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_login);

        owner_id1 = (EditText) findViewById(R.id.layout5_et1);
        owner_password1 = (EditText) findViewById(R.id.layout5_et2);

        findyourid = (Button) findViewById(R.id.layout5_b1);
        findyourid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(owner_login.this, forgot_id_pw.class);
                startActivity(intent);
            }
        });

        owner_login = (Button) findViewById(R.id.layout5_b2);
        owner_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String owner_id = owner_id1.getText().toString();
                String owner_password = owner_password1.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success"); //php보면 response가 success면 ㄱㄱ
                            if(success){ //회원등록에 성공한 경우
                                String owner_name  = jsonObject.getString("owner_name");
                                String owner_address = jsonObject.getString("owner_address");
                                Double owner_lat = jsonObject.getDouble("owner_lat");
                                Double owner_long = jsonObject.getDouble("owner_long");
                                String store_name = jsonObject.getString("owner_store_name");

                                Toast.makeText(getApplicationContext(),"접속 성공",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(owner_login.this, owner_main.class);
                                intent.putExtra("owner_name",owner_name);
                                intent.putExtra("owner_address",owner_address);
                                intent.putExtra("owner_lat",owner_lat);
                                intent.putExtra("owner_long",owner_long);
                                intent.putExtra("store_name",store_name);
                                startActivity(intent);
                            }
                            //실패한 경우
                            else{
                                Toast.makeText(getApplicationContext(),"정확한 아이디/패스워드를 입력해주세요.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };
                owner_login_db loginRequest = new owner_login_db(owner_id, owner_password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(owner_login.this);
                queue.add(loginRequest);
            }
        });
    }
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
}