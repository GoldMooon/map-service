package com.goldmoon.api.localsearch.model;

import lombok.*;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PopLocalSearchKeywordResponse {

	private String keyword;
	private Long sumCount;

}
