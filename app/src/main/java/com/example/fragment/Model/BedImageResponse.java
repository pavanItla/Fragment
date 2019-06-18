package com.example.fragment.Model;

import java.util.List;

public class BedImageResponse {


    /**
     * status : 1
     * Data : [{"id":"1","image":"http://192.168.0.149/sam1/bedimages/Hotel1.jpg","text":"Varun Beach","address":"Near R.K beach, vskp."},{"id":"2","image":"http://192.168.0.149/sam1/bedimages/Hotel2.jpg","text":"Taj Hotel","address":"Chinna Waltair Main Rd, vskp"},{"id":"3","image":"http://192.168.0.149/sam1/bedimages/Hotel3.jpg","text":"Novotel","address":"Beach Road,Maharani Peta, Vskp. "}]
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
         * image : http://192.168.0.149/sam1/bedimages/Hotel1.jpg
         * text : Varun Beach
         * address : Near R.K beach, vskp.
         */

        private String id;
        private String image;
        private String text;
        private String address;

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

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }
    }
}
