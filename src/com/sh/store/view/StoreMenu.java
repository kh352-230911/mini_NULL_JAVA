package com.sh.store.view;

import java.util.List;
import java.util.Scanner;

import com.sh.member.view.MemberMenu;
import com.sh.reservation.view.ReservationMenu;
import com.sh.store.controller.StoreController;
import com.sh.store.model.entity.Cafe;
import com.sh.store.model.entity.Hotel;
import com.sh.store.model.entity.Restaurant;
import com.sh.store.model.entity.Tour;

public class StoreMenu {
	private Scanner sc = new Scanner(System.in);
	private StoreController storeController = new StoreController();
	
	public void storeMenu() {
		String menu = """
				=====================
				     동반 출입 안내도
				=====================
				1. 음식점 조회
				2. 카페 조회
				3. 관광지 조회
				4. 숙소 조회
				5. 숙소 예약 프로그램
				0. 이전 메뉴
				=====================
				선택 : """;
			
			while(true) {
				System.out.println();
				System.out.print(menu);
				String choice = sc.next();
				
				List<Restaurant> restaurants = null;
				List<Cafe> cafes = null;
				List<Tour> tour = null;
				List<Hotel> hotels = null;
				
				switch(choice) {
				case "1":
						restaurants = storeController.restaurantAll();
						displayRestaurants(restaurants);
						break;
				case "2": 
						cafes = storeController.cafeAll();
						displayCafes(cafes);
						break;
				case "3":
						tour = storeController.tourAll();
						displayTour(tour);
						break;
				case "4": 
						hotels = storeController.hotelAll();
						displayHotels(hotels);
						break;
				case "5":
						new ReservationMenu().reservationMenu();
				case "0": new MemberMenu().petOraMenu();
				default:
					System.out.println("잘못 입력하셨습니다.");
					break;
				}
			}
	}
	
	/**
	 * 호텔 N건의 조회결과 출력
	 * @param hotels
	 */
	private void displayHotels(List<Hotel> hotels) {
		 System.out.println("-------------------------------------------------------------------------------------------------");
	        System.out.printf("%-20s%-20s%-20s%-20s%-10s\n", 
	                "HotelName", "Parking", "Address", "HotelNumber", "Rating");
	        System.out.println("-------------------------------------------------------------------------------------------------");
	        if( hotels == null || hotels.isEmpty()) {
	            System.out.println("\t\t 조회된 결과가 없습니다.");
	        }
	        else {
	            for(Hotel ht : hotels) {
	                System.out.printf("%-20s%-20s%-20s%-20s%-10d\n", 
	                        ht.getHotel_name(), 
	                        ht.getParking(), 
	                        ht.getAddress(), 
	                        ht.getHotel_number(), 
	                        ht.getRating());
	            }
	        }
	        System.out.println("-------------------------------------------------------------------------------------------------");
	}
	/**
	 * 관광지 N건의 조회결과 출력
	 * @param tour
	 */
	private void displayTour(List<Tour> tour) {
		 System.out.println("-------------------------------------------------------------------------------------------------");
	        System.out.printf("%-20s%-20s%-20s%-20s%-10s\n", 
	                "TourName", "Parking", "Address", "TourNumber", "Rating");
	        System.out.println("-------------------------------------------------------------------------------------------------");
	        if( tour == null || tour.isEmpty()) {
	            System.out.println("\t\t 조회된 결과가 없습니다.");
	        }
	        else {
	            for(Tour tu : tour) {
	                System.out.printf("%-20s%-20s%-20s%-20s%-10d\n", 
	                        tu.getTour_name(), 
	                        tu.getParking(), 
	                        tu.getAddress(), 
	                        tu.getTour_number(), 
	                        tu.getRating());
	            }
	        }
	        System.out.println("-------------------------------------------------------------------------------------------------");
	}
	/**
	 * 카페 N건의 조회결과 출력
	 * @param cafes
	 */
	private void displayCafes(List<Cafe> cafes) {
		 System.out.println("-------------------------------------------------------------------------------------------------------------");
	        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-10s\n", 
	                "CafeName", "OpenHours", "Parking", "Address", "CafeNumber", "Rating");
	        System.out.println("----------------------------------------------------------------------------------------------------------");
	        if(cafes == null || cafes.isEmpty()) {
	            System.out.println("\t\t 조회된 결과가 없습니다.");
	        }
	        else {
	            for(Cafe cf : cafes) {
	                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-10d\n", 
	                        cf.getCafe_name(), 
	                        cf.getOpenhours(),
	                        cf.getParking(), 
	                        cf.getAddress(), 
	                        cf.getCafe_number(), 
	                        cf.getRating());
	            }
	        }
	        System.out.println("----------------------------------------------------------------------------------------------------------");
		
	}

	/**
	 * 음식점 N건의 조회결과 출력
	 * @param members
	 */
	private void displayRestaurants(List<Restaurant> restaurants) {
		    System.out.println("----------------------------------------------------------------------------------------------------------");
	        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-10s\n", 
	                "RestaurantName", "OpenHours", "Parking", "Address", "RestaurantNumber", "Rating");
	        System.out.println("----------------------------------------------------------------------------------------------------------");
	        if(restaurants == null || restaurants.isEmpty()) {
	            System.out.println("\t\t 조회된 결과가 없습니다.");
	        }
	        else {
	            for(Restaurant rest : restaurants) {
	                System.out.printf("%-20s%-20s%-20s%-20s%-20s%-10d\n", 
	                        rest.getRestaurant_name(), 
	                        rest.getOpenhours(), 
	                        rest.getParking(), 
	                        rest.getAddress(), 
	                        rest.getRestaurant_number(), 
	                        rest.getRating());
	            }
	        }
	        System.out.println("----------------------------------------------------------------------------------------------------------");
	    }

}
