package com.sh.reservation.model.service;

import static com.sh.common.JdbcTemplate.close;
import static com.sh.common.JdbcTemplate.commit;
import static com.sh.common.JdbcTemplate.getConnection;
import static com.sh.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import com.sh.reservation.model.dao.ReservationDao;
import com.sh.reservation.model.entity.Reservation;
import com.sh.store.model.entity.Hotel;

public class ReservationService {
	private ReservationDao reservationDao = new ReservationDao();
	
	public int reserveHotel(Hotel hotel) {
		int result = 0;
		Connection conn = getConnection();
		
		try {
			result = reservationDao.reserveHotel(conn, hotel);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public List<Reservation> findAll() {
		Connection conn = getConnection();
		List<Reservation> hotels = reservationDao.findAll(conn);
		close(conn);
		return hotels;
	}

	public int updateName(Date check_in, Date check_out, String rev_name) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = reservationDao.updateName(conn, check_in, check_out, rev_name);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public int updateName(String rev_name) {
		int result = 0;
		Connection conn = getConnection();
		try {
			result = reservationDao.updateName(conn, rev_name);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

}
