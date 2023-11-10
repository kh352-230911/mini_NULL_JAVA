package com.sh.pet.view;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.sh.member.view.MemberMenu;
import com.sh.pet.controller.PetController;
import com.sh.pet.model.entity.Pet;

public class PetMenu {
	private Scanner sc = new Scanner(System.in);
	private PetController petController = new PetController();

	public void petMenu() {
		String menu = """
					=====================
					      반려동물 정보
					=====================
					1. 정보 조회
					2. 정보 등록
					3. 정보 삭제
					0. 이전 메뉴
					=====================
					선택 : """;
		
		
		while(true) {
			System.out.println();
			System.out.print(menu);
			String choice = sc.next();
			
			List<Pet> pets = null;
			int result = 0;
			Pet pet = null;
			
			switch (choice) {
			case "1":
				pets = petController.findAll();
				displayPets(pets);
				break;
			case "2":
				result = petController.insertPet(inputPet());
				displayResult("정보 등록", result);
				break;
			case "3":
				result = petController.deletePet(inputPetName());
				displayResult("정보 삭제", result);
				break;
			case "0":
				new MemberMenu().petOraMenu();
			default:
				System.out.println("> 잘못 입력하셨습니다.");
				break;
			}
		}
	}

	private String inputPetName() {
		System.out.print("> 반려견 이름 입력 : ");
		return sc.next();
	}

	private Pet inputPet() {
		Pet pet = new Pet();
		System.out.println("> 반려견 정보를 입력하세요.");
		System.out.print("> 반려견 이름 : ");
		pet.setpName(sc.next());
		System.out.print("> 견주 아이디 : ");
		pet.setMemberId(sc.next());
		sc.nextLine();
		System.out.print("> 품종 : ");
		pet.setpType(sc.nextLine());
		System.out.print("> 성별(M/F) : ");
		pet.setGender(sc.next());
		System.out.print("> 몸무게 : ");
		pet.setWeight(sc.nextInt());
		System.out.print("> 생일 (2020-02-02) : ");
		pet.setBirthday(Date.valueOf(sc.next()));
		return pet;
	}

	private void displayResult(String type, int result) {
		if (result > 0)
			System.out.println("🐶🐶🐶🐶🐶🐶" +type + " 성공!!🐶🐶🐶🐶🐶🐶");
		else
			System.out.println("♨♨ " + type + " 실패!!♨♨");
	}

	private void displayPets(List<Pet> pets) {
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", 
                "No", "Name", "ID", "Type", "Gender", "Weight", "Birthday");
        System.out.println("--------------------------------------------------------------------------------------");
        if(pets == null || pets.isEmpty()) {
            System.out.println("\t\t 조회된 결과가 없습니다.");
        }
        else {
            for(Pet pet : pets) {
                System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%-10s\n", 
                        pet.getpNumber(), 
                        pet.getpName(), 
                        pet.getMemberId(), 
                        pet.getpType(), 
                        pet.getGender(), 
                        pet.getWeight(), 
                        pet.getBirthday());
            }
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }
}
