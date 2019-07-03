package com.goldmoon.api.localsearch.repository;

import java.util.List;

import com.goldmoon.api.localsearch.model.PopLocalSearchKeywordResponse;
import com.goldmoon.domain.localsearchhistory.LocalSearchHistory;

public interface LocalSearchHistoryRepositoryCustom {

	List<LocalSearchHistory> findAllByUserIdLimit(Long userId, Integer limit);

	List<PopLocalSearchKeywordResponse> findPopKeywordsByUserIdLimit(Long userId, Integer limit);

}
