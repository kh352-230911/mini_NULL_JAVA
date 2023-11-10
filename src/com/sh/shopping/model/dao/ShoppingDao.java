package com.sh.shopping.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sh.member.model.entity.Member;
import com.sh.shopping.model.entity.Cart;
import com.sh.shopping.model.entity.Shopping;
import com.sh.shopping.model.exception.ShoppingException;

public class ShoppingDao {
	private Properties prop = new Properties();
    
    public ShoppingDao() {
        try {
            prop.load(new FileReader("resources/shopping-query.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public List<Shopping> findAll(Connection conn) {
		List<Shopping> shopping	= new ArrayList<>();
		String sql = prop.getProperty("findAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			
				while(rset.next()) {
					Shopping shopping2 = new Shopping();
					shopping2.setName(rset.getString("name"));
					shopping2.setPrice(rset.getInt("price"));
					shopping.add(shopping2);
				}
		} catch (SQLException e) {
			throw new ShoppingException("조회 오류!", e);
		}
		
		return shopping;
	}

	public int updateShopping(Connection conn,Shopping newDefaultShopping) {
		String sql = prop.getProperty("updateShopping");
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(2, newDefaultShopping.getName());
			pstmt.setInt(1, newDefaultShopping.getPrice());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ShoppingException("장바구니 담기 오류!", e);
		}
		return result;
	}

	public List<Cart> findCartAll(Connection conn) {
		List<Cart> cart = new ArrayList<>();
		String sql= prop.getProperty("findCartAll");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rset = pstmt.executeQuery()) {
			while(rset.next()) {
				Cart carts = new Cart();
				carts.setName(rset.getString("name"));
				carts.setPrice(rset.getInt("price"));
				cart.add(carts);
			}
		} catch (SQLException e) {
			throw new ShoppingException("조회 오류!", e);
		}
		return cart;
	}

	public int updatePoint(Connection conn, int pay, String id) {
		String sql = prop.getProperty("updatePoint");
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, pay);
			pstmt.setString(2, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new ShoppingException("포인트 변경 오류!", e);
		}
		return result;
	}

	public int deleteCart(Connection conn) {
		String sql = prop.getProperty("deleteCart");
		int result = 0;
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			throw new ShoppingException("장바구니 삭제 오류!", e);
		}
		return result;
	}

	public Member findPointId(Connection conn, String id) {
		Member member = null;
		String sql = prop.getProperty("findPointId");
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			
			try(ResultSet rset = pstmt.executeQuery()){
				
			while(rset.next()) {
				int no = rset.getInt("no");
				String password = rset.getString("password");
				String name = rset.getString("name");
				String phone = rset.getString("phone");
				String address = rset.getString("address");
				int point = rset.getInt("point");
				member = new Member(no, id, password, name, phone, address , point);
			}
		}
		} catch (SQLException e) {
			throw new ShoppingException("포인트 잔액조회 오류!", e);
		}
		return member;
	}
	
	public List<Cart> findAllShoppingCart(Connection conn) {
		List<Cart> cartList = new ArrayList<>();
		String sql = prop.getProperty("findAllShoppingCart");
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			try(ResultSet rset = pstmt.executeQuery()){
				while(rset.next()) {
					Cart cart = handleShoppingResultSet(rset);
					cartList.add(cart);
				}
			}
		} catch (SQLException e) {
			throw new ShoppingException("장바구니 전체 조회 오류!", e);
		}
		
		
		return cartList;
	}

	private Cart handleShoppingResultSet(ResultSet rset) throws SQLException{
		Cart cart = new Cart();
		cart.setName(rset.getString("name"));
		cart.setPrice(rset.getInt("price"));
		return cart;
	}
}
