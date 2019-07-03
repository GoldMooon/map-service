package com.goldmoon.api.client;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.goldmoon.api.client.KakaoLocalClient;
import com.goldmoon.api.client.model.SearchByKeywordResponse;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class KakaoLocalClientTest {

	@Autowired
	private KakaoLocalClient kakaoLocalClient;

	@Test
	public void searchByKeyword() {
		Double y = 37.514322572335935;
		Double x = 127.06283102249932;
		Integer radius = 20000;

		String keyword = "시청";

		SearchByKeywordResponse searchByKeywordResponse = kakaoLocalClient.searchByKeyword(y, x, radius, keyword, 2, 15);
		log.info("size {} ", searchByKeywordResponse.getDocuments().size());
	}
}
