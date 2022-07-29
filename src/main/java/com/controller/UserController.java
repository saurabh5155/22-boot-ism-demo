package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@PostMapping("/signup")
	public ResponseEntity<?> saveUser(UserBean userBean) {
		userDao.signup(userBean);
		return ResponseEntity.ok(userBean);
	}
}
