package com.dips.service;

import java.util.List;

import com.dips.pojo.UserModel;

public interface UserService {

	public boolean insertData(UserModel registerPojo);

	public UserModel login(String email, String password);

	public boolean updateData(UserModel updatePojo);

	public String findPassword(String name);

	public List<UserModel> getUserData(UserModel userModel);

}
