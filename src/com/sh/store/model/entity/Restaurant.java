package com.sh.store.model.entity;

public class Restaurant {
	private String restaurant_name;
	private String openhours;
	private String parking;
	private String address;
	private String restaurant_number;
	private int rating;
	
	public Restaurant() {
		super();
	}

	public Restaurant(String restaurant_name, String openhours, String parking, String address, String restaurant_number,
			int rating) {
		super();
		this.restaurant_name = restaurant_name;
		this.openhours = openhours;
		this.parking = parking;
		this.address = address;
		this.restaurant_number = restaurant_number;
		this.rating = rating;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getOpenhours() {
		return openhours;
	}

	public void setOpenhours(String openhours) {
		this.openhours = openhours;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRestaurant_number() {
		return restaurant_number;
	}

	public void setRestaurant_number(String restaurant_number) {
		this.restaurant_number = restaurant_number;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurant_name=" + restaurant_name + ", openhours=" + openhours + ", parking=" + parking
				+ ", address=" + address + ", restaurant_number=" + restaurant_number + ", rating=" + rating + "]";
	}

	
}
