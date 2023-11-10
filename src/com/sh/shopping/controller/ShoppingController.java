package com.sh.shopping.controller;

import java.util.List;

import com.sh.member.model.entity.Member;
import com.sh.shopping.model.entity.Cart;
import com.sh.shopping.model.entity.Shopping;
import com.sh.shopping.model.service.ShoppingService;

public class ShoppingController {
	private ShoppingService shoppingService = new ShoppingService();

	public List<Shopping> findAll() {
		List<Shopping> shopping = null;
		try {
			shopping = shoppingService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return shopping;
	}

	public int updateShopping(Shopping newDefaultShopping) {
		int result = 0;
		try {
			result = shoppingService.updateShopping(newDefaultShopping);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Cart> findCartAll() {
		List<Cart> cart = null;
		try {
			cart = shoppingService.findCartAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}

	public int updatePoint(int pay, String id) {
		int result = 0;
		try {
			result = shoppingService.updatePoint(pay,id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public int deleteCart() {
		int result = 0;
		try {
			result = shoppingService.deleteCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public Member findPointId(String id) {
		Member member = null;
		try {
			member = shoppingService.findPointId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}

	public List<Cart> findAllShoppingCart() {
		List<Cart> carts = null;
		try {
			carts = shoppingService.findAllShoppingCart();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다. : " + e.getMessage());
		}
		return carts;
	}

}
