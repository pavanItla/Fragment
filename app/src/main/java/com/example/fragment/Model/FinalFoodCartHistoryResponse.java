package com.example.fragment.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FinalFoodCartHistoryResponse {


    /**
     * status : 1
     * Message : success
     * Total : [{"sum(price)":"825"}]
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
        private String _$SumPrice150; // FIXME check this code

        public String get_$SumPrice150() {
            return _$SumPrice150;
        }

        public void set_$SumPrice150(String _$SumPrice150) {
            this._$SumPrice150 = _$SumPrice150;
        }
    }
}
