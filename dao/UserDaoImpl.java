package com.green.tonicbank.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.tonicbank.model.User;

@Repository
public class UserDaoImpl implements UserDao {
	@Autowired
	SqlSession session;
	String namespace ="userMapper.";
	
	// ȸ������
	@Override
	public int join(User user) throws Exception {
		return session.insert(namespace+"insert", user);
	}
	
	//���� ��������
	@Override
	public User select(String userId) throws Exception {
		return session.selectOne(namespace+"select", userId);
	}
	
	// ���̵� �ߺ� Ȯ��
	@Override
	public int idCheck(String userId) throws Exception {
		return session.selectOne(namespace+"idCheck", userId);
	}
	
	// �г��� �ߺ� Ȯ��
	@Override
	public int nickCheck(String nick) throws Exception {
		return session.selectOne(namespace+"nickCheck", nick);
	}
	
	// �̸��� �ߺ� Ȯ��
	@Override
	public int emailCheck(String email) throws Exception {
		return session.selectOne(namespace+"emailCheck", email);
	}
}
