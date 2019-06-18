package com.example.fragment.Model;

import java.util.List;

public class BikeResponse {


    /**
     * status : 1
     * Data : [{"id":"5","bikenameget":"Avenger","Name_On_Driving_License":"Vandana","Driving_License_No":"MP12345678912345","Mobile_No":"9784516325","Date":"8-6-2019","Pick_Up_Point":"Visakhapatnam Airport","Start_Time":"02:00 PM","End_Time":"02:00 PM","email":"pavanitla@gmail.com"},{"id":"4","bikenameget":"Royal Enfield","Name_On_Driving_License":"gsjsjdb","Driving_License_No":"CX18452451245124","Mobile_No":"1236985478","Date":"6-6-2019","Pick_Up_Point":"Daba Gardens","Start_Time":"02:00 PM","End_Time":"02:00 PM","email":"pavanitla@gmail.com"},{"id":"3","bikenameget":"Chooper","Name_On_Driving_License":"indu","Driving_License_No":"AP14253698701234","Mobile_No":"8886044450","Date":"8-6-2019","Pick_Up_Point":"Daba Gardens","Start_Time":"12:00 PM","End_Time":"11:00 AM","email":"vasavi@gmail.com"},{"id":"2","bikenameget":"Honda","Name_On_Driving_License":"hfhfhf","Driving_License_No":"AB22222222222222","Mobile_No":"8978864570","Date":"29-6-2019","Pick_Up_Point":"Beach Road(R.K)","Start_Time":"02:00 PM","End_Time":"01:00 PM","email":"pavanitla@gmail.com"},{"id":"1","bikenameget":"Avenger","Name_On_Driving_License":"futdjtdmg","Driving_License_No":"DS65236523652365","Mobile_No":"5236985236","Date":"31-5-2019","Pick_Up_Point":"R.T.C Complex","Start_Time":"02:00 PM","End_Time":"02:00 PM","email":"vandu@gmail.com"}]
     * email : null
     */

    private int status;
    private Object email;
    private List<DataBean> Data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getEmail() {
        return email;
    }

    public void setEmail(Object email) {
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
         * id : 5
         * bikenameget : Avenger
         * Name_On_Driving_License : Vandana
         * Driving_License_No : MP12345678912345
         * Mobile_No : 9784516325
         * Date : 8-6-2019
         * Pick_Up_Point : Visakhapatnam Airport
         * Start_Time : 02:00 PM
         * End_Time : 02:00 PM
         * email : pavanitla@gmail.com
         */

        private String id;
        private String bikenameget;
        private String Name_On_Driving_License;
        private String Driving_License_No;
        private String Mobile_No;
        private String Date;
        private String Pick_Up_Point;
        private String Start_Time;
        private String End_Time;
        private String email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getBikenameget() {
            return bikenameget;
        }

        public void setBikenameget(String bikenameget) {
            this.bikenameget = bikenameget;
        }

        public String getName_On_Driving_License() {
            return Name_On_Driving_License;
        }

        public void setName_On_Driving_License(String Name_On_Driving_License) {
            this.Name_On_Driving_License = Name_On_Driving_License;
        }

        public String getDriving_License_No() {
            return Driving_License_No;
        }

        public void setDriving_License_No(String Driving_License_No) {
            this.Driving_License_No = Driving_License_No;
        }

        public String getMobile_No() {
            return Mobile_No;
        }

        public void setMobile_No(String Mobile_No) {
            this.Mobile_No = Mobile_No;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }

        public String getPick_Up_Point() {
            return Pick_Up_Point;
        }

        public void setPick_Up_Point(String Pick_Up_Point) {
            this.Pick_Up_Point = Pick_Up_Point;
        }

        public String getStart_Time() {
            return Start_Time;
        }

        public void setStart_Time(String Start_Time) {
            this.Start_Time = Start_Time;
        }

        public String getEnd_Time() {
            return End_Time;
        }

        public void setEnd_Time(String End_Time) {
            this.End_Time = End_Time;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
