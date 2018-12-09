package com.example.asus.exercitation.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asus.exercitation.Image_js.imageRotue;
import com.example.asus.exercitation.R;
import com.example.asus.exercitation.class_Product.Product;

import java.util.List;

/**
 * Created by ASUS on 2018/12/9.
 */
public class ShopingAdapter extends ArrayAdapter{
    private int resourceId;
    public ShopingAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        Product product = (Product)getItem(position);
        ProductLayout productLayout = new ProductLayout();
        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            productLayout.titleView = (TextView)view.findViewById(R.id.title_show);
            productLayout.priceView = (TextView)view.findViewById(R.id.price_show);
            productLayout.imgView = (ImageView)view.findViewById(R.id.image_show);
            view.setTag(productLayout);
        } else {
            view = convertView;
            productLayout = (ProductLayout) view.getTag();
        }
        productLayout.titleView.setText(product.getTitle());
        productLayout.priceView.setText(product.getPrice());
        imageRotue imageview = new imageRotue(product.getImage());
        imageview.start();
        try {
            imageview.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productLayout.imgView.setImageBitmap(imageview.getResultBitmap());
        return view;
    }

    class ProductLayout{
        TextView titleView;
        TextView priceView;
        ImageView imgView;
        Button addButton;
    }
}
