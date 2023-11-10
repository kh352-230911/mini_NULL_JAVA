package com.sh.pet.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sh.pet.model.entity.Pet;
import com.sh.pet.model.exception.PetException;

public class PetDao {
	private Properties prop = new Properties();
	
	public PetDao() {
		try {
			prop.load(new FileReader("resources/pet-query.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int insertPet(Connection conn, Pet pet) {
		int result = 0;
		String sql = prop.getProperty("insertPet");
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, pet.getpName());
			pstmt.setString(2, pet.getMemberId());
			pstmt.setString(3, pet.getpType());
			pstmt.setString(4, pet.getGender());
			pstmt.setInt(5, pet.getWeight());
			pstmt.setDate(6, pet.getBirthday());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new PetException("정보 등록 오류!!", e);
		}
		return result;
	}

	public List<Pet> findAll(Connection conn) {
		List<Pet> pets = new ArrayList<>();
		String sql = prop.getProperty("findAll");

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			try (ResultSet rset = pstmt.executeQuery()) {
				while (rset.next()) {
					Pet pet = new Pet();
					pet.setpNumber(rset.getInt("p_number"));
					pet.setpName(rset.getString("p_name"));
					pet.setMemberId(rset.getString("member_id"));
					pet.setpType(rset.getString("p_type"));
					pet.setGender(rset.getString("Gender"));
					pet.setWeight(rset.getInt("weight"));
					pet.setBirthday(rset.getDate("Birthday"));
					pets.add(pet);
				}
			}
		} catch (SQLException e) {
			throw new PetException("정보 조회 오류!!", e);
		}
		return pets;
	}

	public int deletePet(Connection conn, String name) {
		int result = 0;
		String sql = prop.getProperty("deletePet");
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new PetException("정보 삭제 오류!!", e);
		}
		return result;
	}

}
