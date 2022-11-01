package com.cscalpha.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="device")
public class Device {

	@Id
	@Column(name="device_name")
	private String deviceName;

    public Device() {
	}

	public Device(String deviceName) {
		
		this.deviceName = deviceName;
	}



	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	
	
}
