package com.myfixer.services;

import java.util.List;
import java.util.logging.Logger;

import com.myfixer.dao.UserDAO;
import com.myfixer.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	private Logger logger = Logger.getLogger(UserServiceImpl.class.getName());
	@Autowired
    UserDAO userDAO;

	@Override
	public boolean save(User user) {
		boolean flag = userDAO.save(user);
		return flag;
	}

	@Override
	public List<User> list() {
		List<User> list = userDAO.list();
		return list;
	}

	@Override
	public User get(int id) {
		User user = userDAO.get(id);
		return user;
	}

	@Override
	public boolean delete(int id) {
		boolean flag = userDAO.delete(id);
		return flag;
	}

	@Override
	public User findUserByName(String name) {
		User user = userDAO.findUserByName(name);
		return user;
	}

	@Override
	public boolean changePassword(String newPassword, User user) {
		boolean flag = userDAO.changePassword(newPassword, user);;
		return flag;
	}
}
