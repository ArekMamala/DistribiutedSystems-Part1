//Arkadiusz Mamala
//G00349088 part 2 DS

package com.Api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ByteString;

public class user {

	//variables 
	int userId;
	String userName;
	String email;
	String password;
	private String hashedPassword;
	private String salt;

	//empty constructor
	public user() {

	}

	//constructor with password
	public user(int userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	//constructor with hashed and salt
	public user(int userId, String userName, String email, String hashedPassword, String salt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	//get method for userID
	@JsonProperty
	public int getUserId() {
		return userId;
	}

	//get method for user Name 
	@JsonProperty
	public String getUserName() {
		return userName;
	}
	
	//get method for getting the email
	@JsonProperty
	public String getEmail() {
		return email;
	}

	//get method for getting the password
	@JsonProperty
	public String getPassword() {
		return password;
	}

	//get method for getting the hashed password
	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}

	//get method for salt
	@JsonProperty
	public String getSalt() {
		return salt;
	}

	//set method for ID
	public void setUserId(int userId) {
		this.userId = userId;
	}

	//set method for name
	public void setUserName(String userName) {
		this.userName = userName;
	}

	//set method for email
	public void setEmail(String email) {
		this.email = email;
	}

	//set method for password
	public void setPassword(String password) {
		this.password = password;
	}

	//set method for hashed password
	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	//set method for salt
	public void setSalt(String salt) {
		this.salt = salt;
	}

	//string method to string
	@Override
	public String toString() {
		return "User{" + "userId=" + userId + " userName='" + userName + '\'' + " email='" + email + '\''
				+ " password='" + password + '\'' + " hashedPassword=" + hashedPassword + " salt=" + salt;
	}

}
