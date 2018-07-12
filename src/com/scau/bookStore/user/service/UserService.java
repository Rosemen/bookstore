package com.scau.bookStore.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import com.scau.bookStore.user.dao.UserDao;
import com.scau.bookStore.user.entity.User;

@Transactional
public class UserService {
	@Autowired
	private UserDao userDao;

	/* 登录方法 */
	public User login(User form) throws Exception {
		List<User> userList = userDao.findByName(form.getUsername());
		if (userList.size() == 0)
			throw new Exception("用户不存在");
		for (User user : userList) {
			if (user.getUpassword().equals(form.getUpassword()))
				return user;
		}
		throw new Exception("密码错误");
	}

	/* 注册方法 */
	public void regist(User form) throws Exception {
		// 查看用户名是否存在
		List<User> userList = userDao.findByName(form.getUsername());
		if (userList.size() != 0)
			throw new Exception("用户名已被注册");
		// 将用户加入到数据库中
		userDao.add(form);
	}

}
