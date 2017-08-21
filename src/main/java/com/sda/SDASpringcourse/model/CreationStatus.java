package com.sda.SDASpringcourse.model;

/**
 * Created by RENT on 2017-08-21.
 */
public class CreationStatus {

    private boolean status;
    private String message;

    public CreationStatus() {
    }

    public boolean isStatus() {
        return status;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
