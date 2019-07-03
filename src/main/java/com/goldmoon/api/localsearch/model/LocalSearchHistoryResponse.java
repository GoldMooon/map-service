package com.goldmoon.api.localsearch.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalSearchHistoryResponse {

	private Long id;
	private Long userId;
	private String keyword;
	private String updatedAt;

}
