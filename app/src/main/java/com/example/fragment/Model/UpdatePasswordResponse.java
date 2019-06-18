package com.example.fragment.Model;

public class UpdatePasswordResponse {


    /**
     * status : 1
     * Message : Password updated
     */

    private int status;
    private String Message;

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
}
