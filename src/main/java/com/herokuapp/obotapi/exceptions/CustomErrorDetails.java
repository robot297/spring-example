package com.herokuapp.obotapi.exceptions;

import java.util.Date;

public class CustomErrorDetails {

    private Date timeStamp;
    private String message;
    private String errorMessage;

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public CustomErrorDetails(Date timeStamp, String message, String errorMessage) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.errorMessage = errorMessage;
    }
}
