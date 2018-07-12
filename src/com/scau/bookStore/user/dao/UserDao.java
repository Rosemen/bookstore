package com.scau.bookStore.user.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.scau.bookStore.user.entity.User;

public class UserDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public void add(User form) {
		hibernateTemplate.save(form);
	}

	@SuppressWarnings("unchecked")
	public List<User> findByName(String username) {
		List<User> userList = (List<User>) hibernateTemplate.find("from User where username=?", username);
		return userList;
	}

}
