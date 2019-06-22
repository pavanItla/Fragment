package com.example.fragment.Model;

public class BookbedResponse {


    /**
     * Status : 1
     * Message : Your details are Successfully uploaded
     */

    private int Status;
    private String Message;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
