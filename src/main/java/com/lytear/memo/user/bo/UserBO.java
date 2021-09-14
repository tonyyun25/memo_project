package com.lytear.memo.user.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lytear.memo.common.EncryptUtils;
import com.lytear.memo.user.dao.UserDAO;
import com.lytear.memo.user.model.User;

@Service
public class UserBO {

	@Autowired
	private UserDAO userDAO;
	
	public List<User> getUserList() {
		return userDAO.selectUserList();
	}
	
	public int addUserAsObject(User user) {
		return userDAO.insertUserAsObject(user);
	}
	
	
	
	public int addUser(String loginId, String password, String name, String email) {
		// password 암호화
		
		// 방법1 : 객체 생성 할 때
		//EncryptUtils utils = new EncryptUtils();
		
		//String encryptPassword = utils.md5(password);// 암호화된 결과를 받음
		
		
		
		// 방법2: static으로 바꾼 후에는 아래
		String encryptPassword = EncryptUtils.md5(password);
		
		return userDAO.insertUser(loginId, encryptPassword, name, email);
	}
	
	
	
}
