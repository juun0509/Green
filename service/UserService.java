package com.green.tonicbank.service;

import com.green.tonicbank.model.User;

public interface UserService {

	// ȸ������
	int join(User user) throws Exception;
	
	// ���� ��������
	User select(String userId) throws Exception;
	
	//���̵� �ߺ� Ȯ��
	int idCheck(String userId) throws Exception;

	// �г��� �ߺ� Ȯ��
    int nickCheck(String nick) throws Exception;
    
    // �̸��� �ߺ� Ȯ��
    int emailCheck(String email) throws Exception;
    
}