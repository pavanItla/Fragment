package com.example.fragment.Model;


import java.util.List;

public class BikeImageResponse {


    /**
     * status : 1
     * Data : [{"id":"1","image":"http://192.168.0.137/sam1/BikeImages/bike1.png","text":"Royal Enfield","Price":"12.20/hr"},{"id":"2","image":"http://192.168.0.137/sam1/BikeImages/bike2.png","text":"Harley Davidson","Price":"30.50/hr"},{"id":"3","image":"http://192.168.0.137/sam1/BikeImages/bike3.png","text":"Honda","Price":"8.10/hr"},{"id":"4","image":"http://192.168.0.137/sam1/BikeImages/bike4.jpg","text":"Avenger","Price":"13.10/hr"},{"id":"5","image":"http://192.168.0.137/sam1/BikeImages/bike5.jpg","text":"Chooper","Price":"20.30/hr"}]
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
         * image : http://192.168.0.137/sam1/BikeImages/bike1.png
         * text : Royal Enfield
         * Price : 12.20/hr
         */

        private String id;
        private String image;
        private String text;
        private String Price;

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
            return Price;
        }

        public void setPrice(String Price) {
            this.Price = Price;
        }
    }
}
