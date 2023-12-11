package com.green.tonicbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.tonicbank.dao.UserDao;
import com.green.tonicbank.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
    UserDao userDao; // UserDao ���� 
    
	// ȸ������
	@Override
	public int join(User user) throws Exception {
		return userDao.join(user);
	}
	
	// ���� ��������
	@Override
	public User select(String userId) throws Exception {
		return userDao.select(userId);
	}
	
	// ���̵� �ߺ� Ȯ��
    @Override
    public int idCheck(String userId) throws Exception {
    	return userDao.idCheck(userId);
    }
    
    // �г��� �ߺ� Ȯ��
    @Override
    public int nickCheck(String nick) throws Exception {
    	return userDao.nickCheck(nick);
    }
    
    // �̸��� �ߺ� Ȯ��
    @Override
    public int emailCheck(String email) throws Exception {
    	return userDao.emailCheck(email);
    }
    
}
