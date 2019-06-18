package com.example.fragment.Model;

public class Modelfood {

    private int img;
    private String text;
    private String price;

    public Modelfood(int img, String text, String price) {
        this.img = img;
        this.text = text;
        this.price=price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
