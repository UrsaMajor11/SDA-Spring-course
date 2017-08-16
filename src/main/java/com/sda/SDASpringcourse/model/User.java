package com.sda.SDASpringcourse.model;

/**
 * Created by RENT on 2017-08-16.
 */


public class User {

    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public User(Integer id, String firstName, String lastName, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
