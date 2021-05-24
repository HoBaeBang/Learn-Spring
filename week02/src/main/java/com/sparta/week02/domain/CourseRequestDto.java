package com.sparta.week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor

public class CourseRequestDto { //DTO코스 여청 관련 정보를 물고 다닐 녀석이라는 뜻입니다.
    private final String title; //Course와같이 변수가 2가지가 필요하다.
    private final String tutor;

}
