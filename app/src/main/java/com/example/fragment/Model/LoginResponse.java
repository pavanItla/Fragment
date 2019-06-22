package com.example.fragment.Model;

import java.util.List;

public class LoginResponse {


    /**
     * status : 1
     * Data : [{"UserId":"84","email":"sai@gmail.com","name":"sai","number":"8978864570"}]
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
         * UserId : 84
         * email : sai@gmail.com
         * name : sai
         * number : 8978864570
         */

        private String UserId;
        private String email;
        private String name;
        private String number;

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
