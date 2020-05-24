package com.login.bo.impl;

import com.login.bo.LoginBO;
import com.login.dao.LoginDAO;
import com.login.dao.impl.LoginDaoImpl;
import com.login.exception.BusinessException;
import com.login.model.User;

public class LoginBoImpl implements LoginBO {

	private LoginDAO loginDAO=new LoginDaoImpl();
	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b = false;
		if (user != null && user.getUserid().endsWith("@simplilearn.com")
				&& user.getPassword().matches("[a-z]{3,4}[0-9]{2}#[0-9]{2,3}[A-Z]{1}")) {
			// code here for DAO
			b=loginDAO.isValidUser(user);
		} else {
			throw new BusinessException("Invalid UserId/Password from BO");
		}

		return b;
	}

}
