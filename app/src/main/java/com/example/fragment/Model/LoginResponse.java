package com.example.fragment.Model;

import java.util.List;

public class LoginResponse {


    /**
     * status : 1
     * Data : [{"UserId":"44","name":"pavan","email":"pavanitla@gmail.com","password":"pavan itla","number":"8099553322"}]
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
         * UserId : 44
         * name : pavan
         * email : pavanitla@gmail.com
         * password : pavan itla
         * number : 8099553322
         */

        private String UserId;
        private String name;
        private String email;
        private String password;
        private String number;

        public String getUserId() {
            return UserId;
        }

        public void setUserId(String UserId) {
            this.UserId = UserId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }
    }
}
