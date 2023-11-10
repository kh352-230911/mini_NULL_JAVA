package com.sh.store.controller;

import java.util.List;

import com.sh.store.model.entity.Cafe;
import com.sh.store.model.entity.Hotel;
import com.sh.store.model.entity.Restaurant;
import com.sh.store.model.entity.Tour;
import com.sh.store.model.service.StoreService;

public class StoreController {
	private StoreService storeService = new StoreService();

	public List<Restaurant> restaurantAll() {
		List<Restaurant> restaurants = null;
		try {
			restaurants = storeService.restaurantAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return restaurants;
	}

	public List<Cafe> cafeAll() {
		List<Cafe> cafes = null;
		try {
			cafes = storeService.cafeAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return cafes;
	}

	public List<Tour> tourAll() {
		List<Tour> tour = null;
		try {
			tour = storeService.tourAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return tour;
	}

	public List<Hotel> hotelAll() {
		List<Hotel> hotels = null;
		try {
			hotels = storeService.hotelAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return hotels;
	}
	
}
