package com.cscalpha.manager.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int Id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="userpassword")
	private String password;
	
	@Column(name="username")
	private String username;

	//manay to many mapping
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
	  name="users_roles",
	  joinColumns=@JoinColumn(name="user_id" , referencedColumnName="id"),
	  inverseJoinColumns=@JoinColumn(
			  name="role_id", referencedColumnName="id"))
	private Collection<Role> roles;
	
public User() {
	}
	




	public User(String firstName, String lastName,String username, String password, Collection<Role> roles) {
	
	this.firstName = firstName;
	this.lastName = lastName;
	this.username = username;
	this.password = password;
	this.roles = roles;
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

	

	public Collection<Role> getRoles() {
		return roles;
	}


	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}


	@Override
	public String toString() {
		return "User [Id=" + Id + ", firstName=" + firstName + ", lastName=" + lastName + ", password=" + password
				+ ", username=" + username + "]";
	}
	
	
	
	
}
