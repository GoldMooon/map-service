package com.goldmoon.api.localsearch.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldmoon.domain.localsearchhistory.LocalSearchHistory;

import java.util.Optional;

@Repository
public interface LocalSearchHistoryRepository extends JpaRepository<LocalSearchHistory, Long>, LocalSearchHistoryRepositoryCustom {

	Optional<LocalSearchHistory> findByKeywordAndUserId(String keyword, Long userId);

}
