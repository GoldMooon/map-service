package com.goldmoon.api.localsearch.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldmoon.api.localsearch.model.LocalSearchHistoryResponse;
import com.goldmoon.api.localsearch.model.PopLocalSearchKeywordResponse;
import com.goldmoon.api.localsearch.repository.LocalSearchHistoryRepository;
import com.goldmoon.domain.localsearchhistory.LocalSearchHistory;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoField.*;
import static java.time.temporal.ChronoField.MILLI_OF_SECOND;

@Slf4j
@Service
public class LocalSearchHistoryService {

	@Autowired
	private LocalSearchHistoryRepository localSearchHistoryRepository;

	public LocalSearchHistory create(String keyword, Long userId) {

		LocalSearchHistory localSearchHistory = localSearchHistoryRepository.findByKeywordAndUserId(keyword, userId).orElse(LocalSearchHistory.builder()
			.keyword(keyword)
			.userId(userId)
			.count(0L)
			.build());

		localSearchHistory.setCount(localSearchHistory.getCount() + 1);

		return localSearchHistoryRepository.save(localSearchHistory);

	}

	public List<LocalSearchHistoryResponse> getAllByUserIdLimit(Long userId, Integer limit) {
		List<LocalSearchHistory> localSearchHistories = localSearchHistoryRepository.findAllByUserIdLimit(userId, limit);
		return localSearchHistories.stream()
			.map(localSearchHistory -> LocalSearchHistoryResponse.builder()
				.id(localSearchHistory.getId())
				.userId(localSearchHistory.getUserId())
				.keyword(localSearchHistory.getKeyword())
				.updatedAt(localSearchHistory.getUpdatedAt().format(new DateTimeFormatterBuilder()
					.append(DateTimeFormatter.ISO_LOCAL_DATE)
					.appendLiteral(' ')
					.appendValue(HOUR_OF_DAY, 2)
					.appendLiteral(':')
					.appendValue(MINUTE_OF_HOUR, 2)
					.optionalStart()
					.appendLiteral(':')
					.appendValue(SECOND_OF_MINUTE, 2)
					.appendFraction(MILLI_OF_SECOND, 3, 3, true)
					//                .appendOffsetId()
					.toFormatter()))
				.build())
			.collect(Collectors.toList());
	}

	public List<PopLocalSearchKeywordResponse> getPopKeywordsByUserIdLimit(Long userId, Integer limit) {
		return localSearchHistoryRepository.findPopKeywordsByUserIdLimit(userId, limit);
	}

}
