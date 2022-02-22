package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAddressBook {

    @Id
    private int addressid;
    private String email;
    private String address;
    private String province;
    private String city;
    private String phonenumber;
    private String postcode;
    private String fullname;


    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvince() {
        return province;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setAddressid(int addressid) {
        this.addressid = addressid;
    }

    public int getAddressid() {
        return addressid;
    }
}
