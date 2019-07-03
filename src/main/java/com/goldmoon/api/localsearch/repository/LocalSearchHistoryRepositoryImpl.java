package com.goldmoon.api.localsearch.repository;

import com.goldmoon.api.localsearch.model.LocalSearchHistoryResponse;
import com.goldmoon.api.localsearch.model.PopLocalSearchKeywordResponse;
import com.goldmoon.domain.localsearchhistory.LocalSearchHistory;
import com.goldmoon.domain.localsearchhistory.QLocalSearchHistory;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

public class LocalSearchHistoryRepositoryImpl implements LocalSearchHistoryRepositoryCustom {

	QLocalSearchHistory localSearchHistory = QLocalSearchHistory.localSearchHistory;

	@Autowired
	@Qualifier("masterJpaQueryFactory")
	private JPAQueryFactory jpaQueryFactory;

	@Override
	public List<LocalSearchHistory> findAllByUserIdLimit(Long userId, Integer limit) {
		JPAQuery<LocalSearchHistory> query = jpaQueryFactory.query()
			.select(localSearchHistory)
			.from(localSearchHistory)
			.orderBy(localSearchHistory.updatedAt.desc())
			.limit(limit);
		return query.fetch();
	}

	@Override
	public List<PopLocalSearchKeywordResponse> findPopKeywordsByUserIdLimit(Long userId, Integer limit) {
		JPAQuery<PopLocalSearchKeywordResponse> query = jpaQueryFactory.query()
			.select(Projections.constructor(PopLocalSearchKeywordResponse.class,
				localSearchHistory.keyword,
				localSearchHistory.count.sum()))
			.from(localSearchHistory)
			.groupBy(localSearchHistory.keyword)
			.orderBy(localSearchHistory.count.sum().desc())
			.limit(limit);
		return query.fetch();
	}
}
