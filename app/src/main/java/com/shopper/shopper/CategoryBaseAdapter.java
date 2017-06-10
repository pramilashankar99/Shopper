package com.shopper.shopper;


import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class CategoryBaseAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Categories> listPojo;

    public CategoryBaseAdapter(Context context, ArrayList<Categories> listPojo) {
        super();
        this.context = context;
        this.listPojo = listPojo;

    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return listPojo.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return listPojo.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        MyViewHolder holder = null;

        if (convertView == null) {

            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(
                    R.layout.list_category, null);

            holder = new MyViewHolder();

            holder.title = (TextView) convertView
                    .findViewById(R.id.title);


            holder.qty = (TextView) convertView
                    .findViewById(R.id.qty);

            holder.image = (ImageView) convertView
                    .findViewById(R.id.image);



            // At here set animation by their position.. Means if position = 0.. then animation start on textview with i*50 = 0 startOffset

            convertView.setTag(holder);

        } else {

            holder = (MyViewHolder) convertView.getTag();
        }

        Categories rowItem = (Categories) getItem(position);
        holder.title.setText(rowItem.getTitle());
        holder.qty.setText(rowItem.getQuantity());
        holder.image.setImageResource(rowItem.getImage());

        return convertView;
    }

    class MyViewHolder {


        private TextView title;
        private TextView qty;
        private ImageView image;



    }


}
