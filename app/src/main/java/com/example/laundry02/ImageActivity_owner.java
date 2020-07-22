package com.example.laundry02;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ImageActivity_owner extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_owner);

        Intent intent = getIntent();

        TextView store_name = (TextView)findViewById(R.id.title1);
        TextView store_age = (TextView)findViewById(R.id.age1);
        TextView store_gender = (TextView)findViewById(R.id.gender1);

        store_name.setText(intent.getStringExtra("name"));
        store_age.setText(intent.getStringExtra("age"));
        store_gender.setText(intent.getStringExtra("gender"));

    }
}
