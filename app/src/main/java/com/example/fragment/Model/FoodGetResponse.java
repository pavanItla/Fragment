package com.example.fragment.Model;

import java.util.List;

public class FoodGetResponse {

    /**
     * status : 1
     * Data : [{"id":"1","image":"http://192.168.0.137/sam1/FoodImages/food5.jpg","text":"Pizza"},{"id":"2","image":"http://192.168.0.137/sam1/FoodImages/food3.jpg\r\n\r\n","text":"Burger"},{"id":"3","image":"http://192.168.0.137/sam1/FoodImages/food1.jpg","text":"Fish Fry"},{"id":"4","image":"http://192.168.0.137/sam1/FoodImages/food4.jpg","text":"Paratha"},{"id":"5","image":"http://192.168.0.137/sam1/FoodImages/food2.jpg","text":"Burger with French Fries"}]
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
         * image : http://192.168.0.137/sam1/FoodImages/food5.jpg
         * text : Pizza
         */

        private String id;
        private String image;
        private String text;

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
    }
}
