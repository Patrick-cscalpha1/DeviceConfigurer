package com.cscalpha.manager.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="userconfiguration")
public class UserDeviceConfig {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="config_id")
	private int id;
	
	@Column(name="sourcedevice")
	private String sourceDevice;
	
	@Column(name="targetdevice")
	private String targetDevice;
	
	@Column(name="sourcedata")
	private String sourceData;
	
	@Column(name="user_id")
	private String usernameconfig;
	
	public UserDeviceConfig() {
	}

	public UserDeviceConfig(String sourceDevice, String targetDevice, String sourceData, String usernameconfig) {
		
		this.sourceDevice = sourceDevice;
		this.targetDevice = targetDevice;
		this.sourceData = sourceData;
		this.usernameconfig = usernameconfig;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSourceDevice() {
		return sourceDevice;
	}

	public void setSourceDevice(String sourceDevice) {
		this.sourceDevice = sourceDevice;
	}

	public String getTargetDevice() {
		return targetDevice;
	}

	public void setTargetDevice(String targetDevice) {
		this.targetDevice = targetDevice;
	}

	public String getSourceData() {
		return sourceData;
	}

	public void setSourceData(String sourceData) {
		this.sourceData = sourceData;
	}

	public String getUsernameconfig() {
		return usernameconfig;
	}

	public void setUsernameconfig(String usernameconfig) {
		this.usernameconfig = usernameconfig;
	}

	@Override
	public String toString() {
		return "UserDeviceConfig [id=" + id + ", sourceDevice=" + sourceDevice + ", targetDevice=" + targetDevice
				+ ", sourceData=" + sourceData + ", usernameconfig=" + usernameconfig + "]";
	}
	
	
	
}
