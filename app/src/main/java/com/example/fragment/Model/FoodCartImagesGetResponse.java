package com.example.fragment.Model;

import java.util.List;

public class FoodCartImagesGetResponse {


    /**
     * status : 1
     * Data : [{"id":"50","image":"http://192.168.0.137/sam1/FoodImages/food5.jpg","text":"Pizza","price":"450","email":"pavanitla@gmail.com","count":"3"}]
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
         * id : 50
         * image : http://192.168.0.137/sam1/FoodImages/food5.jpg
         * text : Pizza
         * price : 450
         * email : pavanitla@gmail.com
         * count : 3
         */

        private String id;
        private String image;
        private String text;
        private String price;
        private String email;
        private String count;

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
    }
}
