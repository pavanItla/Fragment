package com.example.fragment.Model;

public class ProductModel {

    String image;
    String name;
    String price;
    String id;


    public ProductModel(String image, String name, String price, String id) {
        this.image = image;
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}