package com.sh.member.view;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.sh.member.controller.MemberController;
import com.sh.member.model.entity.Member;
import com.sh.pet.controller.PetController;
import com.sh.pet.model.entity.Pet;
import com.sh.pet.view.PetMenu;
import com.sh.shopping.view.ShoppingMenu;
import com.sh.store.view.StoreMenu;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController memberController = new MemberController();
	private PetMenu petMenu = new PetMenu();
	private StoreMenu storeMenu = new StoreMenu();
	private PetController petController = new PetController();
	private ShoppingMenu shoppingMenu = new ShoppingMenu();
	
	public void mainMenu() {
		String menu = """
				=====================
				      	펫Ora
				=====================
				1. 로그인
				2. 회원가입
				0. 종료
				=====================
				선택 : """;

		while (true) {
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();

			int result = 0;
			Member member = null;

			switch (choice) {
			case "1":
				member = memberController.findLogin(inputLogin());
				System.out.println("\n" + member.getName() + "님 환영합니다.");
				petOraMenu();
				break;
			case "2":
				member = inputMember();
				result = memberController.insertMember(member);
				displayResult("회원가입", result);
				displayMember(member);
				break;
			case "0":
				return;
			default:
				System.out.println("> 잘못 입력하셨습니다.");
				break;
			}
		}

	}

	public void petOraMenu() {
		String menu = """
				=====================
				        펫Ora
				=====================
				1. 반려동물 정보
				2. 동반 출입 안내도
				3. 동네 친구 찾기
				4. 애견용품 쇼핑하기
				0. 로그아웃
				=====================
				선택 : """;
		
		while(true) {
			
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();
			
			List<Pet> pets = null;
			List<Member> members = null;
			String address = null;
			
			switch (choice) {
			case "1": petMenu.petMenu();break;
			case "2": storeMenu.storeMenu();break;
			case "3":
				address = inputAddress();
				pets = memberController.petFriend(address);
				displayAddresses(pets);
				break;
			case "4": 
				shoppingMenu.shoppingMenu();break;
			case "0": mainMenu();
			default:
				System.out.println("> 잘못 입력하셨습니다.");
				break;
			}
		}
		
	}

	/**
	 * 회원 주소 입력
	 * @return
	 */
	private String inputAddress() {
		System.out.println("> 찾고싶은 동네친구 검색(ex.**구) : ");
		return sc.next();
	}
	
	/**
	 * n건의 주소조회 결과를 출력
	 */
	private void displayAddresses(List<Pet> pets) {
		  System.out.println("--------------------------------------------------------------------------------------");
	        System.out.printf("%-10s%-10s%-10s%-20s\n", 
	                "MemberId", "Pettype", "gender", "Birthday");
	        System.out.println("--------------------------------------------------------------------------------------");
	        if(pets == null || pets.isEmpty()) {
	            System.out.println("\t\t 조회된 결과가 없습니다.");
	        }
	        else {
	            for(Pet pet : pets) {
	                System.out.printf("%-10s%-10s%-5s%-10s\n", 
	                        pet.getMemberId(), 
	                        pet.getpType(), 
	                        pet.getGender(), 
	                        pet.getBirthday());
	            }
	        }
	        System.out.println("--------------------------------------------------------------------------------------");
		
	}
	
	private Member inputLogin() {
		Member member = new Member();
		while (true) {
			System.out.print("> 아이디 : ");
			member.setId(sc.next());
			System.out.print("> 비밀번호 : ");
			member.setPassword(sc.next());
			if (memberController.findById(member.getId()) != null
					&& memberController.findByPassword(member.getPassword()) != null) {
				System.out.println("> 로그인 되었습니다.");
				break;
			} else
				System.out.println("> 아이디와 비밀번호를 다시 입력해주세요.");
		}
		return member;
	}

	private Member inputMember() {
		Member member = new Member();
		System.out.println("> 회원정보를 입력하세요.");
		// 아이디 중복 조회
		while (true) {
			System.out.print("> 아이디 : ");
			member.setId(sc.next());
			if (memberController.findById(member.getId()) == null) {
				System.out.println("> 사용가능한 아이디입니다.");
				break;
			} else
				System.out.println("> 사용 불가능한 아이디입니다. 다시 입력하세요.");
		}
		System.out.print("> 비밀번호 : ");
		member.setPassword(sc.next());
		System.out.print("> 이름 : ");
		member.setName(sc.next());
		System.out.print("> 전화번호 : ");
		member.setPhone(sc.next());
		sc.nextLine();
		System.out.print("> 주소 : ");
		member.setAddress(sc.nextLine());
		return member;
	}

	private void displayResult(String type, int result) {
		if (result > 0)
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
			System.out.printf("Id : %s\n", member.getId());
			System.out.printf("Password : %s\n", member.getPassword());
			System.out.printf("Name : %s\n", member.getName());
			System.out.printf("Phone : %s\n", member.getPhone());
			System.out.printf("Address : %s\n", member.getAddress());
			System.out.println("-------------------------------------------");
		}
	}
}
