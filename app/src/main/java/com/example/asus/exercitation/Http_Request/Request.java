package com.example.asus.exercitation.Http_Request;

import com.example.asus.exercitation.Url_http.url_image;
import com.example.asus.exercitation.class_Product.HttpMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ASUS on 2018/12/9.
 */
public class Request extends Thread{
    private String result;
    public  void run() {
        try {
            URL url = new URL(url_image.URL +"product");
            HttpURLConnection httpURLConnection  = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod(String.valueOf(HttpMethod.GET));
            httpURLConnection.setConnectTimeout(url_image.TIME_OUT);

            InputStream is = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(is, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String temp ;
            while((temp = bufferedReader.readLine()) != null){
                stringBuffer.append(temp);
            }
            setResult(stringBuffer.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public String getResult() {
        return result;
    }
    public void setResult(String result) {
        this.result = result;
    }
}
