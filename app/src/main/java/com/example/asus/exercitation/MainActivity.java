package com.example.asus.exercitation;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.example.asus.exercitation.Adapter.ShopingAdapter;
import com.example.asus.exercitation.Http_Request.Request;
import com.example.asus.exercitation.class_Product.Product;

import java.util.Arrays;
import java.util.List;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Request http_Thread = new Request();
        http_Thread.start();
        try {
            http_Thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Product> list =
                JSON.parseArray(http_Thread.getResult(),Product.class);
        ShopingAdapter adapter = new ShopingAdapter(
                this, R.layout.shopping_show, list
        );
        ListView listView = (ListView)findViewById(R.id.list_show);
        listView.setAdapter(adapter);
    }

}
