package com.sh.member.model.entity;

public class Member {
	private int no;
	private String id;
	private String password;
	private String name;
	private String phone;
	private String address;
	private int point;
	
	public Member() {
		super();
	}

	public Member(int no, String id, String password, String name, String phone, String address, int point) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.point = point;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getPoint() {
		return point;
	}
	
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", name=" + name + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
	
}
