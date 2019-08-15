package com.myapp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myapp.user.dao.UserDao;
import com.myapp.user.model.User;

@Service
public class UserService {
	
	@Autowired
	public UserDao userDao;
	
	public List<User> getAllUser() {
		return userDao.getAllUser();	
	}
	
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	public User addUser(User user) {
		return userDao.addUser(user);
	}
	
	public User deleteUserById(int id) {
		return userDao.deleteUserById(id);
	}
}
