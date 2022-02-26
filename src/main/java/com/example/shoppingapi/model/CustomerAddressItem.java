package com.example.shoppingapi.model;

import javax.persistence.*;

@Entity
public class CustomerAddressItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String addess;
    private String province;
    private String city;
    private String postcode;
    private String telephone;
    private String fullname;
    private int customerid;
    private String email;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customerid",referencedColumnName = "id",nullable = false)
//    private Customer customer;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public void setAddess(String addess) {
        this.addess = addess;
    }

    public String getAddess() {
        return addess;
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

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
