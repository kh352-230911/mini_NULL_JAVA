package com.sh.store.model.service;

import static com.sh.common.JdbcTemplate.close;
import static com.sh.common.JdbcTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.sh.store.model.dao.StoreDao;
import com.sh.store.model.entity.Cafe;
import com.sh.store.model.entity.Hotel;
import com.sh.store.model.entity.Restaurant;
import com.sh.store.model.entity.Tour;

public class StoreService {
		private StoreDao storeDao = new StoreDao();

		public List<Restaurant> restaurantAll() {
			Connection conn = getConnection();
			List<Restaurant> restaurants = storeDao.restaurantAll(conn);
			close(conn);
			return restaurants;
		}

		public List<Cafe> cafeAll() {
			Connection conn = getConnection();
			List<Cafe> cafes = storeDao.cafeAll(conn);
			close(conn);
			return cafes;
		}

		public List<Tour> tourAll() {
			Connection conn = getConnection();
			List<Tour> tour = storeDao.tourAll(conn);
			close(conn);
			return tour;
		}

		public List<Hotel> hotelAll() {
			Connection conn = getConnection();
			List<Hotel> hotels = storeDao.hotelAll(conn);
			close(conn);
			return hotels;
		}

}
