package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.dinuscxj.progressbar.CircleProgressBar;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class user_now_order2 extends Activity {

    String user_name1, user_address1, user_id1, user_address_detail1,s_name1;
    Double user_lat1, user_long1;
    int date1;

    String user_address;
    TextView tv1,tv2,tv3,tv4,tv5,tv6,tv7;
    Button back,b1,b2;

    String owner_name1, owner_address1, store_name1;
    Double owner_lat1, owner_long1;

    String memo, items;
    int date,t_price,yes_no;

    private static String TAG = "phptest";

    private EditText mEditTextName;
    private EditText mEditTextCountry;
    private TextView mTextViewResult;
    private ArrayList<ImageActivity_owner_list> mArrayList;
    private ImageActivity_owner_Adpter mAdapter;
    private RecyclerView mRecyclerView;
    private EditText mEditTextSearchKeyword;
    private String mJsonString;

    private static final String DEFAULT_PATTERN = "%d%%";

    CircleProgressBar circleProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_now_order2);

        circleProgressBar=findViewById(R.id.cpb_circlebar);

        circleProgressBar.setProgress(70);  // 해당 퍼센트를 적용

        Intent intent = getIntent();
        user_name1 = intent.getStringExtra("user_name");
        user_address1 = intent.getStringExtra("user_address");
        user_lat1 = intent.getDoubleExtra("user_lat",0.0);
        user_long1 = intent.getDoubleExtra("user_long",0.0);
        user_id1 = intent.getStringExtra("user_id");
        user_address_detail1 = intent.getStringExtra("user_address_detail");
        s_name1 = intent.getStringExtra("store_name");
        date1 = intent.getIntExtra("date",0);


        back = (Button) findViewById(R.id.layout2_b1);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(user_now_order2.this, user_now_order.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("user_id",user_id1);
                intent.putExtra("user_address_detail",user_address_detail1);

                startActivity(intent);
            }
        });

        tv1 = (TextView)findViewById(R.id.s_name);
        tv1.setText(s_name1);

        tv2 = (TextView)findViewById(R.id.date);
        tv2.setText("2020"+date1);


        tv3 = (TextView) findViewById(R.id.address);
        tv3.setText(user_address1);

        tv4 = (TextView)findViewById(R.id.memo);
        tv5 = (TextView) findViewById(R.id.t_price);

        tv7 = (TextView)findViewById(R.id.item_list);

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success"); //php보면 response가 success면 ㄱㄱ
                    if(success){ //회원등록에 성공한 경우
                        memo = jsonObject.getString("memo");
                        if (memo.length()==0){
                            memo = "공란";
                        }
                        t_price = jsonObject.getInt("t_price");
                        items = jsonObject.getString("items");
                        tv7.setText(items);
                        tv4.setText(memo);
                        tv5.setText(t_price+"원");

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
        user_now_order2_db registerRequest = new user_now_order2_db(s_name1,user_id1,date1, responseListener);
        RequestQueue queue = Volley.newRequestQueue(user_now_order2.this);
        queue.add(registerRequest);

    }

    public CharSequence format(int progress, int max) {
        return String.format(DEFAULT_PATTERN, (int) ((float) progress / (float) max * 100));
    }
}
