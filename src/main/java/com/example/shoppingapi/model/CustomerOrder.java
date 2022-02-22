package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.DateTimeException;
import java.util.Date;
import java.util.List;

@Entity
public class CustomerOrder{
	@Id
	@GeneratedValue
	private int TransOrder;

	private String orderid;
	private int userid;
	private Date orderdate;

	private Float netam;
	private String orderstatus;
	private String paymenttype;
	private String paymentdate;
	private String shippingaddress;
	private String tracking;

	@OneToMany
	private List<OrderItemItem> orderItem;



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

	public Float getNetam() {
		return netam;
	}

	public void setNetam(Float netam) {
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

	public void setOrderItem(List<OrderItemItem> orderItem){
		this.orderItem = orderItem;
	}

	public List<OrderItemItem> getOrderItem(){
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