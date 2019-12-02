package com.zhy.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudEurekaProApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudEurekaProApplication.class, args);
	}

}
