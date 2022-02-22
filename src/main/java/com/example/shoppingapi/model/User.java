package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class User {
    @Id
//    @GeneratedValue
    private int userId;
    private String fullName;
    private String email;
    private String mobilephone;
//    gender
//    birthdate
//    AddressBook
    @OneToMany
    private List<UserAddressBook> userAddressbook;


    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobilephone() {
        return mobilephone;
    }

    public void setMobilephone(String mobilephone) {
        this.mobilephone = mobilephone;
    }

    public List<UserAddressBook> getUserAddressbook() {
        return userAddressbook;
    }

    public void setUserAddressbook(List<UserAddressBook> userAddressbook) {
        this.userAddressbook = userAddressbook;
    }
}
