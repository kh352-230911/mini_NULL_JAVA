package com.sh.reservation.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sh.reservation.model.entity.Reservation;
import com.sh.reservation.model.exception.ReservationException;
import com.sh.store.model.entity.Hotel;

public class ReservationDao {

	private Properties prop = new Properties();
	
	public ReservationDao() {
		try {
			prop.load(new FileReader("resources/reservation-query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int reserveHotel(Connection conn, Hotel hotel) {
		int result = 0;
		String sql = prop.getProperty("reserveHotel");
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, hotel.getCheck_in());
			pstmt.setDate(2, hotel.getCheck_out());
			pstmt.setString(3, hotel.getRev_name());
			pstmt.setString(4, hotel.getHotel_name());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ReservationException("호텔 예약 오류!!", e);
		}
		
		return result;
	}

	public List<Reservation> findAll(Connection conn) {
		List<Reservation> hotels = new ArrayList<>();
		String sql = prop.getProperty("findAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					Reservation hotel = new Reservation();
					hotel.setHotel_name(rset.getString("hotel_name"));
					hotel.setAddress(rset.getString("address"));
					hotel.setHotel_number(rset.getString("hotel_number"));
					hotel.setCheck_in(rset.getDate("check_in"));
					hotel.setCheck_out(rset.getDate("check_out"));
					hotel.setRev_name(rset.getString("rev_name"));
					hotels.add(hotel);
				}
			}
		} catch (SQLException e) {
			throw new ReservationException("호텔 예약 오류!!", e);
		}
		
		return hotels;
	}

	public int updateName(Connection conn, Date check_in, Date check_out, String rev_name) {
		int result = 0;
		String sql = prop.getProperty("updateName");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setDate(1, check_in);
			pstmt.setDate(2, check_out);
			pstmt.setString(3, rev_name);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ReservationException("호텔 예약 오류!!", e);
		}
		return result;
	}

	public int updateName(Connection conn, String rev_name) {
		int result = 0;
		String sql = prop.getProperty("deleteName");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, rev_name);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ReservationException("호텔 예약 오류!!", e);
		}
		return result;
	}

}
