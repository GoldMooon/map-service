package com.goldmoon.domain.user;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.goldmoon.domain.common.Cipher;
import com.goldmoon.domain.common.ZonedDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "users")
@EntityListeners(value = { AuditingEntityListener.class})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "service_id")
	private String serviceId;

	@Column(name = "encrypted_password")
	private String encryptedPassword;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	@Convert(converter = ZonedDateTimeAttributeConverter.class)
	private ZonedDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@Convert(converter = ZonedDateTimeAttributeConverter.class)
	private ZonedDateTime updatedAt;

	public void setPassword(String lat) {
		this.encryptedPassword = Cipher.encrypt(lat);
	}

	public String getPassword() {
		return Cipher.decrypt(encryptedPassword);
	}

	public static class UserBuilder {
		public UserBuilder password(String password) {
			this.encryptedPassword = Cipher.encrypt(password);
			return this;
		}
	}

}
