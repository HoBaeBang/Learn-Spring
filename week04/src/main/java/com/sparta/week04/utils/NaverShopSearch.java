package com.sparta.week04.utils;

import com.sparta.week04.models.ItemDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class NaverShopSearch {
    public String search(String query) {
        RestTemplate rest = new RestTemplate();     //스프링에서 기본적으로 RestTmeplate을 이용한다.
        HttpHeaders headers = new HttpHeaders();    //헤더를 알맞게 넣어준다.
        headers.add("X-Naver-Client-Id", "Rf4nbzxhQk3gpctt2aGE");   //APi를 이용하기 위함
        headers.add("X-Naver-Client-Secret", "tDSQjR6Koc");
        String body = "";       //바디를 만들어 놓고

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers); //requestEntity에 body를 같이 넣어준다. 그러면 body안에 응답받은 결과물이 들어간다.
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?query="+query, HttpMethod.GET, requestEntity, String.class);
        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value(); //ex) 200 상태를 나타냄
        String response = responseEntity.getBody();       //우리가 보낸결과가 getBody를 통해서 문자열 하나로 쭉 돼서 response안에 들어가있을것이다.
        System.out.println("Response status: " + status); //Response status: 200출력
        System.out.println(response);

        return response;    //결과갑은 response안에 들어있기 때문에 넣준다.
    }

    public List<ItemDto> formJSONtoItems(String result){
        JSONObject rjson = new JSONObject(result);         //문자열 정보를 JSON으로 바꾸기
        JSONArray items = rjson.getJSONArray("items");      //JSONObject에서 items배열 꺼내기
        List<ItemDto> itemList = new ArrayList<>();
        for(int i =0; i<items.length();i++){
            JSONObject itemJson = (JSONObject)items.get(i);
            ItemDto itemDto = new ItemDto(itemJson);
            itemList.add(itemDto);
        }
        return itemList;
    }
}