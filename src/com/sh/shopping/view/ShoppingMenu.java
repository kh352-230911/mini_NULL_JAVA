package com.sh.shopping.view;

import java.util.List;
import java.util.Scanner;

import com.sh.member.controller.MemberController;
import com.sh.member.model.entity.Member;
import com.sh.member.view.MemberMenu;
import com.sh.shopping.controller.ShoppingController;
import com.sh.shopping.model.entity.Cart;
import com.sh.shopping.model.entity.Shopping;

public class ShoppingMenu {
	private Scanner sc = new Scanner(System.in);
	private ShoppingController shoppingController = new ShoppingController();
	private MemberController memberController = new MemberController();
	
	public void shoppingMenu() {
		String menu = """
				======================
				       애견용품 쇼핑
				======================
				1. 애견용품 주문담기
				2. 장바구니 확인 
				3. 결제
				4. 포인트 잔액확인
				0. 이전 메뉴
				======================
				선택 : """;
		
		while(true) {
		
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();

			int result = 0;
			String id = null;
			Member member = new Member();
			List<Cart> carts = null;

			switch (choice) {
			case "1":
				petShoppingMenu();
				break;
			case "2":
				carts = shoppingController.findAllShoppingCart();
				displayShoppingCarts(carts);
				break;
			case "3":
				payShoppingMenu();
				break;
			case "4":
				System.out.println("> ID를 입력해 주세요 : ");
				id = sc.next();
				member = shoppingController.findPointId(id);
				displayMember(member);
				break;
			case "0":
				new MemberMenu().petOraMenu();
			default:
				System.out.println("> 잘못 입력하셨습니다.");
				break;
			
			}
			
		}
		
	}
	
	private void displayShoppingCarts(List<Cart> carts) {
		System.out.println("-------------------------------------------");
		System.out.printf("%-20s%-10s\n", "Name", "Price");
		System.out.println("-------------------------------------------");
		if(carts == null || carts.isEmpty()) {
			System.out.println("\t\t 조회된 결과가 없습니다.");
		}
		else {
			for(Cart cart : carts) {
				System.out.printf("%-20s%-10s\n", 
						cart.getName(),
						cart.getPrice());
					
			}
		}
		System.out.println("-------------------------------------------");
	}
	
	private void payShoppingMenu() {
		//1. 장바구니 목록과 총금액 조회
		int total = 0;
		int pay = 0;
		String id = null; 
		int result = 0;
		char choice = ' ';
		int charge = 0;
		Member member = new Member();
		
			List<Cart> cart = shoppingController.findCartAll();
			System.out.println("===============================================================");
			for (int i = 0; i < cart.size(); i++) {
				System.out.print((i + 1) + ". " + cart.get(i).getName() + "\t\t" + cart.get(i).getPrice() + "원\n");
				total += cart.get(i).getPrice();
			}
			System.out.println("총금액 : " + total + "원이 나왔습니다.");
			System.out.println("===============================================================");
			System.out.print("> 결제하시겠습니까? (Y/N) : ");
			choice = sc.next().charAt(0);
			
			if(choice != 'Y' && choice != 'N') {
				System.out.println("> 잘못입력하셨습니다. 다시입력해주세요");
			} else {
				if(choice == 'Y') {
					System.out.print("> 아이디를 입력해주세요 : ");
					id = sc.next();
					member = memberController.findById(id);
					if(member.getPoint() - total >= 0) {
						member.setPoint(member.getPoint() - total);
						System.out.println("> 결제가 완료 되었습니다.");
						result = shoppingController.updatePoint(pay, id);
						result = shoppingController.deleteCart();
					}
					else {
						System.out.printf("> 잔액이 부족합니다. 현재 잔액 : %d\n 충전할 금액을 입력해 주세요 : ", member.getPoint());
						charge = sc.nextInt();
						member.setPoint(member.getPoint() + charge);
						//2. 금액충전하기
						System.out.println("> 충전이 완료되었습니다.");
						System.out.printf("충전 후 금액 : %d\n", member.getPoint());
						pay = member.getPoint() - total;
						System.out.print("> 결제하시겠습니까? (Y/N) : ");
						choice = sc.next().charAt(0);
						if(choice != 'Y' && choice != 'N') {
							System.out.println("> 잘못입력하셨습니다. 다시입력해주세요");
						}
					}
					//3. 결제하기
					System.out.println("> 결제가 완료 되었습니다.");
					result = shoppingController.updatePoint(pay, id);
					result = shoppingController.deleteCart();

				}
			}
	}

	private void petShoppingMenu() {
		int total = 0;
		Shopping newDefaultShopping = null;
		//1.애견용품 목록 조회
		while(true) {
			List<Shopping> shopping = shoppingController.findAll();
			System.out.println("> 장바구니에 담을 물품을 선택해주세요.");
			System.out.println("===============================================================");
			for (int i = 0; i < shopping.size(); i++) {
				System.out.print((i + 1) + ". " + shopping.get(i).getName() + "\t\t\t" + shopping.get(i).getPrice() + "원\n");
			}
			System.out.println("0. 이전메뉴로 돌아가기");
			System.out.println("===============================================================");
			System.out.println("선택 : ");
			int choice = sc.nextInt();
			
			if (choice == 0) {
				return;
			} else {
				int index = choice - 1;
				
				//2. 장바구니 담기
				newDefaultShopping = shopping.get(index);
				int result = shoppingController.updateShopping(newDefaultShopping);
				displayResult("장바구니 담기", result);
				total += newDefaultShopping.getPrice();
			}
			
			System.out.println("> 더 담으시겠습니까? (Y/N) : ");
			char choice1 = sc.next().charAt(0);
			if(choice1 != 'Y' && choice1 != 'N') {
				System.out.println("> 잘못입력하셨습니다. 다시입력해주세요");
			} else {
				if(choice1 == 'N') {
					System.out.println("총금액 : " + total + "원 이 나왔습니다.");
					System.out.println("> 이용해주셔서 감사합니다.");
					return;
				}
			}
		}
		
	}


	private void displayResult(String type, int result) {
		if(result > 0)
			System.out.println("🐶🐶🐶🐶🐶🐶" +type + " 성공!!🐶🐶🐶🐶🐶🐶");
		else
			System.out.println("♨♨ " + type + " 실패!!♨♨");
	}	

	private void displayMember(Member member) {
        if(member == null) {
            System.out.println("> 조회된 회원이 없습니다.");
        }
        else {
            System.out.println("-------------------------------------------");
            System.out.printf("회원ID : %s\n", member.getId());
            System.out.printf("이름 : %s\n", member.getName());
            System.out.printf("남은 포인트 : %s\n", member.getPoint());
            System.out.println("-------------------------------------------");
        }
    }
}
