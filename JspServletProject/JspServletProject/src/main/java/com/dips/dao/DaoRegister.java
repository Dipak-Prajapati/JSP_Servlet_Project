/**
 * 
 */
package com.dips.dao;

import com.dips.pojo.RegisterPojo;

/**
 * @author Dip'$
 *
 */
public interface DaoRegister {
	
	public void connect();
	
	public boolean addUser(RegisterPojo registerPojo);
}
