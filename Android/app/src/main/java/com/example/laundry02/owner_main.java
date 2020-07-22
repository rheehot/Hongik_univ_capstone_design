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

public class owner_main extends AppCompatActivity{

    private DrawerLayout drawerLayout;
    private View drawerView;
    private long backBtnTime = 0;
    Button b1,b2,b3,b4,b5,b6,b7,b8;
    TextView get_text;

    private ListView listView;
    ArrayList<Human_owner> h_info_list;
    HumanAdpter_owner myadapter_owner;
    Human_owner myHuman1,myHuman2,myHuman3;

    String owner_name1, owner_address1;
    Double owner_lat1, owner_long1;

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
        setContentView(R.layout.activity_owner_main);

        Intent intent = getIntent();
        owner_name1 = intent.getStringExtra("owner_name");
        owner_address1 = intent.getStringExtra("owner_address");
        owner_lat1 = intent.getDoubleExtra("owner_lat",0.0);
        owner_long1 = intent.getDoubleExtra("owner_long",0.0);

        //액션바 설정하기//
        //액션바 타이틀 변경하기
        getSupportActionBar().setTitle(owner_name1+"사장님 안녕하세요.");
        //액션바 배경색 변경
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(0xFF339999));
        //홈버튼 표시
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*menubar= (Button) findViewById(R.id.btn_open);
        menubar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(user_main1.this , menubar);



                MenuInflater inf = popup.getMenuInflater();
                inf.inflate(R.menu.menu1, popup.getMenu());
                popup.show();
            }
        });*/


        /*b1 = (Button) findViewById(R.id.layout6_b1);

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
        });*/

        listView = (ListView)findViewById(R.id.listview);
        myHuman1 = new Human_owner("주소: 임시주소입니다.", "ID: abc123", "번호: 01024357578");
        myHuman2 = new Human_owner("주소: 서울특별시 ", "ID: q1rw3", "번호: 01023445677");
        myHuman3 = new Human_owner("주소: 세종특별자치시", "ID: ihave", "번호: 01035455721");
        h_info_list = new ArrayList<Human_owner>();
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);
        h_info_list.add(myHuman1);
        h_info_list.add(myHuman2);
        h_info_list.add(myHuman3);

        //getApplicationContext() or this
        myadapter_owner = new HumanAdpter_owner(this,R.layout.human_info_owner, h_info_list);
        listView.setAdapter(myadapter_owner);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view,int position, long id) {
                Intent intent = new Intent(owner_main.this, ImageActivity_owner.class); // 다음넘어갈 화면
                intent.putExtra("name",h_info_list.get(position).getName());
                intent.putExtra("gender",h_info_list.get(position).getGender());
                intent.putExtra("age",h_info_list.get(position).getAge());
                startActivity(intent);

            }
        });

        /*String[] list = {"하나세탁소(test)","영풍세탁소(test)","홍익세탁소(test)"};

        ArrayAdapter<String> adapter;

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, list);

        ListView listview = (ListView)findViewById(R.id.listview);

        listview.setAdapter(adapter);*/


        //이값은 디비에서 불러오는걸로
        /*get_text = findViewById(R.id.tv1);
        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String set_address = bundle.getString("set_address");

        get_text.setText(""+set_address+"");*/



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu2, menu);
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
                Intent intent = new Intent(this, owner_main.class);
                intent.putExtra("owner_name",owner_name1);
                intent.putExtra("owner_address",owner_address1);
                intent.putExtra("owner_lat",owner_lat1);
                intent.putExtra("owner_long",owner_long1);
                startActivity(intent);
                break;
            case R.id.b2:
                Intent intent1 = new Intent(this, owner_order_y_n.class);
                intent1.putExtra("owner_name",owner_name1);
                intent1.putExtra("owner_address",owner_address1);
                intent1.putExtra("owner_lat",owner_lat1);
                intent1.putExtra("owner_long",owner_long1);
                startActivity(intent1);
                break;
            case R.id.b3:
                Intent intent2 = new Intent(this, owner_item_add_del.class);
                intent2.putExtra("owner_name",owner_name1);
                intent2.putExtra("owner_address",owner_address1);
                intent2.putExtra("owner_lat",owner_lat1);
                intent2.putExtra("owner_long",owner_long1);
                startActivity(intent2);
                break;
            case R.id.b4:
                Intent intent3 = new Intent(this, owner_gongji_management.class);
                intent3.putExtra("owner_name",owner_name1);
                intent3.putExtra("owner_address",owner_address1);
                intent3.putExtra("owner_lat",owner_lat1);
                intent3.putExtra("owner_long",owner_long1);
                startActivity(intent3);
                break;
            case R.id.b5:
                Intent intent4 = new Intent(this, owner_info.class);
                intent4.putExtra("owner_name",owner_name1);
                intent4.putExtra("owner_address",owner_address1);
                intent4.putExtra("owner_lat",owner_lat1);
                intent4.putExtra("owner_long",owner_long1);
                startActivity(intent4);
                break;
            case R.id.b6:
                Intent intent5 = new Intent(this, owner_review_management.class);
                intent5.putExtra("owner_name",owner_name1);
                intent5.putExtra("owner_address",owner_address1);
                intent5.putExtra("owner_lat",owner_lat1);
                intent5.putExtra("owner_long",owner_long1);
                startActivity(intent5);
                break;
            case R.id.b7:
                Intent intent6 = new Intent(this, owner_logout.class);
                startActivity(intent6);
                break;


        }

        return super.onOptionsItemSelected(item);
    }
    public void onClick(View v){

    }
}
