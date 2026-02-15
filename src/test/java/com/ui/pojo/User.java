package com.ui.pojo;

public class User {

	private String  emailAddress;
	private String password;  
	private String expectedUserName;
	
	/**
	 * @param emailAddress
	 * @param password
	 * @param expectedUserName;
	 */
	public User(String emailAddress, String password, String expectedUserName) {
		super();
		this.emailAddress = emailAddress;
		this.password = password;
		this.expectedUserName=expectedUserName;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getExpectedUserName() {
	        return expectedUserName;
	    }
	
	@Override
	public String toString() {
		return "User [emailAddress=" + emailAddress + ", password=" + password + ", expectedUserName="
				+ expectedUserName + "]";
	}
	
	
	
	
	
}
