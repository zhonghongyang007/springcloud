package com.zhy.provider.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * Description: eureka-provider
 * </p>
 * 
 * @author Zhonghy
 * @date 20191129
 * @version 1.0
 */
@RestController
public class Hello {

	private final Logger logger = LoggerFactory.getLogger(Hello.class);
	
	@Autowired
    private Registration registration; // 服务注册

	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public String hello() {
		ServiceInstance instance = serviceInstance();
		logger.info("/hello,host:" + instance.getHost() + ",service_id:" + instance.getServiceId());
		return "hello";
	}

	public ServiceInstance serviceInstance() {
		List<ServiceInstance> list = client.getInstances(registration.getServiceId());
		if (list != null && list.size() > 0) {
			for (ServiceInstance itm : list) {
				if (itm.getPort() == 8080)
					return itm;
			}
		}
		return null;
	}

}
