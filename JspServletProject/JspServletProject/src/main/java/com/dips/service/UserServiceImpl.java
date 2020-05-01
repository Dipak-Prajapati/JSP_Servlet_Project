package com.dips.service;

import java.util.ArrayList;
import java.util.List;

import com.dips.dao.UserDao;
import com.dips.dao.UserDaoImpl;
import com.dips.pojo.UserModel;

public class UserServiceImpl implements UserService {

	UserDao daoRegister = new UserDaoImpl();

	@Override
	public boolean insertData(UserModel registerPojo) {
		// TODO Auto-generated method stub
		boolean status = daoRegister.addUser(registerPojo);
		return status;
	}

	@Override
	public UserModel login(String email, String password) {
		// TODO Auto-generated method stub
		UserModel status = daoRegister.login(email, password);
		return status;
	}

	@Override
	public boolean updateData(UserModel updatePojo) {
		// TODO Auto-generated method stub
		boolean status = daoRegister.updateData(updatePojo);
		return status;
	}

	@Override
	public String findPassword(String name) {
		// TODO Auto-generated method stub
		return daoRegister.findPassword(name);
	}

	@Override
	public List<UserModel> getUserData(UserModel userModel) {
		// TODO Auto-generated method stub
		List<UserModel> list = new ArrayList<UserModel>();
		list = daoRegister.getUserData();
		return list;
	}

	@Override
	public UserModel getUserInfo(int userId) {
		// TODO Auto-generated method stub
		return daoRegister.getUserInfo(userId);
	}

	@Override
	public boolean deleteData(int userId) {
		// TODO Auto-generated method stub
		return daoRegister.deleteData(userId);
	}

	@Override
	public boolean emailExist(String email) {
		// TODO Auto-generated method stub
		if(daoRegister.emailExist(email)) {
			return true;
		}
		else {
			return false;
		}
	}

}
