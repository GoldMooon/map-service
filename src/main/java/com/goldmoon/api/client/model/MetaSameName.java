package com.goldmoon.api.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaSameName {

	private List<String> region;
	private String keyword;
	private String selectedRegion;

	/**
	 "region": [],
	 "keyword": "카카오프렌즈",
	 "selected_region": ""
	 */
}
