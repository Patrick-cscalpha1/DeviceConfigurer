package com.cscalpha.manager.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cscalpha.manager.entity.UserDeviceConfig;
import com.cscalpha.manager.entity.Userdevice;
import com.cscalpha.manager.service.IdeviceService;


@Controller
public class DeviceController {

//currently logged username=SecurityContextHolder.getContext().getAuthentication().getName()
	
	//inject userdevice singleton
	@Autowired
	private Userdevice userdevice;
	

	//inject userdeviceconfig singleton
	@Autowired
	private UserDeviceConfig userdeviceconfig;
	
	//inject device service
	@Autowired
	private IdeviceService deviceservice;
	
	//add devices to user
	@GetMapping("/deviceconfigurer/adddevices")
	public String addDevices(Model theModel) {
	
		//setusername for storage of his devices 
		 Userdevice u = new Userdevice();
		u.setUserid(SecurityContextHolder.getContext().getAuthentication().getName());
		theModel.addAttribute("userdevice", u);
		theModel.addAttribute("devices", deviceservice.findDevices());
        return "adddevices";
			}
	
	//get list of devices by username and give various option to cancel or configure it
		@GetMapping("/deviceconfigurer/mydevices")
		public String myDevices(Model theModel) {
			
			theModel.addAttribute("myuserdevices", deviceservice.findUserDevices(SecurityContextHolder.getContext().getAuthentication().getName()));
	        return "mydevices";
				}

	
	
	@PostMapping("/deviceconfigurer/saveuserdevice")
	public String saveEmployee(@ModelAttribute("userdevice") Userdevice theuserdevice,HttpSession session, Model themodel) {
		
		   userdevice = deviceservice.CheckUserDevicePresence(theuserdevice.getUserid(), theuserdevice.getUserdeviceid());
		   if(userdevice != null) {
			   session.setAttribute("message", "Device already added as list of your devices");
			   return "redirect:/deviceconfigurer/adddevices";
		   }
		   
		 //save user device
		    deviceservice.saveUserDevice(theuserdevice);
		    session.setAttribute("message", "Device Saved Succefully");
			return "redirect:/deviceconfigurer/adddevices";
		
		}
		
		
	

	//delete device
	@GetMapping("/deviceconfigurer/deletedevice")
	public String deleteUserDevice(@RequestParam(required=false,name="deleteID") int deleteid) {
	
		deviceservice.deleteUserDevcie(deleteid);
		return "redirect:/deviceconfigurer/mydevices";
	}
		
	//get devices that have access and display configuration page
	@GetMapping("/deviceconfigurer/configurationlist/{sourcedevice}")
	public String getPermitedDevices(@PathVariable("sourcedevice") String devicenameid,Model theModel) {
		
		//pass device name to template for database operations
		theModel.addAttribute("devicename",devicenameid);
		theModel.addAttribute("myuserconfigdevices", deviceservice.findPermittedDevices(SecurityContextHolder.getContext().getAuthentication().getName(), devicenameid));
		return "configuredevice";
	}
	
	//delete device access
	@GetMapping("/deviceconfigurer/removeaccess/{deleteId}")
	public String removeDeviceAccess(@PathVariable("deleteId") int deleteid) {
	
		//get source device to pass to /configurationlist/{sourcedevice} endpoint
		UserDeviceConfig uc = deviceservice.getSourcedevice(deleteid);
		
		//remove device access
	    deviceservice.removeDeviceAccess(deleteid);
		return "redirect:/deviceconfigurer/configurationlist/" + uc.getSourceDevice();
	}
	
	//get devices that have access and display configuration page
		@GetMapping("/deviceconfigurer/grantpermission/{sourcedevice}")
		public String grantPermitedDevices(@PathVariable("sourcedevice") String devicenameid,Model theModel) {
			
			UserDeviceConfig uc = new UserDeviceConfig();
			//get source device name and username which are hidden fields
			uc.setSourceDevice(devicenameid);
			uc.setUsernameconfig(SecurityContextHolder.getContext().getAuthentication().getName());
			theModel.addAttribute("userdeviceconfig",uc);
			//list of devices(can be modified to target only specific user devices to give permission to
			theModel.addAttribute("devicelist", deviceservice.findDevices());
			//list of data the can be accessed base on source device i'll make user of deviceanddata table and repository
			theModel.addAttribute("datalist", deviceservice.findDevicesandData(devicenameid));
			//pass device name to call /configuration list for go back option
			theModel.addAttribute("devicename", devicenameid);
			return "configuration";
		}
		
		
		
		@PostMapping("/deviceconfigurer/saveconfiguration")
		public String saveConfiguration(@ModelAttribute("userdeviceconfig") UserDeviceConfig theuserdeviceconfig,HttpSession session, Model theModel) {
			
			userdeviceconfig = deviceservice.CheckUserDeviceConfigPresence(theuserdeviceconfig.getUsernameconfig(),theuserdeviceconfig.getSourceDevice(),theuserdeviceconfig.getTargetDevice(),theuserdeviceconfig.getSourceData());
			   if(userdeviceconfig != null) {
				   session.setAttribute("message", "This device already have access");
				  
				  
				   return "redirect:/deviceconfigurer/grantpermission/" + theuserdeviceconfig.getSourceDevice();
			   }
			   
			
			    deviceservice.saveUserConfiguration(theuserdeviceconfig);
			    session.setAttribute("message", "Device Was Succefully Granted Access");
			      return "redirect:/deviceconfigurer/grantpermission/" + theuserdeviceconfig.getSourceDevice();
			
			}
			
	
}
	

