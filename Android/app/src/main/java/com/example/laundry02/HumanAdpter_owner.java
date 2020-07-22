package com.example.laundry02;

import android.content.Context;
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

public class HumanAdpter_owner extends BaseAdapter {
    /*private Context mContext = null;*/
    private int layout = 0;
    private ArrayList<Human_owner> data;
    private LayoutInflater inflater;

    public HumanAdpter_owner(Context c, int l, ArrayList<Human_owner> d) {
        /*this.mContext = c;*/
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
        Human_owner human = data.get(position);

        TextView Hu_name = (TextView) convertView.findViewById(R.id.Human_name);
        Hu_name.setText(human.getName());

        TextView Hu_gender = (TextView) convertView.findViewById(R.id.Human_gender);
        Hu_gender.setText(human.getGender());

        TextView Hu_age = (TextView) convertView.findViewById(R.id.Human_age);
        Hu_age.setText(human.getAge());



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
