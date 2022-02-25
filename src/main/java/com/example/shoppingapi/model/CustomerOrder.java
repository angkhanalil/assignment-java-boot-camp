package com.example.shoppingapi.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerOrder{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int TransOrder;

	private String orderid;
	private int userid;
	private Date orderdate;

	private Double netam;
	private String orderstatus;
	private String paymenttype;
	private String paymentdate;
	private String shippingaddress;
	private String tracking;

	@OneToMany
	private List<CustomerOrderItem> orderItem;



	public int getTransOrder() {
		return TransOrder;
	}

	public void setTransOrder(int transOrder) {
		TransOrder = transOrder;
	}

	public void setShippingaddress(String shippingaddress){
		this.shippingaddress = shippingaddress;
	}

	public String getShippingaddress(){
		return shippingaddress;
	}

	public void setPaymentdate(String paymentdate){
		this.paymentdate = paymentdate;
	}

	public String getPaymentdate(){
		return paymentdate;
	}

	public Double getNetam() {
		return netam;
	}

	public void setNetam(Double netam) {
		this.netam = netam;
	}

	public void setOrderstatus(String orderstatus){
		this.orderstatus = orderstatus;
	}

	public String getOrderstatus(){
		return orderstatus;
	}

	public void setOrderid(String orderid){
		this.orderid = orderid;
	}

	public String getOrderid(){
		return orderid;
	}

	public void setOrderItem(List<CustomerOrderItem> orderItem){
		this.orderItem = orderItem;
	}

	public List<CustomerOrderItem> getOrderItem(){
		return orderItem;
	}

	public String getPaymenttype() {
		return paymenttype;
	}

	public void setPaymenttype(String paymenttype) {
		this.paymenttype = paymenttype;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public void setUserid(int userid){
		this.userid = userid;
	}

	public int getUserid(){
		return userid;
	}

	public void setTracking(String tracking){
		this.tracking = tracking;
	}

	public String getTracking(){
		return tracking;
	}
}