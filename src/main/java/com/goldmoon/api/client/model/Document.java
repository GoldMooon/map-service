package com.goldmoon.api.client.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Document {

	private String placeName;
	private String distance;
	private String placeUrl;
	private String categoryName;
	private String addressName;
	private String roadAddressName;
	private String id;
	private String categoryGroupCode;
	private String categoryGroupName;
	private Double x;
	private Double y;

	/**
	 "": "카카오프렌즈 코엑스점",
	 "distance": "418",
	 "place_url": "http://place.map.kakao.com/26338954",
	 "category_name": "가정,생활 > 문구,사무용품 > 디자인문구 > 카카오프렌즈",
	 "address_name": "서울 강남구 삼성동 159",
	 "road_address_name": "서울 강남구 영동대로 513",
	 "id": "26338954",
	 "phone": "02-6002-1880",
	 "category_group_code": "",
	 "category_group_name": "",
	 "x": "127.05902969025047",
	 "y": "37.51207412593136"
	 */
}
