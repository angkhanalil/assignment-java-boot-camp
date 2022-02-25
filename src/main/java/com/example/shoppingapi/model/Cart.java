package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cart{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  int cartid;

	private int userid;
	private int itemid;
	private int itemqty;
//	private String itemprice;


	public int getCartid() {
		return cartid;
	}

	public void setCartid(int cartid) {
		this.cartid = cartid;
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
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
