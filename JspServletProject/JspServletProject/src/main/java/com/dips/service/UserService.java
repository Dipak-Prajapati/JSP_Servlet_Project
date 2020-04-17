package com.dips.service;

import com.dips.pojo.UserModel;

public interface UserService {

	public boolean insertData(UserModel registerPojo);

	public UserModel login(String email, String password);

	public boolean updateData(UserModel updatePojo);

	public String findPassword(String name);

}
