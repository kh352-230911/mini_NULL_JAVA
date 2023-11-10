package com.sh.reservation.controller;

import java.sql.Date;
import java.util.List;

import com.sh.reservation.model.entity.Reservation;
import com.sh.reservation.model.service.ReservationService;
import com.sh.store.model.entity.Hotel;

public class ReservationController {
	private ReservationService reservationService = new ReservationService();
	
	public int reserveHotel(Hotel hotel) {
		int result = 0;
		try {
			result = reservationService.reserveHotel(hotel);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return result;
	}

	public List<Reservation> findAll() {
		List<Reservation> hotels = null;
		try {
			hotels = reservationService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return hotels;
	}

	public int updateName(Date check_in, Date check_out, String rev_name) {
		int result = 0;
		try {
			result = reservationService.updateName(check_in, check_out, rev_name);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return result;
	}

	public int deleteName(String rev_name) {
		int result = 0;
		try {
			result = reservationService.updateName(rev_name);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return result;
	}

}
