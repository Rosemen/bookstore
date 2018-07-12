package com.scau.bookStore.user.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.scau.bookStore.user.entity.User;
import com.scau.bookStore.user.service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;

	@Autowired
	private UserService userService;

	private User form = new User(); // ������

	@Override
	public User getModel() {
		return form;
	}

	public String login() {
		User user = null;
		try {
			//����service��¼����
			user = userService.login(form);
			//�����û�
			if (user != null)
				ServletActionContext.getRequest().getSession().setAttribute("user", user);
		} catch (Exception e) {
			System.out.println(e);
			ServletActionContext.getRequest().setAttribute("msg", e.getMessage());
			return "login";
		}
		return "index";
	}
	
	public String regist() {
		//����ע�᷽��
		try {
			userService.regist(form);
		} catch (Exception e) {
			System.out.println(e);
			ServletActionContext.getRequest().setAttribute("msg", e.getMessage());
			return "regist";
		}
		return "index";
	}

}
