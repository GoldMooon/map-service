package com.goldmoon.api.user.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.goldmoon.api.user.repository.UserRepository;
import com.goldmoon.common.exception.ApiException;
import com.goldmoon.common.exception.ErrorMessage;
import com.goldmoon.domain.user.User;

import java.util.Optional;

@Slf4j
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public User getById(Long id) {
		return userRepository.findById(id).orElseGet(() -> User.builder().build());
	}

	public User create(String serviceId, String password) {

		Optional<User> optionalUser  = userRepository.findByServiceId(serviceId);
		if (optionalUser.isPresent()) {
			throw new ApiException(HttpStatus.BAD_REQUEST, ErrorMessage.ALREADY_EXIST_USER);
		}

		return userRepository.save(
			User.builder()
				.serviceId(serviceId)
				.password(password)
				.build()
		);
	}

	public User getByServiceIdAndPassword(String serviceId, String password) {

		User user = User.builder()
			.serviceId(serviceId)
			.password(password)
			.build();

		Optional<User> optionalUser = userRepository.findByServiceIdAndEncryptedPassword(user.getServiceId(), user.getEncryptedPassword());
		if (!optionalUser.isPresent()) {
			throw new ApiException(HttpStatus.NOT_FOUND, ErrorMessage.NOT_FOUND_EXIST_USER);
		}

		return optionalUser.get();
	}

}
