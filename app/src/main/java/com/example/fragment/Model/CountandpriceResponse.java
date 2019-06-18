package com.example.fragment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountandpriceResponse {


    /**
     * status : 1
     * Message : Count Added
     * Total : [{"sum(price)":"1605"}]
     */

    private int status;
    private String Message;
    private List<TotalBean> Total;

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

    public List<TotalBean> getTotal() {
        return Total;
    }

    public void setTotal(List<TotalBean> Total) {
        this.Total = Total;
    }

    public static class TotalBean {
        @SerializedName("sum(price)")
        private String _$SumPrice81; // FIXME check this code

        public String get_$SumPrice81() {
            return _$SumPrice81;
        }

        public void set_$SumPrice81(String _$SumPrice81) {
            this._$SumPrice81 = _$SumPrice81;
        }
    }
}
