package com.goldmoon.api.user.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.goldmoon.api.user.service.UserService;
import com.goldmoon.domain.user.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserServiceTest {

	@Autowired
	private UserService userService;

	@Ignore
	public void testGetById() {
		Long id = 1L;
		User user = userService.getById(id);
		log.info("serviceId {}", user.getServiceId());
	}

	@Ignore
	public void testCreate() {
		String serviceId = "test";
		String password = "test";

		User user = userService.create(serviceId, password);
	}

	@Test
	public void testGetByServiceIdAndPassword() {
		String serviceId = "test";
		String password = "test";

		User user = userService.getByServiceIdAndPassword(serviceId, password);
		log.info("serviceId {}", user.getServiceId());
	}

}
