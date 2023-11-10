package com.sh.pet.model.entity;

import java.sql.Date;

public class Pet {
	private int pNumber;
	private String pName;
	private String memberId;
	private String pType;
	private String gender;
	private int weight;
	private Date birthday;
	
	public Pet() {
		super();
	}
	
	public Pet(int pNumber, String pName, String memberId, String pType, String gender, int weight, Date birthday) {
		super();
		this.pNumber = pNumber;
		this.pName = pName;
		this.memberId = memberId;
		this.pType = pType;
		this.gender = gender;
		this.weight = weight;
		this.birthday = birthday;
	}

	public int getpNumber() {
		return pNumber;
	}

	public void setpNumber(int pNumber) {
		this.pNumber = pNumber;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Pet [pNumber=" + pNumber + ", pName=" + pName + ", memberId=" + memberId + ", pType=" + pType
				+ ", gender=" + gender + ", weight=" + weight + ", birthday=" + birthday + "]";
	}
	
	
}
