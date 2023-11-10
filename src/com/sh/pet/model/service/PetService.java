package com.sh.pet.model.service;

import static com.sh.common.JdbcTemplate.close;
import static com.sh.common.JdbcTemplate.commit;
import static com.sh.common.JdbcTemplate.getConnection;
import static com.sh.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.sh.pet.model.dao.PetDao;
import com.sh.pet.model.entity.Pet;

public class PetService {
	private PetDao petDao = new PetDao();
	
	public int insertPet(Pet pet) {
		int result = 0;;
		
		Connection conn = getConnection();
		try {
			result = petDao.insertPet(conn, pet);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public List<Pet> findAll() {
		Connection conn = getConnection();
		List<Pet> pets = petDao.findAll(conn);
		close(conn);
		return pets;
	}

	public int deletePet(String name) {
		int result = 0;
		Connection conn = getConnection();
		
		try {
			result = petDao.deletePet(conn, name);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

}
