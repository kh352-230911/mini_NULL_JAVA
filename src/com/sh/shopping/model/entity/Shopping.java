package com.sh.shopping.model.entity;

public class Shopping {
	private String name;
	private int price;
	
	public Shopping() {
		super();
	}
	
	public Shopping(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Shopping [name=" + name + ", price=" + price + "]";
	}
	
	
}
