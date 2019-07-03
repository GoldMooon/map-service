package com.goldmoon.api.localsearch.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.goldmoon.api.localsearch.model.PopLocalSearchKeywordResponse;
import com.goldmoon.api.localsearch.service.LocalSearchHistoryService;
import com.goldmoon.domain.localsearchhistory.LocalSearchHistory;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LocalSearchHistoryServiceTest {

	@Autowired
	private LocalSearchHistoryService localSearchHistoryService;

	@Test
	public void testGetPopKeywordsByUserIdLimit() {
		List<PopLocalSearchKeywordResponse> popLocalSearchKeywordResponses = localSearchHistoryService.getPopKeywordsByUserIdLimit(2L, 10);
		log.info("popLocalSearchKeywordResponses.size {}", popLocalSearchKeywordResponses.size());
	}

	@Ignore
	public void testCreate() {

		String keyword = "test_test";
		Long userId = 2L;

		LocalSearchHistory localSearchHistory = localSearchHistoryService.create(keyword, userId);
		log.info("localSearchHistories.count {}", localSearchHistory.getCount());
	}

}
