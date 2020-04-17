package com.dips.service;

import java.util.List;

import com.dips.dao.AddressDao;
import com.dips.dao.AddressDaoImpl;
import com.dips.pojo.AddressModel;

public class AddressServiceImpl implements AddressService{

	AddressDao addressDao = new AddressDaoImpl();
	@Override
	public boolean insertAddress(AddressModel addressPojo) {
		// TODO Auto-generated method stub
			
		return addressDao.insertAddress(addressPojo);
	}

	@Override
	public List<List<Object>> login(int id) {
		// TODO Auto-generated method stub
		return addressDao.login(id);
	}

	@Override
	public int updateData(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		return addressDao.updateData(addressPojo);
	}

}
