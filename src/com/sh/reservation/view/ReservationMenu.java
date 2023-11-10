package com.sh.reservation.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.sh.reservation.controller.ReservationController;
import com.sh.reservation.model.entity.Reservation;
import com.sh.store.model.entity.Hotel;
import com.sh.store.model.entity.Restaurant;
import com.sh.store.view.StoreMenu;

public class ReservationMenu {
	private Scanner sc = new Scanner(System.in);
	private ReservationController reservationController = new ReservationController();
	
	public void reservationMenu() {
		String menu = """
				=====================
				    숙소 예약 프로그램
				=====================
				1. 예약
				2. 예약 변경
				3. 예약 취소
				4. 예약 조회
				0. 이전 메뉴
				=====================
				선택 : """;
		
		while(true) {
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();
			
			int result = 0;
			Hotel hotel = null;
			List<Reservation> hotels = null;
			Restaurant rest = null;
			Date check_in = null;
			Date check_out = null;
			String rev_name = null;
			
			switch (choice) {
			case "1":
				result = reservationController.reserveHotel(inputHotel());
				displayResult("예약", result);
				break;
			case "2":
				rev_name = inputName();
				check_in = inputCheckIn();
				check_out = inputCheckOut();
				result = reservationController.updateName(check_in, check_out, rev_name);
				displayResult("예약 수정", result);
				break;
			case "3":
				rev_name = inputName();
				result = reservationController.deleteName(rev_name);
				displayResult("예약 삭제", result);
				break;
			case "4":
				hotels = reservationController.findAll();
				displayHotels(hotels);
				break;
			case "0":
					new StoreMenu().storeMenu();
			default:
				System.out.println("> 잘못 입력하셨습니다.");
				break;
			}
			
			
		}
	}

	private void displayHotels(List<Reservation> hotels) {
		System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-20s%-20s%-20s%-20s%-10s\n", 
                "숙소 이름", "주소", "숙소 번호", "체크 인", "체크 아웃", "예약자 이름");
        System.out.println("--------------------------------------------------------------------------------------------------------");
        if(hotels == null || hotels.isEmpty()) {
            System.out.println("\t\t 조회된 결과가 없습니다.");
        }
        else {
            for(Reservation hotel : hotels) {
                System.out.printf("%-10s%-20s%-20s%-20s%-20s%-10s\n", 
                        hotel.getHotel_name(), 
                        hotel.getAddress(), 
                        hotel.getHotel_number(), 
                        hotel.getCheck_in(), 
                        hotel.getCheck_out(), 
                        hotel.getRev_name());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
    }


	private Hotel inputHotel() {
		Hotel hotel = new Hotel();
		
		System.out.print("> 예약하실 호텔을 입력하세요 : ");
		hotel.setHotel_name(sc.next());
		System.out.println("--------------------------------");
		System.out.println("> 예약할 정보를 입력하세요.");
		System.out.print("> CheckIn(yyyy-mm-dd) : ");
		hotel.setCheck_in(Date.valueOf(sc.next()));
		System.out.print("> CheckOut(yyyy-mm-dd) : ");
		hotel.setCheck_out(Date.valueOf(sc.next()));
		System.out.print("> 예약자 성함 : ");
		hotel.setRev_name(sc.next());
		
		return hotel;
	}
	
	private void displayResult(String type, int result) {
		if(result > 0)
			System.out.println("🐶🐶🐶🐶🐶🐶" + type + " 성공!!🐶🐶🐶🐶🐶🐶");
		else
			System.out.println("♨♨ " + type + " 실패!!♨♨");
	}	
	
	/**
	 * 변경할 예약자명 입력
	 * @return
	 */
	private String inputName() {
		System.out.println("> 예약자명을 입력해주세요 : ");
		return sc.next();
	}
	/**
	 * 변경할 체크인 입력
	 * @return
	 */
	private Date inputCheckIn() {
		System.out.println("> 변경하실 체크인 날짜를 입력해주세요 : ");
		return Date.valueOf(sc.next());
	}
	/**
	 * 변경할 체크아웃 입력
	 * @return
	 */
	private Date inputCheckOut() {
		System.out.println("> 변경하실 체크아웃 날짜를 입력해주세요 : ");
		return Date.valueOf(sc.next());
	}
}
