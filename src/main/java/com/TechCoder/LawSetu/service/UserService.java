package com.TechCoder.LawSetu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TechCoder.LawSetu.dao.AdvocateDao;
import com.TechCoder.LawSetu.dao.UserDao;
import com.TechCoder.LawSetu.model.Advocate;
import com.TechCoder.LawSetu.model.User;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private AdvocateService advocateService;

	// Create User
	public User registerUser(User userObj) {
		return userDao.save(userObj);
	}
	
	// Activate User
	public Boolean activateAccount(String userEmail) {
		User existingUser = userDao.findByUserEmail(userEmail).orElse(new User());
		if(existingUser != null) {
			existingUser.setActive(true); 
			userDao.save(existingUser);
			return true;
		}else {

			return false;
			
		}
	}

	// Find user By email
	public User findByUserEmail(String userEmail) {
		return userDao.findByUserEmail(userEmail).orElse(new User());
	}

	// Find all User
	public Iterable<User> findAll() {
		return userDao.findAll();
	}

	// Login User

	public Boolean loginUser(String userEmail, String userPass) {

		User userObj = userDao.findByUserEmail(userEmail).orElse(new User());

		if (userObj.getUserId() != null && userObj.getUserPassword().equals(userPass) && userObj.getUserRole() == 2) {

			return true;

		} else {

			return false;

		}

	}

	public Boolean loginAdvocate(String userEmail, String userPass) {

		User userObj = userDao.findByUserEmail(userEmail).orElse(new User());

		if (userObj.getUserId() != null && userObj.getUserPassword().equals(userPass) && userObj.getUserRole() == 1) {

			return true;

		} else {

			return false;

		}

	}

}
