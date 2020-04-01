package com.dips.singleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	
	private static DbConnection dbInstance = null;
	private String url ,port, username , password;
	private Connection con;
	
	private DbConnection(String url ,String port, String username , String password)
	{
		this.url = url;
		this.port = port;
		this.username = username;
		this.password = password;
	}
	
	public static DbConnection getInstance(String url ,String port, String username , String password)
	{
		if(dbInstance == null)
		{
			dbInstance = new DbConnection(url,port,username,password);
		}
		return dbInstance;
	}
	
	public Connection Connect(String db) throws ClassNotFoundException , SQLException
	{
		if(con == null || con.isClosed())
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url+port+"/"+db,username,password);
			System.out.println("Database Connection Successfully!!");
		}
		return con;
	}
	public void disconnect() throws SQLException {
		System.out.println("Database Connection Closed");
		con.close();
	}
}
