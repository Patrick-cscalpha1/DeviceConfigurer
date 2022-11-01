package com.cscalpha.manager.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cscalpha.manager.entity.Device;

public interface DeviceRepository extends JpaRepository<Device, String> {

	//get ordered list of devices
	List<Device> findAllByOrderByDeviceNameAsc();
}
