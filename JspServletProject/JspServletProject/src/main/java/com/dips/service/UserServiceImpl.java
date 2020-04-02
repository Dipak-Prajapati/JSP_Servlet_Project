package com.dips.service;

import com.dips.dao.UserDao;
import com.dips.dao.UserDaoImpl;
import com.dips.pojo.UserModel;

public class UserServiceImpl implements UserService {

	UserDao daoRegister = new UserDaoImpl();

	@Override
	public boolean insertData(UserModel registerPojo) {
		// TODO Auto-generated method stub
		System.out.println("In ServiceRegister Class");
		System.out.println("serviceRegisterImpl registerPojo :" + registerPojo);
		/* registerPojo = new RegisterPojo(); */
		boolean status = daoRegister.addUser(registerPojo);
		return status;
	}

	@Override
	public UserModel login(String email, String password) {
		// TODO Auto-generated method stub
		UserModel status = daoRegister.login(email, password);
		return status;
	}

}
