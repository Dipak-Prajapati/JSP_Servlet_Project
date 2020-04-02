package com.dips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.dips.pojo.UserModel;
import com.dips.singleton.DbConnection;

public class UserDaoImpl implements UserDao {

	Connection con;
	ResultSet result;
	PreparedStatement ps;
	DbConnection dbInstance;

	public UserDaoImpl() {
		System.out.println("Hello Constructor from Dao");
		dbInstance = DbConnection.getInstance("jdbc:mysql://localhost:", "3306", "root", "password");
		System.out.println(dbInstance);
		try {
			con = dbInstance.Connect("jspservlet");
			System.out.println("Database name passed" + con);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("\n Failed To Connnect DB " + e);
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

		try {

			System.out.println(registerPojo.getDob());
			String query = "insert into user(firstname, middlename, lastname, email, dob, mobile_no, gender, language, hobbie, password,profile_pic) values(?,?,?,?,?,?,?,?,?,?,?)";
			ps = con.prepareStatement(query); // preparedStatement =
			con.prepareStatement(query);
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
			ps.setString(11, registerPojo.getImage());

			result = ps.executeUpdate() > 0;

		} catch (SQLException e) {
			System.out.println(e);
		}

		return result;
	}

	/**
	 *
	 */
	@Override
	public UserModel login(String email, String password) {
		// TODO Auto-generated method stub
		UserModel userModel = null;

		try {
			String query = "select * from user where email=? and password=?";
			ps = con.prepareStatement(query);

			ps.setString(1, email);
			ps.setString(2, password);

			result = ps.executeQuery();

			if (result.next()) {
				userModel = new UserModel();

				userModel.setFirstName(result.getString("firstname"));
				userModel.setMiddleName(result.getString("middlename"));
				userModel.setLastName(result.getString("lastname"));

				userModel.setEmail(result.getString("email"));
				Date date = result.getDate("dob");
				//Date date = Calendar.getInstance().getTime();
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String strDate = dateFormat.format(date);
				userModel.setDob(strDate);
				userModel.setMobile_no(result.getString("mobile_no"));
				userModel.setGender(result.getString("gender"));
				userModel.setLanguage(result.getString("language"));
				userModel.setHiobbie(result.getString("hobbie"));
				userModel.setPassword(result.getString("password"));
				// profile_pic
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return userModel;
	}

}
