package com.goldmoon.api.localsearch.model;

import lombok.*;

import java.util.List;

import com.goldmoon.api.client.model.Document;
import com.goldmoon.api.client.model.SearchByKeywordResponse;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocalSearchResponse {

	private Integer page;
	private Integer totalPage;
	private List<Document> documents;

	public static LocalSearchResponse of(Integer page, Integer size, SearchByKeywordResponse searchByKeywordResponse) {
		return LocalSearchResponse.builder()
			.page(page)
			.totalPage(searchByKeywordResponse.getMeta().getIsEnd() ? page : searchByKeywordResponse.getMeta().getPageableCount() / size)
			.documents(searchByKeywordResponse.getDocuments())
			.build();
	}
}
