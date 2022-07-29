package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
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

	public List<UserBean> getAllUsers() {
		return stmt.query("select * from users", new BeanPropertyRowMapper<UserBean>(UserBean.class));
	}

	public void deleteUser(int userId) {
		stmt.update("delete from users where userid =?", userId);
	}

	public void updateUser(UserBean userBean) {
		stmt.update("update users set firstname=?,lastname=?,email=?,password=?,gender=?,usertype=? where userid =?",
				userBean.getFirstName(), userBean.getLastName(), userBean.getEmail(), userBean.getPassword(),
				userBean.getGender(), userBean.getUserType(), userBean.getUserId());
	}

	public UserBean getDataByEmail(String email) {
		List<UserBean> user = null;
		try {
			user = stmt.query("select * from users where email =?",
					new BeanPropertyRowMapper<UserBean>(UserBean.class), new Object[]{email});
		} catch (Exception e) {
			System.out.println("Error in UserDao -> GetDataByEmail()");
		}
		if(user.size()==0) {
			return null;
		}else {
			return user.get(0);
		}
	}
}
