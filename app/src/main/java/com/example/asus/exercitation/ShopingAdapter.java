package com.example.asus.exercitation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
/**
 * Created by ASUS on 2018/12/9.
 */
public class ShopingAdapter extends ArrayAdapter{
    private int resourceId;
    public ShopingAdapter(Context context, int resource, Object[] objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        getItem(position);
        View view  = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        return view;
    }


}
