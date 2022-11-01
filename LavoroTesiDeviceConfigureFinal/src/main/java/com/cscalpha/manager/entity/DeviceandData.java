package com.cscalpha.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="deviceanddata")
public class DeviceandData {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="devicename_id1")
	private String deviceid;
	
	@Column(name="dataname_id")
	private String dataid;
	
public DeviceandData() {
	}

	public DeviceandData(String deviceid, String dataid) {
		
		this.deviceid = deviceid;
		this.dataid = dataid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getDataid() {
		return dataid;
	}

	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	
	
}
