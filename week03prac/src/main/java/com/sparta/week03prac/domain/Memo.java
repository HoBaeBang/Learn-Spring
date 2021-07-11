package com.sparta.week03prac.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Memo extends Timestamped{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //자동으로 아이디를 증가시킨다.
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String contents;

    public Memo(String userName,String contents){
        this.userName = userName;
        this.contents = contents;
    }

    public Memo(MemoRequestDto requestDto){
        this.userName = requestDto.getUserName();
        this.contents = requestDto.getContents();
    }

    public void update(MemoRequestDto requestDto){
        this.userName = requestDto.getUserName();
        this.contents = requestDto.getContents();
    }

}
