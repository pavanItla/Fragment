package com.example.fragment.Model;

import java.util.List;

public class CarResponse {


    /**
     * status : 1
     * Data : [{"id":"17","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"16","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"15","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"14","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"13","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"12","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"11","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"10","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"9","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"8","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"7","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"6","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"5","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"4","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"3","carnameget":"Suzuki","Name":"indu","Mobile_no":"8886044450","Pick_up_point":"Daba Gardens","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"2","email":"vasavi@gmail.com"},{"id":"2","carnameget":"baleno","Name":"uxfxjfxjf","Mobile_no":"6523658965","Pick_up_point":"R.T.C Complex","Drop_off_point":"Daba Gardens","start_time":"12:00 PM","no_of_persons":"3","email":"vandu@gmail.com"},{"id":"1","carnameget":"baleno","Name":"hah","Mobile_no":"6444444444","Pick_up_point":"Beach Road(R.K)","Drop_off_point":"Visakhapatnam Airpor","start_time":"01:00 PM","no_of_persons":"1","email":"vandu@gmail.com"}]
     * email : pavanitla@gmai.com
     */

    private int status;
    private String email;
    private List<DataBean> Data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        /**
         * id : 17
         * carnameget : Suzuki
         * Name : indu
         * Mobile_no : 8886044450
         * Pick_up_point : Daba Gardens
         * Drop_off_point : Daba Gardens
         * start_time : 12:00 PM
         * no_of_persons : 2
         * email : vasavi@gmail.com
         */

        private String id;
        private String carnameget;
        private String Name;
        private String Mobile_no;
        private String Pick_up_point;
        private String Drop_off_point;
        private String start_time;
        private String no_of_persons;
        private String email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getCarnameget() {
            return carnameget;
        }

        public void setCarnameget(String carnameget) {
            this.carnameget = carnameget;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public String getMobile_no() {
            return Mobile_no;
        }

        public void setMobile_no(String Mobile_no) {
            this.Mobile_no = Mobile_no;
        }

        public String getPick_up_point() {
            return Pick_up_point;
        }

        public void setPick_up_point(String Pick_up_point) {
            this.Pick_up_point = Pick_up_point;
        }

        public String getDrop_off_point() {
            return Drop_off_point;
        }

        public void setDrop_off_point(String Drop_off_point) {
            this.Drop_off_point = Drop_off_point;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getNo_of_persons() {
            return no_of_persons;
        }

        public void setNo_of_persons(String no_of_persons) {
            this.no_of_persons = no_of_persons;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
