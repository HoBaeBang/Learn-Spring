package com.sparta.week01.prac;

import java.util.ArrayList;
import java.util.List;

public class Prac {
    public static void subtract (int num1,int num2){
        int sub = num1 -num2;
        System.out.println(sub);
    }
    public static void main(String[] args){
        String name = "방호배";
        int myAge = 24;
        boolean isAdult= myAge >=20;
        List<String> myList = new ArrayList<>();            //List사용법

        System.out.println("안녕, 스파르타!");
        System.out.println("나의 이름은 " +name+" 입니다.");
        System.out.println(isAdult);
        
        String course1 = "웹개발의 봄 Spring";               //List사용법
        String course2 = "프론트엔드의 꽃 React";
        myList.add(course1);
        myList.add(course2);
        System.out.println(myList);
        System.out.println(myList.get(0));
        myList.remove(1);
        System.out.println(myList);

        List<String> courseList = new ArrayList<>();
        String course4 = "웹개발 종합반";
        String course5 = "앱개발 종합반";
        courseList.add(course4);
        courseList.add(course5);
        System.out.println(courseList);
        subtract(5,1);
    }
}
