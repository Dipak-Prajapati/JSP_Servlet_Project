package com.dips.service;

import java.util.List;

import com.dips.pojo.AddressModel;

public interface AddressService {
	
	public boolean insertAddress(AddressModel addressPojo);
	
	public List<List<Object>> login(int id);

	public int updateData(AddressModel addressPojo);

}
