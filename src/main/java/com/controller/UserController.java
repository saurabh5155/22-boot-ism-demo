package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RestController;

import com.bean.ResponseBean;
import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class UserController {

	@Autowired
	UserDao userDao;

	@PostMapping("/signup")
	public ResponseEntity<?> saveUser(UserBean userBean) {

		UserBean dbUser = userDao.getDataByEmail(userBean.getEmail());

		if (dbUser == null) {
			userDao.signup(userBean);
			return ResponseEntity.ok(userBean);
		} else {
			ResponseBean<UserBean> resBean = new ResponseBean<>();
			resBean.setData(userBean);
			resBean.setResMsg("Email Already Exists");
			return new ResponseEntity(resBean, HttpStatus.BAD_REQUEST);
		}
	}

	private ResponseEntity<?> ResponseEntity(ResponseBean<UserBean> resBean, HttpStatus badRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@GetMapping("/signup")
	public ResponseEntity<?> getAllUsers() {
		List<UserBean> users = userDao.getAllUsers();
		return ResponseEntity.ok(users);
	}

	@DeleteMapping("/signup/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") int userId) {
		userDao.deleteUser(userId);
		return ResponseEntity.ok("User Deleted");
	}

	@PutMapping("/signup")
	public ResponseEntity<?> updateUser(UserBean userBean) {
		userDao.updateUser(userBean);
		return ResponseEntity.ok(userBean);
	}
}
