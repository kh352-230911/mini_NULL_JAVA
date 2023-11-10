package com.sh.shopping.model.service;

import static com.sh.common.JdbcTemplate.close;
import static com.sh.common.JdbcTemplate.commit;
import static com.sh.common.JdbcTemplate.getConnection;
import static com.sh.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.sh.member.model.entity.Member;
import com.sh.shopping.model.dao.ShoppingDao;
import com.sh.shopping.model.entity.Cart;
import com.sh.shopping.model.entity.Shopping;

public class ShoppingService {
private ShoppingDao shoppingDao = new ShoppingDao();
	
	public List<Shopping> findAll() {
		Connection conn = getConnection();
		List<Shopping> shopping = shoppingDao.findAll(conn);
		close(conn);
		return shopping;
	}

	public int updateShopping(Shopping newDefaultShopping) {
		Connection conn = getConnection();
		int result = 0;
				try {
					result = shoppingDao.updateShopping(conn,newDefaultShopping);
					commit(conn);
				} catch (Exception e) {
					rollback(conn);
					throw e;
				} finally {
					close(conn);
				}
			
		return result;
	}

	public List<Cart> findCartAll() {
		Connection conn = getConnection();
		List<Cart> cart = shoppingDao.findCartAll(conn);
		close(conn);
		return cart;
	}

	public int updatePoint(int pay, String id) {
		Connection conn = getConnection();
		int result = 0;
				try {
					result = shoppingDao.updatePoint(conn,pay, id);
					commit(conn);
				} catch (Exception e) {
					rollback(conn);
					throw e;
				} finally {
					close(conn);
				}
			
		return result;
	}

	public int deleteCart() {
		Connection conn = getConnection();
		int result = 0;
				try {
					result = shoppingDao.deleteCart(conn);
					commit(conn);
				} catch (Exception e) {
					rollback(conn);
					throw e;
				} finally {
					close(conn);
				}
			
		return result;
	}

	public Member findPointId(String id) {
		Member member = null;
		Connection conn = getConnection();
		member = shoppingDao.findPointId(conn, id);
		close(conn);
		return member;
	}
	
	public List<Cart> findAllShoppingCart() {
		Connection conn = getConnection();
		List<Cart> carts = shoppingDao.findAllShoppingCart(conn);
		close(conn);
		return carts;
	}
}
