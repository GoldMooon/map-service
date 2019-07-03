package com.goldmoon.api.localsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goldmoon.api.client.model.SearchByKeywordResponse;
import com.goldmoon.api.localsearch.model.LocalSearchHistoryResponse;
import com.goldmoon.api.localsearch.model.LocalSearchResponse;
import com.goldmoon.api.localsearch.model.PopLocalSearchKeywordResponse;
import com.goldmoon.api.localsearch.service.LocalSearchHistoryService;
import com.goldmoon.api.localsearch.service.LocalSearchService;

import java.util.List;

@RestController
@RequestMapping("/local/search")
public class LocalSearchController {

	@Autowired
	private LocalSearchService localSearchService;

	@Autowired
	private LocalSearchHistoryService localSearchHistoryService;

	@GetMapping
	public LocalSearchResponse searchByKeyword(
		@RequestParam("user_id") Long userId,
		@RequestParam("y") Double y,
		@RequestParam("x") Double x,
		@RequestParam("keyword") String keyword,
		@RequestParam("page") Integer page,
		@RequestParam("size") Integer size) {
		return localSearchService.searchByKeyword(userId, y, x, keyword, page, size);
	}

}
