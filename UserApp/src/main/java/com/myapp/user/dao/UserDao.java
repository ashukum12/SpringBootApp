package com.myapp.user.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.myapp.user.model.User;

@Repository
public class UserDao {
	
	private static List<User> userList = new ArrayList<>();
	private static int id = 0;
	static
	{	
		userList.add(new User(++id, "Ashutosh", "Kumar", "ashutosh.kumar@gmail.com" ));
		userList.add(new User(++id , "sam", "jhon","sam.jhon@gmail.com"));
		userList.add(new User(++id, "Aric", "Bob", "Aric.bob@gmail.com"));
	}
	
	public List<User> getAllUser(){
		return userList;
	}
	
	public User getUserById(int id) {
		for(User user: userList) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	
	public User addUser(User user) {
			user.setId(++id);
			userList.add(user);
		
		return user;
	}
	
	public User deleteUserById(int id) {
		User user = getUserById(id);
		if(user == null) {
			return null; 
		}else {
			userList.remove(user);
		}
		return user;
	}
}
