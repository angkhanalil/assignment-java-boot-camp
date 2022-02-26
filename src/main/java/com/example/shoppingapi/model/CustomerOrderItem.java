package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class CustomerOrderItem {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY
	)
	private int TransItem;
	private String orderid;
	private int productid;
	private Double price;
	private int qty;


	public int getTransItem() {
		return TransItem;
	}

	public void setTransItem(int transItem) {
		TransItem = transItem;
	}

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

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}


}
