package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class user_itempage extends Activity {
    private Button b1, gotopocket;

    private ListView listView;
    ArrayList<user_itempage_list> user_item_list;
    user_itempage_Adpter myadapter;
    user_itempage_list list1,list2,list3;

    String user_name1, user_address1;
    Double user_lat1, user_long1;
    String title;

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_itempage);


        //user_id 받아야 할 것
        Intent intent = getIntent();
        user_name1 = intent.getStringExtra("user_name");
        user_address1 = intent.getStringExtra("user_address");
        user_lat1 = intent.getDoubleExtra("user_lat",0.0);
        user_long1 = intent.getDoubleExtra("user_long",0.0);
        title = intent.getStringExtra("name");

        tv1 = findViewById(R.id.title1);
        tv1.setText(title+"-상품");

        //=======================================리스트시작===========================================

        listView = (ListView)findViewById(R.id.listview);
        list1 = new user_itempage_list("코트", "15000원");
        list2 = new user_itempage_list("청바지", "3000원");
        list3 = new user_itempage_list("양말", "300원");
        user_item_list = new ArrayList<user_itempage_list>();
        user_item_list.add(list1);
        user_item_list.add(list2);
        user_item_list.add(list3);
        user_item_list.add(list1);
        user_item_list.add(list2);
        user_item_list.add(list3);
        user_item_list.add(list1);
        user_item_list.add(list2);
        user_item_list.add(list3);

        myadapter = new user_itempage_Adpter(getApplicationContext(),R.layout.user_itempage_info, user_item_list);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class); // 다음넘어갈 화면

                /*intent.putExtra("image",Integer.toString(h_info_list.get(position).getImage()));
                intent.putExtra("name",h_info_list.get(position).getName());
                intent.putExtra("gender",h_info_list.get(position).getGender());
                intent.putExtra("age",h_info_list.get(position).getAge());

                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);*/

                /*Bitmap sendBitmap = h_info_list.get(position).image;

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("image",byteArray);*/
                startActivity(intent);
            }
        });


        b1 = (Button) findViewById(R.id.layout2_b1);
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(user_itempage.this, ImageActivity.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("name",title);
                startActivity(intent);
            }
        });

        gotopocket = (Button) findViewById(R.id.gotopocket);
        gotopocket.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(user_itempage.this, user_itembasket.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("name",title);
                startActivity(intent);
            }
        });

    }
}
