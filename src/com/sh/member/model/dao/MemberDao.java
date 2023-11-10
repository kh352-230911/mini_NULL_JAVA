package com.sh.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sh.member.model.entity.Member;
import com.sh.member.model.exception.MemberException;
import com.sh.pet.model.entity.Pet;

public class MemberDao {
	private Properties prop = new Properties();
		
	public MemberDao() {
		try {
			prop.load(new FileReader("resources/member-query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member findById(Connection conn, String id) {
		Member member = null;
		String sql = prop.getProperty("findById"); 		
	
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, id);
			
			ResultSet rset = pstmt.executeQuery();
				while(rset.next()) {
					int no = rset.getInt("no");
					String password = rset.getString("password");
					String name = rset.getString("name");
					String phone = rset.getString("phone");
					String address = rset.getString("address");
					int point = rset.getInt("point");
					member = new Member(no, id, password, name, phone, address, point);
				}
			
		} catch (SQLException e) {
			throw new MemberException("아이디 조회 오류!!", e);
		}
		return member;
	}
	
	public Member findByPassword(Connection conn, String password) {
		Member member = null;
		String sql = prop.getProperty("findByPassword"); 		
	
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, password);
			
			ResultSet rset = pstmt.executeQuery();
				while(rset.next()) {
					int no = rset.getInt("no");
					String id = rset.getString("id");
					String name = rset.getString("name");
					String phone = rset.getString("phone");
					String address = rset.getString("address");
					int point = rset.getInt("point");
					member = new Member(no, id, password, name, phone, address, point);
				}
			
		} catch (SQLException e) {
			throw new MemberException("비밀번호 조회 오류!!", e);
		}
		return member;
	}

	public int insertMember(Connection conn, Member member) {
		String sql = prop.getProperty("insertMember");
		int result = 0;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getPhone());
			pstmt.setString(5, member.getAddress());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new MemberException("회원 가입 오류!!", e);
		}
		return result;
	}

	public Member findLogin(Connection conn, Member login) {
		String sql = prop.getProperty("findLogin");
		Member member = null;
		
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getPassword());
			
			ResultSet rset = pstmt.executeQuery();
				while(rset.next()) {
					int no = rset.getInt("no");
					String name = rset.getString("name");
					String phone = rset.getString("phone");
					String address = rset.getString("address");
					int point = rset.getInt("point");
					member = new Member(no, login.getId(), login.getPassword(), name, phone, address, point);
				}
			
		} catch (SQLException e) {
			throw new MemberException("로그인 오류!!", e);
		}
		return member;
	}

	public List<Pet> petFriend(Connection conn, String address) {
		List<Pet> pets = new ArrayList<>();
		String sql = prop.getProperty("petfriend");
		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, "%"+ address + "%");
			try (ResultSet rset = pstmt.executeQuery()) {
				while(rset.next()) {
					Pet pet = new Pet();
					pet.setpNumber(rset.getInt("p_number"));
					pet.setpName(rset.getString("p_name"));
					pet.setMemberId(rset.getString("member_id"));
					pet.setpType(rset.getString("p_type"));
					pet.setGender(rset.getString("Gender"));
					pet.setWeight(rset.getInt("Weight"));
					pet.setBirthday(rset.getDate("Birthday"));
					pets.add(pet);
				}
				while(rset.next()) {
					Member mm = new Member();
					mm.setNo(rset.getInt("no"));
					mm.setId(rset.getString("id"));
					mm.setPassword(rset.getString("password"));
					mm.setName(rset.getString("name"));
					mm.setPhone(rset.getString("Phone"));
					mm.setAddress(rset.getString("address"));
				}
			}
		} catch (SQLException e) {
			throw new MemberException("친구찾기 오류!!", e);
		}
		return pets;
	}

}
