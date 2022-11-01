package com.cscalpha.manager.service;

import java.util.List;
import com.cscalpha.manager.entity.Device;
import com.cscalpha.manager.entity.DeviceandData;
import com.cscalpha.manager.entity.UserDeviceConfig;
import com.cscalpha.manager.entity.Userdevice;

public interface IdeviceService {

	public void saveUserDevice(Userdevice theUserdevice);
	public Userdevice CheckUserDevicePresence(String username,String devicename);
	public List<Device> findDevices();
	public List<Userdevice> findUserDevices(String username);
	public void deleteUserDevcie(int theId);
	public List<UserDeviceConfig> findPermittedDevices(String username,String sourcedevice);
	public void removeDeviceAccess(int theId);
	public List<DeviceandData> findDevicesandData(String devicename);
	public UserDeviceConfig CheckUserDeviceConfigPresence(String username,String sourcedevicename,String targetdevicename,String sourcedataname);
    public void saveUserConfiguration(UserDeviceConfig userconfiguration);
    public UserDeviceConfig getSourcedevice(int theId);
}
