package com.sh.shopping.model.entity;

public class Cart extends Shopping{

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(String name, int price) {
		super(name, price);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Cart [toString()=" + super.toString() + "]";
	}
	
	
}
