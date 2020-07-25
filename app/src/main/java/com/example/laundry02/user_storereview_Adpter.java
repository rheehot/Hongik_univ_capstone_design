package com.example.laundry02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class user_storereview_Adpter extends BaseAdapter {
    private Context mContext = null;
    private int layout = 0;
    private ArrayList<user_storereview_list> data = null;
    private LayoutInflater inflater = null;

    public user_storereview_Adpter(Context c, int l, ArrayList<user_storereview_list> d) {
        this.mContext = c;
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return data;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        /*ImageView Hu_image = (ImageView) convertView.findViewById(R.id.Human_image);*/
        TextView user_id = (TextView) convertView.findViewById(R.id.user_id);
        TextView score = (TextView) convertView.findViewById(R.id.score);
        TextView content = (TextView) convertView.findViewById(R.id.content);

        /*TextView Hu_age = (TextView) convertView.findViewById(R.id.Human_age);*/

        /*Hu_image.setImageResource(data.get(position).image);*/
        user_id.setText(data.get(position).user_id);
        score.setText(data.get(position).score+"");
        content.setText(data.get(position).content);
        /*Hu_age.setText(data.get(position).age);*/

        /*LinearLayout a = (LinearLayout) convertView.findViewById(R.id.intothestore);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "아아아",Toast.LENGTH_SHORT).show();
            }
        });*/

        return convertView;
    }
}


/*import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HumanAdpter extends BaseAdapter {
    *//*private Context mContext = null;*//*
    private int layout = 0;
    private ArrayList<Human> data;
    private LayoutInflater inflater;

    public HumanAdpter(Context c, int l, ArrayList<Human> d) {
        *//*this.mContext = c;*//*
        this.layout = l;
        this.data = d;
        this.inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return data.size();
    }

    @Override
    public String getItem(int position) {
        // TODO Auto-generated method stub
        return data.get(position).getName();
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        if(convertView == null) {
            convertView = inflater.inflate(this.layout, parent, false);
        }
        Human human = data.get(position);

        ImageView Hu_image = (ImageView) convertView.findViewById(R.id.Human_image);
        Hu_image.setImageResource(human.getImage());

        TextView Hu_name = (TextView) convertView.findViewById(R.id.Human_name);
        Hu_name.setText(human.getName());

        TextView Hu_gender = (TextView) convertView.findViewById(R.id.Human_gender);
        Hu_gender.setText(human.getGender());

        TextView Hu_age = (TextView) convertView.findViewById(R.id.Human_age);
        Hu_age.setText(human.getAge());


        *//*LinearLayout a = (LinearLayout) convertView.findViewById(R.id.intothestore);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "아아아",Toast.LENGTH_SHORT).show();
            }
        });*//*

        return convertView;
    }
}*/

