package com.sda.SDASpringcourse.model;

/**
 * Created by RENT on 2017-08-21.
 */

//klasa pomocnicza, do budowania obiektu, ktory bedzie okreslał czy jakaś operacja zakonczyla sie sukcesem, czy nie, oraz odpowednia informacja
//odnośnie wyniku operacji

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
