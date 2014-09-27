package com.devahoy.android.spinnerdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by creatived on 9/27/14.
 */
public class CustomAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mData;
    private LayoutInflater mInflater;

    public CustomAdapter(Context context, ArrayList<String> data) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item_adapter, parent, false);
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.logo = (ImageView) convertView.findViewById(R.id.logo);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        int imgResourceId;
        switch (position) {
            case 0:
                imgResourceId = android.R.drawable.ic_menu_share;
                break;
            case 1:
                imgResourceId = android.R.drawable.ic_menu_call;
                break;
            case 2:
                imgResourceId = android.R.drawable.ic_menu_camera;
                break;
            case 3:
                imgResourceId = android.R.drawable.ic_menu_search;
                break;
            default:
                imgResourceId = android.R.drawable.ic_menu_zoom;
                break;
        }

        holder.name.setText(mData.get(position));
        holder.logo.setImageResource(imgResourceId);

        convertView.setTag(holder);

        return convertView;
    }

    public class ViewHolder {
        TextView name;
        ImageView logo;
    }
}
