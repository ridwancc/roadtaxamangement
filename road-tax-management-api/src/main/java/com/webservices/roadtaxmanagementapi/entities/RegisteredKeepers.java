package com.webservices.roadtaxmanagementapi.entities;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class RegisteredKeepers implements Serializable {
    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String firstLineAddress;
    private String postCode;
    private String phoneNumber;

    public RegisteredKeepers() {
        
    }

    public RegisteredKeepers(String firstName, String lastName, String firstLineAddress, String postCode,
            String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstLineAddress = firstLineAddress;
        this.postCode = postCode;
        this.phoneNumber = phoneNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstLineAddress() {
        return firstLineAddress;
    }

    public void setFirstLineAddress(String firstLineAddress) {
        this.firstLineAddress = firstLineAddress;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    

}
