package com.dips.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dips.pojo.AddressModel;

import com.dips.singleton.DbConnection;

public class AddressDaoImpl implements AddressDao {

	Connection con;
	ResultSet result;
	PreparedStatement ps;
	DbConnection dbInstance;

	public AddressDaoImpl() {
		System.out.println("Hello Constructor from AddressDao");
		dbInstance = DbConnection.getInstance("jdbc:mysql://localhost:", "3306", "root", "password");
		System.out.println(dbInstance);
		try {
			con = dbInstance.Connect("jspservlet");
			System.out.println("Database name passed" + con);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("\n Failed To Connnect DB " + e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean insertAddress(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		// int recordCounter=0;
		boolean status = false;
		List<Object> userAddress = new ArrayList<Object>();
		userAddress = getInsertaddress(addressPojo);
		int index = 0;
		while (userAddress.size() > index) {
			try {
				int userId = addinsertid(addressPojo);
				System.out.println("User_ID : " + userId);
				ps = con.prepareStatement(
						"insert into address(address, city, state, country, user_id)values(?,?,?,?,?)");
				ps.setString(1, ((List<Object>) userAddress.get(index)).get(0).toString());
				ps.setString(2, ((List<Object>) userAddress.get(index)).get(1).toString());
				ps.setString(3, ((List<Object>) userAddress.get(index)).get(2).toString());
				ps.setString(4, ((List<Object>) userAddress.get(index)).get(3).toString());
				ps.setInt(5, userId);
				ps.executeUpdate();
				System.out.println("successfully insert address");
			} catch (Exception e) {
				e.printStackTrace();
			}
			index++;
			status = true;
		}
		return status;
	}

	@Override
	public List<Object> getInsertaddress(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		String[] address = addressPojo.getAddress();
		String[] city = addressPojo.getCity();
		String[] state = addressPojo.getState();
		String[] country = addressPojo.getCountry();
		System.out.println("In method after array print");
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < address.length; i++) {
			ArrayList<Object> addModelData = new ArrayList<Object>();
			addModelData.add(address[i]);
			addModelData.add(city[i]);
			addModelData.add(state[i]);
			addModelData.add(country[i]);
			list.add(addModelData);
		}
		System.out.println(list);
		return list;
	}

	@Override
	public List<Object> getUpdateaddress(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		String[] address = addressPojo.getAddress();
		String[] city = addressPojo.getCity();
		String[] state = addressPojo.getState();
		String[] country = addressPojo.getCountry();
		int[] addressId = addressPojo.getAddressId();

		System.out.println("In method after array print");
		List<Object> list = new ArrayList<Object>();
		for (int i = 0; i < address.length; i++) {
			ArrayList<Object> addModelData = new ArrayList<Object>();
			addModelData.add(address[i]);
			addModelData.add(city[i]);
			addModelData.add(state[i]);
			addModelData.add(country[i]);
			addModelData.add(addressId[i]);
			list.add(addModelData);
		}
		System.out.println(list);
		return list;
	}

	@Override
	public int addinsertid(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		int userId = 0;
		try {
			System.out.println(con);
			ps = con.prepareStatement("select user_id from user where email = ?");
			ps.setString(1, addressPojo.getEmail());
			result = ps.executeQuery();
			result.next();
			userId = result.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public List<List<Object>> login(int id) {
		// TODO Auto-generated method stub

		// AddressModel addressPojo = null;
		List<List<Object>> addressShow = new ArrayList<List<Object>>();
		try {
			String query = "select * from address where user_id=?";
			ps = con.prepareStatement(query);

			ps.setInt(1, id);
			result = ps.executeQuery();

			while (result.next()) {
				List<Object> results = new ArrayList<Object>();
				results.add(0, result.getString("address"));
				results.add(1, result.getString("city"));
				results.add(2, result.getString("state"));
				results.add(3, result.getString("country"));
				results.add(4, result.getInt("address_id"));
				System.out.println("address_id" + result.getInt("address_id"));
				addressShow.add(results);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return addressShow;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int updateData(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		int status = 0;
		List<Object> updateAddress = new ArrayList<Object>();

		deleteAddress(addressPojo);
		insertAdd(addressPojo);
		updateAddress = getUpdateaddress(addressPojo);
		int index = 0;
		while (updateAddress.size() > index) {
			try {
				ps = con.prepareStatement(
						"update address set address= ?,city = ?,state = ?,country = ? where user_id = ? and address_id = ?");
				ps.setString(1, ((List<Object>) updateAddress.get(index)).get(0).toString());
				ps.setString(2, ((List<Object>) updateAddress.get(index)).get(1).toString());
				ps.setString(3, ((List<Object>) updateAddress.get(index)).get(2).toString());
				ps.setString(4, ((List<Object>) updateAddress.get(index)).get(3).toString());
				System.out.println("address,city,state,country complete ");
				ps.setInt(5, addressPojo.getId());
				ps.setString(6, ((List<Object>) updateAddress.get(index)).get(4).toString());
				ps.executeUpdate();
				System.out.println("successfully update address");
			} catch (Exception e) {
				e.printStackTrace();
			}
			index++;
		}
		return status;

	}

	private void insertAdd(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		int userId = addressPojo.getId();
		int[] addressId = addressPojo.getAddressId();

		for (int i = 0; i < addressId.length; i++) {
			if (addressId[i] == 555) {
				System.out.println("555 id : addressId[" + i + "] :" + addressId[i]);
				try {
					ps = con.prepareStatement(
							"insert into address(address, city, state, country, user_id)values(?,?,?,?,?)");
					ps.setString(1, addressPojo.address[i]);
					ps.setString(2, addressPojo.city[i]);
					ps.setString(3, addressPojo.state[i]);
					ps.setString(4, addressPojo.country[i]);
					ps.setInt(5, userId);
					ps.executeUpdate();
					System.out.println("insert address");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private void deleteAddress(AddressModel addressPojo) {
		// TODO Auto-generated method stub
		int userId = addressPojo.getId();
		int[] addressId = addressPojo.getAddressId();
		System.out.println("deleteAddress() in :" + userId);
		try {
			String query = "select address_id from address where user_id=?";
			ps = con.prepareStatement(query);
			ps.setInt(1, userId);
			result = ps.executeQuery();
			List<Integer> delId = new ArrayList<Integer>();
			while (result.next()) {
				System.out.println("deleteAddress() in address_id : " + result.getInt("address_id"));
				delId.add(result.getInt("address_id"));
			}
			List<Integer> addId = new ArrayList<Integer>();
			for (int k = 0; k < addressId.length; k++) {
				if (addressId[k] != 555) {
					addId.add(addressId[k]);
				}
			}
			System.out.println("addId size" + addId.size());
			if (addId.size() == 0) {
				ps = con.prepareStatement("delete from address where user_id = ?");
				ps.setInt(1, userId);
				ps.executeUpdate();
			}

			delId.removeAll(addId);
			System.out.println("delId List:"+delId);

			for (int i = 0; i < delId.size(); i++) {
				System.out.println("delId :"+delId.get(i));
				ps = con.prepareStatement("delete from address where address_id = ?");
				ps.setInt(1, delId.get(i));
				ps.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public boolean deleteData(int userId) {
		// TODO Auto-generated method stub
		try {
			ps = con.prepareStatement("delete from address where user_id = ?");
			ps.setInt(1, userId);

			int status = ps.executeUpdate();

			if (status > 0) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
