package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/signup")
	public ResponseEntity<?> getAllUsers(){
		List<UserBean> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}
	
	@DeleteMapping("/signup/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId){
		userDao.deleteUser(userId);
		return ResponseEntity.ok("User Deleted");
	}
}
