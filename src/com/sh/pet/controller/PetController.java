package com.sh.pet.controller;

import java.util.List;

import com.sh.pet.model.entity.Pet;
import com.sh.pet.model.service.PetService;

public class PetController {
	private PetService petService = new PetService();
	
	public int insertPet(Pet pet) {
		int result = 0;
		try {
			result = petService.insertPet(pet);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return result;
	}

	public List<Pet> findAll() {
		List<Pet> pets = null;
		try {
			pets = petService.findAll();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return pets;
	}

	public int deletePet(String name) {
		int result = 0;
		try {
			result = petService.deletePet(name);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return result;
	}

}
