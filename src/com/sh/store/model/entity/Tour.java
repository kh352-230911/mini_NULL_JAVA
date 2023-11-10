package com.sh.store.model.entity;

public class Tour {
	private String tour_name;
	private String parking;
	private String address;
	private String tour_number;
	private int rating;
	
	public Tour() {
		super();
	}

	public Tour(String tour_name, String parking, String address, String tour_number, int rating) {
		super();
		this.tour_name = tour_name;
		this.parking = parking;
		this.address = address;
		this.tour_number = tour_number;
		this.rating = rating;
	}

	public String getTour_name() {
		return tour_name;
	}

	public void setTour_name(String tour_name) {
		this.tour_name = tour_name;
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

	public String getTour_number() {
		return tour_number;
	}

	public void setTour_number(String tour_number) {
		this.tour_number = tour_number;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Tour [tour_name=" + tour_name + ", parking=" + parking + ", address=" + address + ", tour_number="
				+ tour_number + ", rating=" + rating + "]";
	}
	

}
