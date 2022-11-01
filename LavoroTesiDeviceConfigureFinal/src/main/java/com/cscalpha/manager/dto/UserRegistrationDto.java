package com.cscalpha.manager.dto;



public class UserRegistrationDto {

	
	private int Id;
	private String firstName;
	private String lastName;
	private String password;
	private String username;
	
public UserRegistrationDto() {
	}

	public UserRegistrationDto(String firstName, String lastName, String username,String password) {
		
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		
	}
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
