package com.example.shoppingapi.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product{
	@Id
	private int productid;

	private Double price;
	private Double sellprice;
	private String productDetails;
	private String brand;
	private String productName;
	private String category;
//	image
//	sku
//	store
//	size
//	color

	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public void setProductDetails(String productDetails){
		this.productDetails = productDetails;
	}

	public String getProductDetails(){
		return productDetails;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	public void setProductName(String productName){
		this.productName = productName;
	}

	public String getProductName(){
		return productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
