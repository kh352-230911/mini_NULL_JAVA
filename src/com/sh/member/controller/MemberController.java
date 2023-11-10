package com.sh.member.controller;

import java.util.List;

import com.sh.member.model.entity.Member;
import com.sh.member.model.service.MemberService;
import com.sh.pet.model.entity.Pet;

public class MemberController {
	private MemberService memberService = new MemberService();
	
	public Member findById(String id) {
		Member member = null;
		try {
			member = memberService.findById(id);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return member;
	}
	
	public Member findByPassword(String password) {
		Member member = null;
		try {
			member = memberService.findByPassword(password);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return member;
	}

	public int insertMember(Member member) {
		int result = 0;
		try {
			result = memberService.insertMember(member);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return result;
	}

	public Member findLogin(Member login) {
		Member member = null;
		try {
			member = memberService.findLogin(login);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return member;
	}

	public List<Pet> petFriend(String address) {
		List<Pet> pets = null;
		try {
			pets = memberService.petFriend(address);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("> 불편을 드려 죄송합니다." + e.getMessage());
		}
		return pets;
	}

}
