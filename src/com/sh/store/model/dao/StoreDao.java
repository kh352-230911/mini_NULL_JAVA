package com.sh.store.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sh.store.model.entity.Cafe;
import com.sh.store.model.entity.Hotel;
import com.sh.store.model.entity.Restaurant;
import com.sh.store.model.entity.Tour;
import com.sh.store.model.exception.StoreException;

public class StoreDao {
	private Properties prop = new Properties();
	
	 public StoreDao() {
	        try {
	            prop.load(new FileReader("resources/store-query.properties"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	public List<Restaurant> restaurantAll(Connection conn) {
		List<Restaurant> restaurants = new ArrayList<>();
		String sql = prop.getProperty("restaurantAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			
			while(rset.next()) {
				Restaurant rest = new Restaurant();
				rest.setRestaurant_name(rset.getString("restaurant_name"));
				rest.setOpenhours(rset.getString("openhours"));
				rest.setParking(rset.getString("parking"));
				rest.setAddress(rset.getString("address"));
				rest.setRestaurant_number(rset.getString("restaurant_number"));
				rest.setRating(rset.getInt("rating"));
				restaurants.add(rest);
			}
		} catch (SQLException e) {
			throw new StoreException("음식점조회 오류!!", e);
			
		}
		
		return restaurants;
	}

	
	public List<Cafe> cafeAll(Connection conn) {
		List<Cafe> cafes = new ArrayList<>();
		String sql = prop.getProperty("cafeAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			
			while(rset.next()) {
				Cafe cf = new Cafe();
				cf.setCafe_name(rset.getString("cafe_name"));
				cf.setOpenhours(rset.getString("openhours"));
				cf.setParking(rset.getString("parking"));
				cf.setAddress(rset.getString("address"));
				cf.setCafe_number(rset.getString("cafe_number"));
				cf.setRating(rset.getInt("rating"));
				cafes.add(cf);
			}
		} catch (SQLException e) {
			throw new StoreException("카페조회 오류!!", e);
			
		}
		return cafes;
	}

	public List<Tour> tourAll(Connection conn) {
		List<Tour> tour = new ArrayList<>();
		String sql = prop.getProperty("tourAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			
			while(rset.next()) {
				Tour tu = new Tour();
				tu.setTour_name(rset.getString("tour_name"));
				tu.setParking(rset.getString("parking"));
				tu.setAddress(rset.getString("address"));
				tu.setTour_number(rset.getString("tour_number"));
				tu.setRating(rset.getInt("rating"));
				tour.add(tu);
			}
		} catch (SQLException e) {
			throw new StoreException("관광지조회 오류!!", e);

		}
		return tour;
	}

	public List<Hotel> hotelAll(Connection conn) {
		List<Hotel> hotels = new ArrayList<>();
		String sql = prop.getProperty("hotelAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			
			while(rset.next()) {
				Hotel ht = new Hotel();
				ht.setHotel_name(rset.getString("hotel_name"));
				ht.setParking(rset.getString("parking"));
				ht.setAddress(rset.getString("address"));
				ht.setHotel_number(rset.getString("hotel_number"));
				ht.setRating(rset.getInt("rating"));
				hotels.add(ht);
			}
		} catch (SQLException e) {
			throw new StoreException("호텔조회 오류!!", e);

		}
		return hotels;
	}

}
