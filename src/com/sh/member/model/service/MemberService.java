package com.sh.member.model.service;

import static com.sh.common.JdbcTemplate.close;
import static com.sh.common.JdbcTemplate.commit;
import static com.sh.common.JdbcTemplate.getConnection;
import static com.sh.common.JdbcTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.sh.member.model.dao.MemberDao;
import com.sh.member.model.entity.Member;
import com.sh.pet.model.entity.Pet;

public class MemberService {
	private MemberDao memberDao = new MemberDao();
			
	public Member findById(String id) {
		Connection conn = getConnection();
		Member member = memberDao.findById(conn, id);
		close(conn);
		return member;
	}
	
	public Member findByPassword(String password) {
		Connection conn = getConnection();
		Member member = memberDao.findByPassword(conn, password);
		close(conn);
		return member;
	}

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = 0;
		try {
			result = memberDao.insertMember(conn, member);
			commit(conn);
		} catch (Exception e) {
			rollback(conn);
			throw e;
		} finally {
			close(conn);
		}
		return result;
	}

	public Member findLogin(Member login) {
		Connection conn = getConnection();
		Member member = memberDao.findLogin(conn, login);
		close(conn);
		return member;
	}

	public List<Pet> petFriend(String address) {
		Connection conn = getConnection();
		List<Pet> pets = memberDao.petFriend(conn, address);
		close(conn);
		return pets;
	}


}
