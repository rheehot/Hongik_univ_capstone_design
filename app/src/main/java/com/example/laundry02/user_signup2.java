package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class user_signup2 extends Activity {

    Button user_signup_back, user_signup_go;

    EditText et1,et2,et3,et4,et5;

    String user_name, user_id, user_password, user_email, user_address;
    Double user_lat, user_long;
    int user_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_signup2);

        user_signup_back = (Button) findViewById(R.id.layout2_b1);
        user_signup_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(user_signup2.this, user_signup1.class);
                startActivity(intent);
            }
        });


        et1 = findViewById(R.id.layout2_et1);
        et2 = findViewById(R.id.layout2_et2);
        et3 = findViewById(R.id.layout2_et3);
        et4 = findViewById(R.id.layout2_et4);
        et5 = findViewById(R.id.layout2_et5);

        user_signup_go = (Button) findViewById(R.id.layout2_b2);
        user_signup_go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    user_name = et1.getText().toString();
                    user_id = et2.getText().toString();
                    user_password = et3.getText().toString();
                    user_email = et4.getText().toString();
                    user_number = Integer.parseInt(et5.getText().toString());
                    user_lat = Double.parseDouble("0.0");
                    user_long = Double.parseDouble("0.0");
                    user_address = "null";
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"빈칸을 채워주세요.",Toast.LENGTH_SHORT).show();
                }
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success"); //php보면 response가 success면 ㄱㄱ
                            if(success){ //회원등록에 성공한 경우
                                String user_id = et2.getText().toString();
                                /*Toast.makeText(getApplicationContext(),"다음으로",Toast.LENGTH_SHORT).show();*/

                                Intent intent = new Intent(user_signup2.this, user_signup3.class);
                                intent.putExtra("user_id",user_id);

                                startActivity(intent);
                            }
                            //실패한 경우
                            else{
                                Toast.makeText(getApplicationContext(),"중복된 아이디입니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청을 함
                user_register1_db registerRequest = new user_register1_db(user_name, user_id,user_password,user_email, user_address, user_number, user_lat, user_long, responseListener);
                RequestQueue queue = Volley.newRequestQueue(user_signup2.this);
                queue.add(registerRequest);
            }
        });

        //-------------------------------------------------------------------------------

        /*et_id = findViewById(R.id.et1);
        et_pass = findViewById(R.id.et2);
        et_name = findViewById(R.id.et3);
        et_age = findViewById(R.id.et4);

        btn_register = findViewById(R.id.b1);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //현재 입력되어 있는 값을 가져온다(get)
                String userID = et_id.getText().toString();
                String userPass = et_pass.getText().toString();
                String userName = et_name.getText().toString();
                int userAge = Integer.parseInt(et_age.getText().toString());

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success"); //php보면 response가 success면 ㄱㄱ
                            if(success){ //회원등록에 성공한 경우
                                Toast.makeText(getApplicationContext(),"회원등록 완료",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(intent);
                            }
                            //실패한 경우
                            else{
                                Toast.makeText(getApplicationContext(),"회원등록 실패",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청을 함
                RegisterRequest registerRequest = new RegisterRequest(userID,userPass,userName,userAge, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });*/
    }
}