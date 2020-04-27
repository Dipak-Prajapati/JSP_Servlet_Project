package com.dips.pojo;

import java.util.Arrays;

public class AddressModel {

	public String buttonvalue;
	public int id;
	public String Email;
	public String[] address;
	public String[] city;
	public String[] country;
	public String[] state;
	public int[] addressId;

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String[] getAddress() {
		return address;
	}
	public void setAddress(String[] address) {
		this.address = address;
	}
	public String[] getCity() {
		return city;
	}
	public void setCity(String[] city) {
		this.city = city;
	}
	public String[] getCountry() {
		return country;
	}
	public void setCountry(String[] country) {
		this.country = country;
	}
	public String[] getState() {
		return state;
	}
	public void setState(String[] state) {
		this.state = state;
	}
	public int[] getAddressId() {
		return addressId;
	}
	public void setAddressId(int[] addressId) {
		this.addressId = addressId;
	}
	public String getButtonvalue() {
		return buttonvalue;
	}
	public void setButtonvalue(String buttonvalue) {
		this.buttonvalue = buttonvalue;
	}
	@Override
	public String toString() {
		return "AddressModel [buttonvalue=" + buttonvalue + ", id=" + id + ", Email=" + Email + ", address="
				+ Arrays.toString(address) + ", city=" + Arrays.toString(city) + ", country=" + Arrays.toString(country)
				+ ", state=" + Arrays.toString(state) + ", addressId=" + Arrays.toString(addressId) + "]";
	}
	

	
}
