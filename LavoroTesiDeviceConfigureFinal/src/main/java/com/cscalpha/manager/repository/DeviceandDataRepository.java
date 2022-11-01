package com.cscalpha.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cscalpha.manager.entity.DeviceandData;

public interface DeviceandDataRepository extends JpaRepository<DeviceandData, Integer> {

	//get measured device data 
	List<DeviceandData> findByDeviceid(String devicename);
}
