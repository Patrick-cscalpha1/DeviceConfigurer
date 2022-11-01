package com.cscalpha.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cscalpha.manager.entity.Userdevice;

@Repository
public interface UserDeviceRepository extends JpaRepository<Userdevice, Integer> {

	//check for user already existing device
	Userdevice findByUseridAndUserdeviceid(String username,String devicename);
	
	//get user devices
	List<Userdevice> findByUserid(String username);
}
