/**
 * 
 */
package com.dips.dao;

import java.util.List;

import com.dips.pojo.UserModel;

/**
 * @author Dip'$
 *
 */
public interface UserDao {
	
	//public void connect();
	
	public boolean addUser(UserModel registerPojo);
	
	public UserModel login(String email , String password);
	
	public boolean updateData(UserModel updatePojo);
	
	public String findPassword(String name);

	public List<UserModel> getUserData();
}
