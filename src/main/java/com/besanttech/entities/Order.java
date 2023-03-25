package com.besanttech.entities;


import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private int orderId;
	private List<Product> productList = new ArrayList<>();
	
	public Order() {
		
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}

