package com.example.fragment.Model;

import java.util.List;

public class DrinkImageResponse {


    /**
     * status : 1
     * Data : [{"id":"101","image":"http://192.168.0.137/sam1/DrinkImages/drink1.png","text":"WaterMellon","price":"220"},{"id":"102","image":"http://192.168.0.137/sam1/DrinkImages/drink2.jpg","text":"Nimbu","price":"100"}]
     */

    private int status;
    private List<DataBean> Data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * id : 101
         * image : http://192.168.0.137/sam1/DrinkImages/drink1.png
         * text : WaterMellon
         * price : 220
         */

        private String id;
        private String image;
        private String text;
        private String price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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
}
