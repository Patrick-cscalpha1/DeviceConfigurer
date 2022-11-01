
package com.cscalpha.manager.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cscalpha.manager.entity.Device;
import com.cscalpha.manager.entity.DeviceandData;
import com.cscalpha.manager.entity.UserDeviceConfig;
import com.cscalpha.manager.entity.Userdevice;
import com.cscalpha.manager.repository.DeviceRepository;
import com.cscalpha.manager.repository.DeviceandDataRepository;
import com.cscalpha.manager.repository.IuserconfigurationRepository;
import com.cscalpha.manager.repository.UserDeviceRepository;

@Service
@Transactional
public class DeviceServiceImpl implements IdeviceService {

	
	//inject user device repository
	@Autowired
	private UserDeviceRepository userdevicerepository;
	
	//inject device repository
	@Autowired
	private DeviceRepository  devicerepository;
	
	//inject userconfiguration repository
	@Autowired
	private IuserconfigurationRepository userconfigurationrepository;
	
	//inject deviceanddata repository
	@Autowired
	private DeviceandDataRepository deviceanddatarepository;
	
	@Override
	public void saveUserDevice(Userdevice theUserdevice) {
		
		userdevicerepository.save(theUserdevice);
	}
	
	@Override
	public Userdevice CheckUserDevicePresence(String username,String devicename) {
		
		return userdevicerepository.findByUseridAndUserdeviceid(username,devicename);
	}

	@Override
	public List<Device> findDevices() {
		
		return devicerepository.findAllByOrderByDeviceNameAsc();
	}

	@Override
	public List<Userdevice> findUserDevices(String username) {
		
		return userdevicerepository.findByUserid(username);
	}

	@Override
	public void deleteUserDevcie(int theId) {
		
		userdevicerepository.deleteById(theId);
	}

	@Override
	public List<UserDeviceConfig> findPermittedDevices(String username, String sourcedevice) {
		
		return userconfigurationrepository.findByUsernameconfigAndSourceDevice(username, sourcedevice);
	}

	@Override
	public void removeDeviceAccess(int theId) {
		
		userconfigurationrepository.deleteById(theId);
	}

	@Override
	public List<DeviceandData> findDevicesandData(String devicename) {
		
		return deviceanddatarepository.findByDeviceid(devicename);
	}

	@Override
	public UserDeviceConfig CheckUserDeviceConfigPresence(String username, String sourcedevicename, String targetdevicename,
			String sourcedataname) {
		
		return userconfigurationrepository.findByUsernameconfigAndSourceDeviceAndTargetDeviceAndSourceData(username, sourcedevicename, targetdevicename, sourcedataname);
	}

	@Override
	public void saveUserConfiguration(UserDeviceConfig userconfiguration) {
		
		userconfigurationrepository.save(userconfiguration);
	}

	@Override
	public UserDeviceConfig getSourcedevice(int theId) {
		
		return userconfigurationrepository.getById(theId);
	}

	
	
}
