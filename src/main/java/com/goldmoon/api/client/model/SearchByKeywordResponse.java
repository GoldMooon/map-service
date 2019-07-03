package com.goldmoon.api.client.model;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SearchByKeywordResponse {

	private Meta meta;
	private List<Document> documents;

}
