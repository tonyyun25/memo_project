package com.lytear.memo.user.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.lytear.memo.user.model.User;

@Repository
public interface UserDAO {

	public List<User> selectUserList();
	
	public int insertUserAsObject(User user);
	
	
	
	public int insertUser(
			//XML로 전달해야 하는데 서로 다른 데이터끼리 전달하기 위해서 param annotation 사용
			//뒤의 전달된 값을 앞의 XML에 사용할 수 있도록 저장 (아까 UserRestController와 반대)
			@Param("loginId") String loginId
			, @Param("password") String password
			, @Param("name") String name
			, @Param("email") String email
			);
	
	
	
}
