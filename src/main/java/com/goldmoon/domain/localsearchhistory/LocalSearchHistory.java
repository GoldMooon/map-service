package com.goldmoon.domain.localsearchhistory;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.goldmoon.domain.common.ZonedDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Entity
@Table(name = "local_search_histories")
@EntityListeners(value = { AuditingEntityListener.class})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocalSearchHistory {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "keyword")
	private String keyword;

	@Column(name = "user_id")
	private Long userId;

	@Column(name = "count")
	private Long count;

	@Column(name = "created_at", updatable = false)
	@CreationTimestamp
	@Convert(converter = ZonedDateTimeAttributeConverter.class)
	private ZonedDateTime createdAt;

	@Column(name = "updated_at")
	@UpdateTimestamp
	@Convert(converter = ZonedDateTimeAttributeConverter.class)
	private ZonedDateTime updatedAt;

}
