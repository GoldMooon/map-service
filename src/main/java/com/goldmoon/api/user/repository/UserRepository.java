package com.goldmoon.api.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldmoon.domain.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByServiceId(String serviceId);

	Optional<User> findByServiceIdAndEncryptedPassword(String serviceId, String encryptedPassword);

}
