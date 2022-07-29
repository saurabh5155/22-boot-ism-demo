package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {

	@Autowired
	JdbcTemplate stmt;

	public void signup(UserBean userBean) {
		stmt.update("insert into users (firstname,lastname,email,password,gender,usertype) values (?,?,?,?,?,?)",
				userBean.getFirstName(), userBean.getLastName(), userBean.getEmail(), userBean.getPassword(),
				userBean.getGender(), userBean.getUserType());
	}
}
