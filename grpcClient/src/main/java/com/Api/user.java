package com.Api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.protobuf.ByteString;

public class user {

	int userId;
	String userName;
	String email;
	String password;
	private String hashedPassword;
	private String salt;

	public user() {

	}

	public user(int userId, String userName, String email, String password) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

	public user(int userId, String userName, String email, String hashedPassword, String salt) {
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.hashedPassword = hashedPassword;
		this.salt = salt;
	}

	@JsonProperty
	public int getUserId() {
		return userId;
	}

	@JsonProperty
	public String getUserName() {
		return userName;
	}

	@JsonProperty
	public String getEmail() {
		return email;
	}

	@JsonProperty
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public String getHashedPassword() {
		return hashedPassword;
	}

	@JsonProperty
	public String getSalt() {
		return salt;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setHashedPassword(String hashedPassword) {
		this.hashedPassword = hashedPassword;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Override
	public String toString() {
		return "User{" + "userId=" + userId + " userName='" + userName + '\'' + " email='" + email + '\''
				+ " password='" + password + '\'' + " hashedPassword=" + hashedPassword + " salt=" + salt;
	}

}