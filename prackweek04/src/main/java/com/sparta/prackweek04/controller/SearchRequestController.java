package com.sparta.prackweek04.controller;

import com.sparta.prackweek04.models.ItemDto;
import com.sparta.prackweek04.utils.NaverShopSearch;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
public class SearchRequestController {

    private final NaverShopSearch naverShopSearch;

    @GetMapping("/api/search")
    public List<ItemDto> getItems(@RequestParam String query){  //  너무 중요 벌레 잡힘든 부분
        String result = naverShopSearch.search(query);          //  @RequestParam query파라미터를 받을때 꼭 사용해야 한다
        return naverShopSearch.fromJSONtoItems(result);         //  이거 하나땜에 몇시간 찾은거냐....
        // formJSONtoItems ->제이슨으로 넘어온 정보를 바꿔준다.
    }
}
