package com.dips.dao;

import java.util.List;

import com.dips.pojo.AddressModel;

public interface AddressDao {
	
	public int addinsertid(AddressModel addressPojo);
	public boolean insertAddress(AddressModel addressPojo);
	
	public List<Object> getUpdateaddress(AddressModel addressPojo);
	
	public List<Object> getInsertaddress(AddressModel addressPojo);
	
	public List<List<Object>> login(int id);

	public int updateData(AddressModel addressPojo);
}
