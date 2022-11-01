package com.cscalpha.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="userdevices")
public class Userdevice {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="username_id")
	private String userid;
	
	@Column(name="devicename_id")
	private String userdeviceid;
	
	
	public Userdevice() {
		
	}

	
	public Userdevice(String userid, String userdeviceid) {
	
		this.userid = userid;
		this.userdeviceid = userdeviceid;
	}


	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserdeviceid() {
		return userdeviceid;
	}

	public void setUserdeviceid(String userdeviceid) {
		this.userdeviceid = userdeviceid;
	}


	@Override
	public String toString() {
		return "Userdevice [id=" + id + ", userid=" + userid + ", userdeviceid=" + userdeviceid + "]";
	}
	
	
	
}
