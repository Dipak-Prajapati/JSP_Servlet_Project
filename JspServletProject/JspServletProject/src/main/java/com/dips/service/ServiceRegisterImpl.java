package com.dips.service;

import com.dips.dao.DaoRegister;
import com.dips.dao.DaoRegisterImpl;
import com.dips.pojo.RegisterPojo;

public class ServiceRegisterImpl implements ServiceRegister{

	DaoRegister daoRegister = new DaoRegisterImpl();
	@Override
	public boolean insertData(RegisterPojo registerPojo) {
		// TODO Auto-generated method stub
		System.out.println("In ServiceRegister Class");
		System.out.println("serviceRegisterImpl registerPojo :"+registerPojo);
		/* registerPojo = new RegisterPojo(); */
		boolean status = daoRegister.addUser(registerPojo);
		return status;
	}
	
}
