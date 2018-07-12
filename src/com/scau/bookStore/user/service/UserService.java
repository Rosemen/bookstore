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

	/* ��¼���� */
	public User login(User form) throws Exception {
		List<User> userList = userDao.findByName(form.getUsername());
		if (userList.size() == 0)
			throw new Exception("�û�������");
		for (User user : userList) {
			if (user.getUpassword().equals(form.getUpassword()))
				return user;
		}
		throw new Exception("�������");
	}

	/* ע�᷽�� */
	public void regist(User form) throws Exception {
		// �鿴�û����Ƿ����
		List<User> userList = userDao.findByName(form.getUsername());
		if (userList.size() != 0)
			throw new Exception("�û����ѱ�ע��");
		// ���û����뵽���ݿ���
		userDao.add(form);
	}

}
