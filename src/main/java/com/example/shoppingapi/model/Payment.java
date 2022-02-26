package com.example.shoppingapi.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Payment {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY
    )
    private int paymenttypeid;
    private String paymenttypename;

    public int getPaymenttypeid() {
        return paymenttypeid;
    }

    public void setPaymenttypeid(int paymenttypeid) {
        this.paymenttypeid = paymenttypeid;
    }

    public String getPaymenttypename() {
        return paymenttypename;
    }

    public void setPaymenttypename(String paymenttypename) {
        this.paymenttypename = paymenttypename;
    }
}
