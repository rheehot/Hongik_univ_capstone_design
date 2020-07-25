package com.example.laundry02;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class owner_main_Adpter extends RecyclerView.Adapter<owner_main_Adpter.CustomViewHolder> {

    private ArrayList<owner_main1_list> mList = null;
    private Activity context = null;
    /*String var_name = ((user_main1)user_main1.context).var_name;*/


    String owner_name;
    String owner_address;
    Double owner_lat;
    Double owner_long;
    String store_name;


    public owner_main_Adpter(Activity context, ArrayList<owner_main1_list> list, String owner_name, String owner_address,
                             Double owner_lat, Double owner_long, String store_name) {
        this.context = context;
        this.mList = list;
        this.owner_name = owner_name;
        this.owner_address = owner_address;
        this.owner_lat = owner_lat;
        this.owner_long = owner_long;
        this.store_name = store_name;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView u_id;
        protected TextView u_pw;
        protected TextView u_address;
        protected LinearLayout intothestore;


        public CustomViewHolder(View view) {
            super(view);
            this.u_id = (TextView) view.findViewById(R.id.u_id);
            this.u_pw = (TextView) view.findViewById(R.id.u_pw);
            this.u_address = (TextView) view.findViewById(R.id.u_address);
            this.intothestore = (LinearLayout) view.findViewById(R.id.intothestore);
        }


    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.human_info_owner, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, final int position) {

        viewholder.u_address.setText(mList.get(position).getMember_u_address());
        viewholder.u_id.setText(mList.get(position).getMember_u_id());
        viewholder.u_pw.setText(mList.get(position).getMember_u_pw());
        viewholder.intothestore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context.getApplicationContext(),ImageActivity_owner.class);

                /*intent.putExtra("image",Integer.toString(mList.get(position).getImage()));*/
                intent.putExtra("u_address",mList.get(position).getMember_u_address());
                intent.putExtra("u_id",mList.get(position).getMember_u_id());
                intent.putExtra("u_pw",mList.get(position).getMember_u_pw());

                intent.putExtra("owner_name",owner_name);
                intent.putExtra("owner_address",owner_address);
                intent.putExtra("owner_lat",owner_lat);
                intent.putExtra("owner_long",owner_long);
                intent.putExtra("store_name",store_name);
                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }





}
