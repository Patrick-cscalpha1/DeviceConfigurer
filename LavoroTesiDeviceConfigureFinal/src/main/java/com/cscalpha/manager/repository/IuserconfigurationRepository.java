package com.cscalpha.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cscalpha.manager.entity.UserDeviceConfig;

public interface IuserconfigurationRepository extends JpaRepository<UserDeviceConfig, Integer> {

	//get  devices that have access to device name passed as argument
	List<UserDeviceConfig> findByUsernameconfigAndSourceDevice(String username, String sourcedevice);
	UserDeviceConfig findByUsernameconfigAndSourceDeviceAndTargetDeviceAndSourceData(String username, String sourcedevicename, String targetdevicename,
			String sourcedataname);
}
