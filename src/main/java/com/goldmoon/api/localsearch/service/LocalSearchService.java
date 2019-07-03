package com.goldmoon.api.localsearch.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldmoon.api.client.KakaoLocalClient;
import com.goldmoon.api.client.model.SearchByKeywordResponse;
import com.goldmoon.api.localsearch.model.LocalSearchResponse;

@Slf4j
@Service
public class LocalSearchService {

	private Integer RADIUS = 20000;

	@Autowired
	private KakaoLocalClient kakaoLocalClient;

	@Autowired
	private LocalSearchHistoryService localSearchHistoryService;

	public LocalSearchResponse searchByKeyword(Long userId, Double y, Double x, String keyword, Integer page, Integer size) {

		SearchByKeywordResponse searchByKeywordResponse = kakaoLocalClient.searchByKeyword(y, x, RADIUS, keyword, page, size);
		localSearchHistoryService.create(keyword, userId);

		return LocalSearchResponse.of(page, size, searchByKeywordResponse);

	}

}
