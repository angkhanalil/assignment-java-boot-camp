package com.example.shoppingapi.CustomerOrder;

import java.util.Date;
import java.util.List;

public class RequestCustomerOrder {

    private int userid;
    private Date orderdate;
    private Double netam;
    private String paymenttype;
    private String paymentdate;
    private String shippingaddress;
    private List<RequestCustomerOrderItem> requestCustomerOrderItemList;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(Date orderdate) {
        this.orderdate = orderdate;
    }

    public Double getNetam() {
        return netam;
    }

    public void setNetam(Double netam) {
        this.netam = netam;
    }

    public String getPaymenttype() {
        return paymenttype;
    }

    public void setPaymenttype(String paymenttype) {
        this.paymenttype = paymenttype;
    }

    public String getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(String paymentdate) {
        this.paymentdate = paymentdate;
    }

    public String getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(String shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public List<RequestCustomerOrderItem> getRequestCustomerOrderItemList() {
        return requestCustomerOrderItemList;
    }

    public void setRequestCustomerOrderItemList(List<RequestCustomerOrderItem> requestCustomerOrderItemList) {
        this.requestCustomerOrderItemList = requestCustomerOrderItemList;
    }
}
