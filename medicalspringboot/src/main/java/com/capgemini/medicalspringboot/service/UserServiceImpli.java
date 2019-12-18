package com.capgemini.medicalspringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.medicalspringboot.bean.UserBean;
import com.capgemini.medicalspringboot.dao.UserDAO;

@Service
public class UserServiceImpli implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Override
	public UserBean getUser(int userId) {

		return userDAO.getUser( userId);
	}

	@Override
	public boolean addUser(UserBean bean) {
		return userDAO.addUser(bean);
	}

	@Override
	public List<UserBean> getAllUser() {
		return userDAO.getAllUser();
	}

	@Override
	public boolean removeUser(int userId) {
		return userDAO.removeUser(userId);
	}

	@Override
	public boolean updateUser(UserBean userBean) {
		return userDAO.updateUser(userBean);
	}

	@Override
	public UserBean userLogin(String email, String password) {
		return userDAO.userLogin(email, password);
	}

}
