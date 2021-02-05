package com.hotel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.dao.CartDao;
import com.hotel.dao.FoodItemsDao;
import com.hotel.dao.UserDao;
import com.hotel.model.Cart;
import com.hotel.model.FoodItems;
import com.hotel.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public List<User> validateUser(String emailid, String userpassword) {
		// TODO Auto-generated method stub
		return this.userDao.validateUser(emailid,userpassword);
	}

	public User createUser(User u) {
		// TODO Auto-generated method stub
		
		return this.userDao.createUser(u);
	}

	public User getUserData(int uid) {
		// TODO Auto-generated method stub
		return this.userDao.getUserData(uid);
	}

	public List<User> getAllUserData() {
		// TODO Auto-generated method stub
		return this.userDao.getAllUserData();
	}

	
	

	
	
	
	
}
