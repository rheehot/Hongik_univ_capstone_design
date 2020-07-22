package com.example.laundry02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class owner_item_add_del extends AppCompatActivity {
    String owner_name1, owner_address1;
    Double owner_lat1, owner_long1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner_item_add_del);

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
