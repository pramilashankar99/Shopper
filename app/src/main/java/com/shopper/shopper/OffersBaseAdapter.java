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


public class OffersBaseAdapter extends BaseAdapter {

    Context context;

    ArrayList<OffersBean> bean;


    public OffersBaseAdapter(Context context, ArrayList<OffersBean> bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public int getCount() {
        return bean.size();
    }

    @Override
    public Object getItem(int position) {
        return bean.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.a_homepage_offers, null);
            viewHolder = new ViewHolder();
            viewHolder.Shops_near_you_image = (ImageView) convertView.findViewById(R.id.Shops_near_you_image);
            viewHolder.rest_name = (TextView) convertView.findViewById(R.id.rest_name);
            viewHolder.condi_text = (TextView) convertView.findViewById(R.id.condi_text);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        OffersBean bean = (OffersBean) getItem(position);
        viewHolder.Shops_near_you_image.setImageResource(bean.getDiscount_image());
        viewHolder.rest_name.setText(bean.getRest_name());
        viewHolder.condi_text.setText(bean.getCondi_text());
        return convertView;
    }

    private class ViewHolder {
        ImageView Shops_near_you_image;
        TextView rest_name;
        TextView condi_text;
    }
}




