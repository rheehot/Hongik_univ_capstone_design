package com.example.laundry02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class user_main1 extends AppCompatActivity{

    private DrawerLayout drawerLayout;
    private View drawerView;
    private long backBtnTime = 0;
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    TextView user_address;

    private ListView listView;
    ArrayList<Human> h_info_list;
    HumanAdpter myadapter;
    Human myHuman1,myHuman2,myHuman3;

    String user_name1, user_address1,user_id1;
    Double user_lat1, user_long1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main1);

        Intent intent = getIntent();
        user_name1 = intent.getStringExtra("user_name");
        user_address1 = intent.getStringExtra("user_address");
        user_lat1 = intent.getDoubleExtra("user_lat",0.0);
        user_long1 = intent.getDoubleExtra("user_long",0.0);
        user_id1 = intent.getStringExtra("user_id");


        //액션바 설정하기//
        //액션바 타이틀 변경하기
        getSupportActionBar().setTitle(user_name1+"님 안녕하세요.");
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        user_address = findViewById(R.id.tv1);
        user_address.setText(user_address1);


        listView = (ListView)findViewById(R.id.listView);
        myHuman1 = new Human("하나세탁소", "평점:", "#깨끗", R.drawable.ic_launcher_background);
        myHuman2 = new Human("둘세탁소", "평점", "#피죤",R.drawable.ic_launcher_foreground);
        myHuman3 = new Human("셋세탁소", "평점", "#해시태그", R.drawable.ic_launcher_background);
        h_info_list = new ArrayList<Human>();
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);

        myadapter = new HumanAdpter(getApplicationContext(),R.layout.human_info, h_info_list);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                Intent intent = new Intent(getApplicationContext(), ImageActivity.class); // 다음넘어갈 화면

                intent.putExtra("image",Integer.toString(h_info_list.get(position).getImage()));
                intent.putExtra("name",h_info_list.get(position).getName());
                intent.putExtra("gender",h_info_list.get(position).getGender());
                intent.putExtra("age",h_info_list.get(position).getAge());

                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("user_id",user_id1);

                /*Bitmap sendBitmap = h_info_list.get(position).image;

                ByteArrayOutputStream stream = new ByteArrayOutputStream();
                sendBitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                byte[] byteArray = stream.toByteArray();

                intent.putExtra("image",byteArray);*/
                startActivity(intent);
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

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main1);

        //액션바 설정하기//
        //액션바 타이틀 변경하기
        getSupportActionBar().setTitle("홍길동님 안녕하세요.");
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        *//*menubar= (Button) findViewById(R.id.btn_open);
        menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(user_main1.this , menubar);



                MenuInflater inf = popup.getMenuInflater();
                inf.inflate(R.menu.menu1, popup.getMenu());
                popup.show();
            }
        });*//*


        *//*b1 = (Button) findViewById(R.id.layout6_b1);

        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "이거 씨바라라랄아ㅏ랄압라랍", Toast.LENGTH_SHORT).show();
            }
        });

        b2 = (Button) findViewById(R.id.layout6_b2);

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "12354512523415", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(user_main.this, user_login.class);
                startActivity(intent);
            }
        });*//*



        *//*String[] list = {"하나세탁소(test)","영풍세탁소(test)","홍익세탁소(test)"};

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);

        ListView listview = (ListView)findViewById(R.id.listview);

        listview.setAdapter(adapter);*//*
        listView = (ListView)findViewById(R.id.listView);
        myHuman1 = new Human("하나세탁소", "평점:", "#깨끗", R.drawable.ic_launcher_background);
        myHuman2 = new Human("둘세탁소", "평점", "#피죤",R.drawable.ic_launcher_foreground);
        myHuman3 = new Human("셋세탁소", "평점", "#해시태그", R.drawable.ic_launcher_background);
        h_info_list = new ArrayList<Human>();
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);

        //getApplicationContext() or this
        myadapter = new HumanAdpter(this,R.layout.human_info, h_info_list);
        listView.setAdapter(myadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view,int position, long id) {
                Intent intent = new Intent(user_main1.this, ImageActivity.class); // 다음넘어갈 화면
                intent.putExtra("image",Integer.toString(h_info_list.get(position).getImage()));
                intent.putExtra("name",h_info_list.get(position).getName());
                intent.putExtra("gender",h_info_list.get(position).getGender());
                intent.putExtra("age",h_info_list.get(position).getAge());
                startActivity(intent);

            }
        });*/

        //이값은 디비에서 불러오는걸로
        /*get_text = findViewById(R.id.tv1);
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String set_address = bundle.getString("set_address");

        get_text.setText(""+set_address+"");*/




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();


        switch(item.getItemId()){
            case R.id.b1:
                Intent intent = new Intent(this, user_main1.class);
                intent.putExtra("user_name",user_name1);
                intent.putExtra("user_address",user_address1);
                intent.putExtra("user_lat",user_lat1);
                intent.putExtra("user_long",user_long1);
                intent.putExtra("user_id",user_id1);
                startActivity(intent);
                break;
            case R.id.b2:
                Intent intent1 = new Intent(this, user_gongji.class);
                intent1.putExtra("user_name",user_name1);
                intent1.putExtra("user_address",user_address1);
                intent1.putExtra("user_lat",user_lat1);
                intent1.putExtra("user_long",user_long1);
                intent1.putExtra("user_id",user_id1);
                startActivity(intent1);
                break;
            case R.id.b3:
                Intent intent2 = new Intent(this, user_changelocation.class);
                intent2.putExtra("user_name",user_name1);
                intent2.putExtra("user_address",user_address1);
                intent2.putExtra("user_lat",user_lat1);
                intent2.putExtra("user_long",user_long1);
                intent2.putExtra("user_id",user_id1);
                startActivity(intent2);
                break;
            case R.id.b4:
                Intent intent3 = new Intent(this, user_info.class);
                intent3.putExtra("user_name",user_name1);
                intent3.putExtra("user_address",user_address1);
                intent3.putExtra("user_lat",user_lat1);
                intent3.putExtra("user_long",user_long1);
                intent3.putExtra("user_id",user_id1);
                startActivity(intent3);
                break;
            case R.id.b5:
                Intent intent4 = new Intent(this, user_review.class);
                intent4.putExtra("user_name",user_name1);
                intent4.putExtra("user_address",user_address1);
                intent4.putExtra("user_lat",user_lat1);
                intent4.putExtra("user_long",user_long1);
                intent4.putExtra("user_id",user_id1);
                startActivity(intent4);
                break;
            case R.id.b6:
                Intent intent5 = new Intent(this, user_now_order.class);
                intent5.putExtra("user_name",user_name1);
                intent5.putExtra("user_address",user_address1);
                intent5.putExtra("user_lat",user_lat1);
                intent5.putExtra("user_long",user_long1);
                intent5.putExtra("user_id",user_id1);
                startActivity(intent5);
                break;
            case R.id.b7:
                Intent intent6 = new Intent(this, user_order_record.class);
                intent6.putExtra("user_name",user_name1);
                intent6.putExtra("user_address",user_address1);
                intent6.putExtra("user_lat",user_lat1);
                intent6.putExtra("user_long",user_long1);
                intent6.putExtra("user_id",user_id1);
                startActivity(intent6);
                break;
            case R.id.b8:
                Intent intent7 = new Intent(this, user_logout.class);
                startActivity(intent7);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v){

    }
}
