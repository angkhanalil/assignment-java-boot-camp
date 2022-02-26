package com.example.shoppingapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username; //email
    private String password;

    private String firstname;
    private String lastname;
    private String phoneno;

    @OneToMany
    private List<CustomerAddressItem> customerAddress = new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }


    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getLastname() {
        return lastname;
    }

    public List<CustomerAddressItem> getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(List<CustomerAddressItem> customerAddress) {
        this.customerAddress = customerAddress;
    }
}