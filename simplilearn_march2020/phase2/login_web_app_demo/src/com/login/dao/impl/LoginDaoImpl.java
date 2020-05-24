package com.login.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dbutil.OracleConnection;
import com.login.dao.LoginDAO;
import com.login.exception.BusinessException;
import com.login.model.User;

public class LoginDaoImpl implements LoginDAO {

	@Override
	public boolean isValidUser(User user) throws BusinessException {
		boolean b=false;
		try(Connection connection=OracleConnection.getConnection()){
			String sql="select userid from loginmaster where userid=? and password=?";
			PreparedStatement preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, user.getUserid());
			preparedStatement.setString(2, user.getPassword());
			ResultSet resultSet=preparedStatement.executeQuery();
			System.out.println("in DAO "+user);
			if(resultSet.next()) {
				b=true;
			}else {
				throw new BusinessException("Invalid Userid/password from DAO");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e);
			throw new BusinessException("Internal error occcured contact SYSADMIN");
		}
		return b;
	}

}
