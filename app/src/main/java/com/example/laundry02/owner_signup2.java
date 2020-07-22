package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class owner_signup2 extends Activity {

    Button user_signup_back, user_signup_go;

    EditText et1,et2,et3,et4,et5,et6,et7,et8;

    String owner_name, owner_store_name, owner_id, owner_password, owner_email, owner_nin, owner_address, cd;
    int owner_number, owner_store_number;
    Double owner_lat, owner_long;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_signup2);

        user_signup_back = (Button) findViewById(R.id.layout2_b1);
        user_signup_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(owner_signup2.this, user_signup1.class);
                startActivity(intent);
            }
        });


        et1 = findViewById(R.id.layout2_et1);
        et2 = findViewById(R.id.layout2_et2);
        et3 = findViewById(R.id.layout2_et3);
        et4 = findViewById(R.id.layout2_et4);
        et5 = findViewById(R.id.layout2_et5);
        et6 = findViewById(R.id.layout2_et6);
        et7 = findViewById(R.id.layout2_et7);
        et8 = findViewById(R.id.layout2_et8);

        user_signup_go = (Button) findViewById(R.id.layout2_b2);
        user_signup_go.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    owner_name = et1.getText().toString();
                    owner_store_name = et2.getText().toString();
                    owner_id = et3.getText().toString();
                    owner_password = et4.getText().toString();
                    owner_number = Integer.parseInt(et5.getText().toString());
                    owner_email = et6.getText().toString();
                    owner_store_number = Integer.parseInt(et7.getText().toString());
                    owner_nin = et8.getText().toString();
                    owner_lat = Double.parseDouble("0.0");
                    owner_long = Double.parseDouble("0.0");
                    owner_address = "null";
                    /*int cd = Integer.parseInt("0");*/
                    cd = "0";
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"빈칸을 채워주세요.",Toast.LENGTH_SHORT).show();
                }

                //이름, 가게상호명, 아이디, 비밀번호, 연락처, 이메일, 가게연락처, 사업자등록번호

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            boolean success = jsonObject.getBoolean("success"); //php보면 response가 success면 ㄱㄱ
                            if(success){ //회원등록에 성공한 경우
                                String owner_nin = et8.getText().toString();
                                String cd = "0";
                                String owner_store_name = et2.getText().toString();
                                String owner_name = et1.getText().toString();
                                String owner_id = et3.getText().toString();
                                String owner_number = et5.getText().toString();
                                /*Toast.makeText(getApplicationContext(),"다음으로",Toast.LENGTH_SHORT).show();*/

                                Intent intent = new Intent(owner_signup2.this, owner_signup3.class);
                                intent.putExtra("owner_nin",owner_nin);
                                intent.putExtra("cd",cd);
                                intent.putExtra("owner_store_name",owner_store_name);
                                intent.putExtra("owner_name",owner_name);
                                intent.putExtra("owner_id",owner_id);
                                intent.putExtra("owner_number",owner_number);

                                startActivity(intent);
                            }
                            //실패한 경우
                            else{
                                Toast.makeText(getApplicationContext(),"상호명 또는 아이디가 중복되었습니다.",Toast.LENGTH_SHORT).show();
                                return;
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                //서버로 Volley를 이용해서 요청을 함
                owner_register1_db registerRequest = new owner_register1_db(owner_id, owner_password, owner_name, owner_number,
                        owner_nin, owner_store_name, owner_address, owner_store_number, cd, owner_email, owner_lat, owner_long, responseListener);
                RequestQueue queue = Volley.newRequestQueue(owner_signup2.this);
                queue.add(registerRequest);
            }
        });
    }
}