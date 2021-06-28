package com.sparta.prackweek04.utils;

import com.sparta.prackweek04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component  //컴포넌트 등록하기 스프링이 요쇼를 그때그때 핑요로 하는데 그때 필요한 권한을 주기이해서 넣어줘야한다.
//쉽게 말해서 너 필요할때 쓰라고 권한을 주는 것이다.
public class NaverShopSearch {

    public String search(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", "Rf4nbzxhQk3gpctt2aGE");
        headers.add("X-Naver-Client-Secret", "tDSQjR6Koc");
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query=" + query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        String response = responseEntity.getBody();
        System.out.println("Response status: " + status);
        System.out.println(response);

        return response;
    }

    public List<ItemDto> fromJSONtoItems(String result) {

        JSONObject rjson = new JSONObject(result);          //resylt값(문자열)을 받아서 JSONObject로 변환해줌
        JSONArray items = rjson.getJSONArray("items");  //JSONObject에서 items 배열 꺼내기
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i = 0; i < items.length(); i++) {                 //반복문을 돌면서 아이템 값을 Dto에게 전달
            JSONObject itemJSON = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJSON);
            itemDtoList.add(itemDto);
        }
        return itemDtoList;
    }


}