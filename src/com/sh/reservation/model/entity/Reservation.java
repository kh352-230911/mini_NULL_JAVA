package com.sh.reservation.model.entity;

import java.sql.Date;

import com.sh.store.model.entity.Hotel;

public class Reservation extends Hotel{

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(String hotel_name, String parking, String address, String hotel_number, int rating,
			Date check_in, Date check_out, String rev_name) {
		super(hotel_name, parking, address, hotel_number, rating, check_in, check_out, rev_name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Reservation [toString()=" + super.toString() + "]";
	}
	
}
