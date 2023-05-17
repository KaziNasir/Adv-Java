package com.myfixer.dao;

import java.util.List;

import com.myfixer.entity.User;

public interface UserDAO {
	
	boolean save(User user);
	
	List<User> list();
	
	User get(int id);
	
	boolean delete(int id);
	
	User findUserByName(String name);
	
	boolean changePassword(String newPassword, User user);
}
