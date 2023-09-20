package com.fssa.liveon.model;

public class User {

	private String firstName;
	private String lastName;
	private String gender;
	private String email;
	private long number;
	private String password;
	private int userId;

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", email=" + email
				+ ", number=" + number + ", password=" + password + ", userId=" + userId + "]";
	}

	public User(String firstName, String lastName, String gender, String email, long number, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.number = number;
		this.password = password;
	}
    
	public User(int userId, String firstName, String lastName, long number) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;

	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return null;
	}

}
