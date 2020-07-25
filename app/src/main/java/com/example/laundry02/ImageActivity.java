package com.example.laundry02;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ImageActivity extends Activity {
    Bitmap image;
    ImageView BigImage;
    TextView main_title;

    private Button user_main1_back, intoitemlist, intoreview;

    TextView gongji;

    int img;

    String user_name1, user_address1, user_id1, user_address_detail1;
    Double user_lat1, user_long1;
    String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);


        Intent intent = getIntent();
        user_name1 = intent.getStringExtra("user_name");
        user_address1 = intent.getStringExtra("user_address");
        user_lat1 = intent.getDoubleExtra("user_lat",0.0);
        user_long1 = intent.getDoubleExtra("user_long",0.0);
        user_id1 = intent.getStringExtra("user_id");
        user_address_detail1 = intent.getStringExtra("user_address_detail");


        String re_set_title = intent.getStringExtra("title");

        main_title = findViewById(R.id.title1);
        main_title.setText(re_set_title);
        /*title = main_title.getText().toString();*/

        user_main1_back = (Button) findViewById(R.id.layout2_b1);
        user_main1_back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(ImageActivity.this, user_main1.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("user_id",user_id1);
                intent.putExtra("user_address_detail",user_address_detail1);
                startActivity(intent);
            }
        });

        intoitemlist = (Button)findViewById(R.id.intoitemlist);
        intoitemlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageActivity.this, user_itempage.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("title",main_title.getText().toString());
                intent.putExtra("user_id",user_id1);
                intent.putExtra("user_address_detail",user_address_detail1);
                startActivity(intent);
            }
        });

        intoreview = (Button)findViewById(R.id.intoreview);
        intoreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ImageActivity.this, user_storereview.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("name",main_title.getText().toString());
                startActivity(intent);
            }
        });

        gongji = (TextView) findViewById(R.id.gongjiforuser);
        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    boolean success = jsonObject.getBoolean("success"); //php보면 response가 success면 ㄱㄱ
                    if(success){ //회원등록에 성공한 경우
                        String gongji1 = jsonObject.getString("content");
                        a = gongji1;
                        gongji.setText(a);
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
        user_image_db registerRequest = new user_image_db(re_set_title, responseListener);
        RequestQueue queue = Volley.newRequestQueue(ImageActivity.this);
        queue.add(registerRequest);


        /*ImageView store_pic = (ImageView)findViewById(R.id.image1);*/
        /*TextView store_name = (TextView)findViewById(R.id.title1);*/
        /*TextView store_age = (TextView)findViewById(R.id.age1);
        TextView store_gender = (TextView)findViewById(R.id.gender1);*/

        /*store_name.setText(intent.getStringExtra("name"));*/
        /*img=Integer.parseInt(intent.getStringExtra("image"));
        store_pic.setImageResource(img);
        store_age.setText(intent.getStringExtra("age"));
        store_gender.setText(intent.getStringExtra("gender"));*/


        /*BigImage = (ImageView)findViewById(R.id.BigImage);

        Intent intent = getIntent();
        byte[] arr = getIntent().getByteArrayExtra("image");
        image = BitmapFactory.decodeByteArray(arr, 0, arr.length);
        BigImage.setImageBitmap(image);*/
    }
}

/*import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity extends AppCompatActivity {
    private int img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Intent intent = getIntent();

        ImageView store_pic = (ImageView)findViewById(R.id.image1);
        TextView store_name = (TextView)findViewById(R.id.title1);
        TextView store_age = (TextView)findViewById(R.id.age1);
        TextView store_gender = (TextView)findViewById(R.id.gender1);

        store_name.setText(intent.getStringExtra("name"));
        img=Integer.parseInt(intent.getStringExtra("image"));
        store_pic.setImageResource(img);
        store_age.setText(intent.getStringExtra("age"));
        store_gender.setText(intent.getStringExtra("gender"));

    }
}*/
