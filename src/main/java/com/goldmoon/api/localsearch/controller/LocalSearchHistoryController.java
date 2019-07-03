package com.goldmoon.api.localsearch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.goldmoon.api.localsearch.model.LocalSearchHistoryResponse;
import com.goldmoon.api.localsearch.model.PopLocalSearchKeywordResponse;
import com.goldmoon.api.localsearch.service.LocalSearchHistoryService;
import com.goldmoon.api.localsearch.service.LocalSearchService;

import java.util.List;

@RestController
@RequestMapping("/api/local/search/histories")
public class LocalSearchHistoryController {

	@Autowired
	private LocalSearchService localSearchService;

	@Autowired
	private LocalSearchHistoryService localSearchHistoryService;

	@GetMapping
	public List<LocalSearchHistoryResponse> getAllByUserIdLimit(
		@RequestParam("user_id") Long userId,
		@RequestParam("limit") Integer limit) {
		return localSearchHistoryService.getAllByUserIdLimit(userId, limit);
	}

	@GetMapping("/pop/keyword")
	public List<PopLocalSearchKeywordResponse> getPopKeywordsByUserIdLimit(
		@RequestParam("user_id") Long userId,
		@RequestParam("limit") Integer limit) {
		return localSearchHistoryService.getPopKeywordsByUserIdLimit(userId, limit);
	}

}
