package com.example.fragment.Model;

import java.util.List;

public class TotalPriceREsponse {


    /**
     * status : 1
     * Message : success
     * Data : [{"id":"20","price":"905","email":"vandu@gmail.com"}]
     */

    private int status;
    private String Message;
    private List<DataBean> Data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * id : 20
         * price : 905
         * email : vandu@gmail.com
         */

        private String id;
        private String price;
        private String email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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
    }
}
