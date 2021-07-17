package com.sparta.week04.models;

import lombok.Getter;

//관심 상품 등록하기
@Getter
public class ProductRequestDto {
    private String title;   //제목
    private String link;    //링크
    private String image;   //이미지
    private int lprice;     //최저가
}
