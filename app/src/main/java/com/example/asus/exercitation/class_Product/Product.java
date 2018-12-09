package com.example.asus.exercitation.class_Product;

/**
 * Created by ASUS on 2018/12/9.
 */
public class Product {
    private String title;
    private String price;
    private String image;
    private int id;
    private  int num;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Product(){

    }
    public Product(String title,String price){
        this.title =title;
        this.price =price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
