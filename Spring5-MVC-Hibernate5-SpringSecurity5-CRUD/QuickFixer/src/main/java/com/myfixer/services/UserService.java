package com.myfixer.services;

import java.util.List;

import com.myfixer.entity.User;

public interface UserService {
	
	boolean save(User user);
	
	List<User> list();
	
	User get(int id);
	
	boolean delete(int id);
	
	User findUserByName(String name);
	
	boolean changePassword(String newPassword, User user);
}
