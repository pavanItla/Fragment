package com.example.fragment.Model;

import java.util.List;

public class CarImageResponse {


    /**
     * status : 1
     * Data : [{"id":"1","image":"http://192.168.0.137/sam/carimages/car.png","text":"Baleno","fuel":"Petrol","price":"50.6/hr"},{"id":"2","image":"http://192.168.0.137/sam/carimages/cart1.png\r\n","text":"Suzuki","fuel":"Diesel","price":"53.12/hr"},{"id":"3","image":"http://192.168.0.137/sam/carimages/cart2.png\r\n","text":"Suzuki","fuel":"Diesel","price":"48.32/hr"},{"id":"4","image":"http://192.168.0.137/sam/carimages/cart3.png\r\n","text":"Volks Wagon","fuel":"Petrol","price":"52.25/hr"},{"id":"5","image":"http://192.168.0.137/sam/carimages/cart4.png","text":"Toyota","fuel":"Diesel","price":"55/hr"}]
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
         * id : 1
         * image : http://192.168.0.137/sam/carimages/car.png
         * text : Baleno
         * fuel : Petrol
         * price : 50.6/hr
         */

        private String id;
        private String image;
        private String text;
        private String fuel;
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

        public String getFuel() {
            return fuel;
        }

        public void setFuel(String fuel) {
            this.fuel = fuel;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
