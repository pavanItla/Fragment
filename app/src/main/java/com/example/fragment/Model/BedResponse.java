package com.example.fragment.Model;

import java.util.List;

public class BedResponse {


    /**
     * status : 1
     * Data : [{"id":"76","areaname":"novotel","username":"dfdsf","phoneno":"dfdfd","noofadults":"dfdfd","noofchilds":"dfdf","Date":"","typeofbed":"fgfgfg","address":"kllkl;kl;k","email":"pavanitla@gmail.com"},{"id":"77","areaname":null,"username":"pavan","phoneno":"8978864570","noofadults":"2","noofchilds":"3","Date":"","typeofbed":"Single Bed","address":"Near R.K beach, vskp.","email":"pavanitla@gmail.com"},{"id":"78","areaname":null,"username":"pavan","phoneno":"djdjsjsj","noofadults":"3","noofchilds":"2","Date":"","typeofbed":"Double Bed","address":"Near R.K beach, vskp.","email":"pavanitla@gmail.com"},{"id":"79","areaname":"VARUN BEACH","username":"skksksks","phoneno":"sksksksksk","noofadults":"2","noofchilds":"1","Date":"","typeofbed":"Double Bed","address":"Near R.K beach, vskp.","email":"pavanitla@gmail.com"},{"id":"80","areaname":"VARUN BEACH","username":"vandana","phoneno":"59595959","noofadults":"2","noofchilds":"1","Date":"30-6-2019","typeofbed":"Single Bed","address":"Near R.K beach, vskp.","email":"pavanitla@gmail.com"},{"id":"81","areaname":"HOTEL TAJ","username":"pavan itla","phoneno":"8978864570","noofadults":"2","noofchilds":"Child","Date":"29-6-2019","typeofbed":"Single Bed","address":"Chinna Waltair Main Rd, vskp","email":"pavanitla@gmail.com"}]
     * email : pavanitla@gmail.com
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
         * id : 76
         * areaname : novotel
         * username : dfdsf
         * phoneno : dfdfd
         * noofadults : dfdfd
         * noofchilds : dfdf
         * Date :
         * typeofbed : fgfgfg
         * address : kllkl;kl;k
         * email : pavanitla@gmail.com
         */

        private String id;
        private String areaname;
        private String username;
        private String phoneno;
        private String noofadults;
        private String noofchilds;
        private String Date;
        private String typeofbed;
        private String address;
        private String email;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getAreaname() {
            return areaname;
        }

        public void setAreaname(String areaname) {
            this.areaname = areaname;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPhoneno() {
            return phoneno;
        }

        public void setPhoneno(String phoneno) {
            this.phoneno = phoneno;
        }

        public String getNoofadults() {
            return noofadults;
        }

        public void setNoofadults(String noofadults) {
            this.noofadults = noofadults;
        }

        public String getNoofchilds() {
            return noofchilds;
        }

        public void setNoofchilds(String noofchilds) {
            this.noofchilds = noofchilds;
        }

        public String getDate() {
            return Date;
        }

        public void setDate(String Date) {
            this.Date = Date;
        }

        public String getTypeofbed() {
            return typeofbed;
        }

        public void setTypeofbed(String typeofbed) {
            this.typeofbed = typeofbed;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
