package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class OrderItemItem{

	@Id
	private String orderid;
	private int productid;
	private Float price;
	private int qty;

	public void setProductid(int productid){
		this.productid = productid;
	}

	public int getProductid(){
		return productid;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}
