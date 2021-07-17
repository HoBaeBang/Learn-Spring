package com.sparta.week04.models;

import lombok.Getter;
import org.json.JSONObject;

//검색결과
@Getter
public class ItemDto {
    private String link;
    private String title;
    private String image;
    private int lprice;

    public ItemDto(JSONObject jsonObject){
        this.title = jsonObject.getString("title");
        this.link = jsonObject.getString("link");
        this.image = jsonObject.getString("image");
        this.lprice = jsonObject.getInt("lprice");
    }
}

