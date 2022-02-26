package com.example.shoppingapi.CustomerOrder;

import com.example.shoppingapi.Shipping.RequestShipping;

import java.util.Date;
import java.util.List;

public class RequestCustomerOrder {

    private int userid;
    private Date orderdate;
    private Double netam;
    private String paymenttype;
    private Date paymentdate;
    private RequestShipping shippingaddress;
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

    public Date getPaymentdate() {
        return paymentdate;
    }

    public void setPaymentdate(Date paymentdate) {
        this.paymentdate = paymentdate;
    }

    public RequestShipping getShippingaddress() {
        return shippingaddress;
    }

    public void setShippingaddress(RequestShipping shippingaddress) {
        this.shippingaddress = shippingaddress;
    }

    public List<RequestCustomerOrderItem> getRequestCustomerOrderItemList() {
        return requestCustomerOrderItemList;
    }

    public void setRequestCustomerOrderItemList(List<RequestCustomerOrderItem> requestCustomerOrderItemList) {
        this.requestCustomerOrderItemList = requestCustomerOrderItemList;
    }
}
