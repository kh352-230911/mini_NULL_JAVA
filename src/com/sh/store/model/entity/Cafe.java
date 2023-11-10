package com.sh.store.model.entity;

public class Cafe {
	private String cafe_name;
	private String openhours;
	private String parking;
	private String address;
	private String cafe_number;
	private int rating;
	
	public Cafe() {
		super();
	}

	public Cafe(String cafe_name, String openhours, String parking, String address, String cafe_number, int rating) {
		super();
		this.cafe_name = cafe_name;
		this.openhours = openhours;
		this.parking = parking;
		this.address = address;
		this.cafe_number = cafe_number;
		this.rating = rating;
	}

	public String getCafe_name() {
		return cafe_name;
	}

	public void setCafe_name(String cafe_name) {
		this.cafe_name = cafe_name;
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

	public String getCafe_number() {
		return cafe_number;
	}

	public void setCafe_number(String cafe_number) {
		this.cafe_number = cafe_number;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Cafe [cafe_name=" + cafe_name + ", openhours=" + openhours + ", parking=" + parking + ", address="
				+ address + ", cafe_number=" + cafe_number + ", rating=" + rating + "]";
	}
	
	
}
