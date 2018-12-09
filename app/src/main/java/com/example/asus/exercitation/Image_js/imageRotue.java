package com.example.asus.exercitation.Image_js;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.example.asus.exercitation.Url_http.url_image;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ASUS on 2018/12/9.
 */
public class imageRotue extends Thread{
    /*
    * 传入参数
    * */
    private String imageUrl;

    /*
    * 传出参数
    * */
    private Bitmap resultBitmap;

    public imageRotue(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Bitmap getResultBitmap() {
        return resultBitmap;
    }

    public void setResultBitmap(Bitmap resultBitmap) {
        this.resultBitmap = resultBitmap;
    }

    @Override
    public void run() {
        try {
            URL url = new URL(url_image.URL + imageUrl);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            setResultBitmap(BitmapFactory.decodeStream(inputStream));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
