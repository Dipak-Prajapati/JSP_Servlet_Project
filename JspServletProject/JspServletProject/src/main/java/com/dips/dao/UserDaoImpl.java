package com.dips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dips.pojo.UserModel;
import com.dips.singleton.DbConnection;

public class UserDaoImpl implements UserDao{

	Connection con;
	//ResultSet result;
//	PreparedStatement preparedStatement;
	DbConnection dbInstance;
	
	public UserDaoImpl()
	{
		System.out.println("Hello Constructor from Dao");
		dbInstance = DbConnection.getInstance("jdbc:mysql://localhost:","3306","root","password");
		System.out.println(dbInstance);
		try {
			con=dbInstance.Connect("jspservlet");
			System.out.println("Database name passed" + con);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("\n Failed To Connnect DB " + e );
		}
	}
	
	/*
	 * @Override public void connect() { // TODO Auto-generated method stub try {
	 * con=dbInstance.Connect("jspservlet");
	 * System.out.println("Database name passed" + con); } catch
	 * (ClassNotFoundException | SQLException e) {
	 * System.out.println("\n Failed To Connnect DB " + e ); } }
	 */

	@Override
	public boolean addUser(UserModel registerPojo) {
		// TODO Auto-generated method stub
		boolean result = false;
		System.out.println(registerPojo);
		System.out.println("In DaoRegister Class addUser");
		
		try
		{
			
			System.out.println(registerPojo.getDob());
			String query = "insert into user(firstname, middlename, lastname, email, dob, mobile_no, gender, language, hobbie, password) values(?,?,?,?,?,?,?,?,?,?)";	
			PreparedStatement ps = con.prepareStatement(query);
//			preparedStatement = con.prepareStatement(query);
			ps.setString(1, registerPojo.getFirstName());
			ps.setString(2, registerPojo.getMiddleName());
			ps.setString(3, registerPojo.getLastName());
			ps.setString(4, registerPojo.getEmail());
			ps.setString(5, registerPojo.getDob());
			ps.setString(6, registerPojo.getMobile_no());
			ps.setString(7, registerPojo.getGender());
			ps.setString(8, registerPojo.getLanguage());
			ps.setString(9, registerPojo.getHiobbie());
			ps.setString(10, registerPojo.getPassword());
			
			System.out.println(registerPojo.getDob());
			
			result = ps.executeUpdate() > 0;
		
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
		return result;
	}

}