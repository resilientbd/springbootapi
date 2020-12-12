package com.faisal.canteenapp.canteenapp.commonresponsemodel;

public class ResponseModel {
    private int status = 200;
    private Object message = "response ok";

    public ResponseModel() {
    }

    public ResponseModel(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }



    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "ResponseModel{" +
                "status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
