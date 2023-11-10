package com.sh.store.model.entity;

import java.sql.Date;

public class Hotel {
	private String hotel_name;
	private String parking;
	private String address;
	private String hotel_number;
	private int rating;
	private Date check_in;
	private Date check_out;
	private String rev_name;
	
	public Hotel() {
		super();
	}

	public Hotel(String hotel_name, String parking, String address, String hotel_number, int rating, Date check_in,
			Date check_out, String rev_name) {
		super();
		this.hotel_name = hotel_name;
		this.parking = parking;
		this.address = address;
		this.hotel_number = hotel_number;
		this.rating = rating;
		this.check_in = check_in;
		this.check_out = check_out;
		this.rev_name = rev_name;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
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

	public String getHotel_number() {
		return hotel_number;
	}

	public void setHotel_number(String hotel_number) {
		this.hotel_number = hotel_number;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Date getCheck_in() {
		return check_in;
	}

	public void setCheck_in(Date check_in) {
		this.check_in = check_in;
	}

	public Date getCheck_out() {
		return check_out;
	}

	public void setCheck_out(Date check_out) {
		this.check_out = check_out;
	}

	public String getRev_name() {
		return rev_name;
	}

	public void setRev_name(String rev_name) {
		this.rev_name = rev_name;
	}

	@Override
	public String toString() {
		return "Hotel [hotel_name=" + hotel_name + ", parking=" + parking + ", address=" + address + ", hotel_number="
				+ hotel_number + ", rating=" + rating + ", check_in=" + check_in + ", check_out=" + check_out
				+ ", rev_name=" + rev_name + "]";
	}
	

}
