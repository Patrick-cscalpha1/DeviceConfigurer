package com.cscalpha.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cscalpha.manager.entity.UserDeviceConfig;
import com.cscalpha.manager.entity.Userdevice;

@SpringBootApplication
public class ManagerApplication {

    //userdevice singleton
	@Bean
	public Userdevice getUserdevice() {
		return new Userdevice();
		}
	
	  //userdevice  configuration singleton
		@Bean
		public UserDeviceConfig getUserDeviceConfig() {
			return new UserDeviceConfig();
			}
		
	public static void main(String[] args) {
		SpringApplication.run(ManagerApplication.class, args);
	}

}
