package com.example.fragment.Model;

public class CountModel {

    String image;
    String itemName;
    String price;
    int count;

    public CountModel(String image, String itemName, String price, int count) {
        this.image = image;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void set(int position, int i) {
    }
}

