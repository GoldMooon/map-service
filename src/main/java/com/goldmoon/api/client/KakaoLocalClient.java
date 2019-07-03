package com.goldmoon.api.client;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.goldmoon.api.client.model.SearchByKeywordResponse;
import com.goldmoon.common.resttemplate.RestTemplateFactory;

import java.net.URI;

@Slf4j
@Service
public class KakaoLocalClient {

	@Autowired
	private RestTemplateFactory restTemplateFactory;

//	@Value("${client.kakao.user.host}")
	private String host = "https://dapi.kakao.com";

	private String auth = "fcc29a8012ebe9a26baf507f4420332a";
	//private String auth = "62e954744fa362199b0d7b488c3418e3";

//	@Value("${client.kakao.user.signoutUrl}")
	private String localSearchKeyword = "/v2/local/search/keyword.json";

	private String AUTHRIZATION_HEADER_KEY = "Authorization";

	public SearchByKeywordResponse searchByKeyword(Double y, Double x, Integer radius, String keyword, Integer page, Integer size) {
		HttpHeaders requestHeaders = new HttpHeaders();
		requestHeaders.set(AUTHRIZATION_HEADER_KEY, "KakaoAK " + auth);
		HttpEntity requestEntity = new HttpEntity<>(requestHeaders);

		URI uri = UriComponentsBuilder.fromUriString(host + localSearchKeyword)
			.queryParam("y", y)
			.queryParam("x", x)
			.queryParam("radius", radius)
			.queryParam("query", keyword)
			.queryParam("page", page)
			.queryParam("size", size)
			.build().toUri();

		RestTemplate restTemplate = restTemplateFactory.get();
		try {
			ResponseEntity<SearchByKeywordResponse> response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, SearchByKeywordResponse.class);
			SearchByKeywordResponse searchByKeywordResponse = response.getBody();
			return response.getBody();
		} catch (Exception e) {
			log.error("error: {}", e.getMessage());
			return SearchByKeywordResponse.builder().build();
		}
	}
}

