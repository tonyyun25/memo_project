package com.lytear.memo.user.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.memo.user.dao.UserDAO;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	
	public int getMember(String loginId, String password, String name, String email) {
		return userDAO.insertMember(loginId, password, name, email);
	}
	
}
