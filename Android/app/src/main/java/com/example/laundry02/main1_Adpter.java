package com.example.laundry02;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class main1_Adpter extends RecyclerView.Adapter<main1_Adpter.CustomViewHolder> {

    private ArrayList<main1_list> mList = null;
    private Activity context = null;
    /*String var_name = ((user_main1)user_main1.context).var_name;*/
    public user_main1 um1 = new user_main1();

    String user_name;
    String user_address;
    Double user_lat;
    Double user_long;
    String user_id;
    String user_address_detail;



    public main1_Adpter(Activity context, ArrayList<main1_list> list, String user_name, String user_address,
                        Double user_lat, Double user_long, String user_id, String user_address_detail) {
        this.context = context;
        this.mList = list;
        this.user_name = user_name;
        this.user_address = user_address;
        this.user_lat = user_lat;
        this.user_long = user_long;
        this.user_id = user_id;
        this.user_address_detail = user_address_detail;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView o_id;
        protected TextView s_name;
        protected TextView o_pw;
        protected LinearLayout intothestore;


        public CustomViewHolder(View view) {
            super(view);
            this.s_name = (TextView) view.findViewById(R.id.s_name);
            this.o_id = (TextView) view.findViewById(R.id.o_id);
            this.o_pw = (TextView) view.findViewById(R.id.o_pw);
            this.intothestore = (LinearLayout) view.findViewById(R.id.intothestore);
        }


    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.human_info, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, final int position) {

        viewholder.s_name.setText(mList.get(position).getMember_s_name());
        viewholder.o_id.setText(mList.get(position).getMember_o_id());
        viewholder.o_pw.setText(mList.get(position).getMember_o_pw());
        viewholder.intothestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(),ImageActivity.class);

                /*intent.putExtra("image",Integer.toString(mList.get(position).getImage()));*/
                intent.putExtra("title",mList.get(position).getMember_s_name());
                intent.putExtra("gender",mList.get(position).getMember_o_id());
                intent.putExtra("age",mList.get(position).getMember_o_pw());

                intent.putExtra("user_name",user_name);
                intent.putExtra("user_address",user_address);
                intent.putExtra("user_lat",user_lat);
                intent.putExtra("user_long",user_long);
                intent.putExtra("user_id",user_id);
                intent.putExtra("user_address_detail",user_address_detail);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }





}
