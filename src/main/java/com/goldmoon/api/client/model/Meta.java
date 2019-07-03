package com.goldmoon.api.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Meta {

	private MetaSameName sameName;
	private Integer pageableCount;
	private Integer totalCount;
	private Boolean isEnd;

	/**
	 "same_name": {
	 "region": [],
	 "keyword": "카카오프렌즈",
	 "selected_region": ""
	 },
	 "pageable_count": 14,
	 "total_count": 14,
	 "is_end": true
	 */
}
