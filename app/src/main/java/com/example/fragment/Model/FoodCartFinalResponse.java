package com.example.fragment.Model;

import java.util.List;

public class FoodCartFinalResponse {


    /**
     * status : 1
     * Data : [{"id":"114","image":"http://192.168.0.149/sam1/FoodImages/food5.jpg","text":"Pizza","price":"150","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"115","image":"http://192.168.0.149/sam1/FoodImages/food3.jpg\r\n\r\n","text":"Burger","price":"120","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"117","image":"http://192.168.0.149/sam1/FoodImages/food1.jpg","text":"Fish Fry","price":"180","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"118","image":"http://192.168.0.149/sam1/FoodImages/food5.jpg","text":"Pizza","price":"150","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"119","image":"http://192.168.0.149/sam1/FoodImages/food3.jpg\r\n\r\n","text":"Burger","price":"120","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"120","image":"http://192.168.0.149/sam1/FoodImages/food1.jpg","text":"Fish Fry","price":"180","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"121","image":"http://192.168.0.149/sam1/FoodImages/food4.jpg","text":"Paratha","price":"115","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null},{"id":"125","image":"http://192.168.0.149/sam1/DrinkImages/drink2.jpg","text":"Nimbu","price":"100","email":"pavanitla@gmail.com","count":"1","UserId":"44","TimeStamp":null}]
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
         * id : 114
         * image : http://192.168.0.149/sam1/FoodImages/food5.jpg
         * text : Pizza
         * price : 150
         * email : pavanitla@gmail.com
         * count : 1
         * UserId : 44
         * TimeStamp : null
         */

        private String id;
        private String image;
        private String text;
        private String price;
        private String email;
        private String count;
        private String UserId;
        private Object TimeStamp;

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

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public Object getTimeStamp() {
            return TimeStamp;
        }

        public void setTimeStamp(Object TimeStamp) {
            this.TimeStamp = TimeStamp;
        }
    }
}
