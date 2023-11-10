package com.sh.member.model.vo;

import java.util.ArrayList;
import java.util.List;

import com.sh.member.model.entity.Member;
import com.sh.pet.model.entity.Pet;

public class MemberPet extends Member{
	private List<Pet> pet = new ArrayList<>();

	public MemberPet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberPet(int no, String id, String password, String name, String phone, String address, int point) {
		super(no, id, password, name, phone, address, point);
		// TODO Auto-generated constructor stub
	}

	public List<Pet> getPet() {
		return pet;
	}

	public void setPet(List<Pet> pet) {
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "MemberPet [pet=" + pet + ", toString()=" + super.toString() + "]";
	}
	
	
}
