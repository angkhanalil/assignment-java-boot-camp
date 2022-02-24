package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cart{

	@Id
	@GeneratedValue
	private  int cartid;

	private int userid;
	private String itemid;
	private int itemqty;
//	private String itemprice;


	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public void setItemid(String itemid){
		this.itemid = itemid;
	}

	public String getItemid(){
		return itemid;
	}

	public void setItemqty(int itemqty){
		this.itemqty = itemqty;
	}

	public int getItemqty(){
		return itemqty;
	}

	public void setUserid(int userid){
		this.userid = userid;
	}

	public int getUserid(){
		return userid;
	}
}
