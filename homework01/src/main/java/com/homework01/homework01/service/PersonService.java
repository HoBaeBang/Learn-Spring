package com.homework01.homework01.service;

import com.homework01.homework01.domain.Person;
import com.homework01.homework01.domain.PersonRepository;
import com.homework01.homework01.domain.PersonRequestDto;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class PersonService {
    private final PersonRepository personRepository;
    //repository 꼭 필요 SQL 작업이 일어날것이기 때문
    public PersonService(PersonRepository personRepository){
        this.personRepository = personRepository;
    }
    //생성자 레포지토리를 생성과 함께 넣어달라.

    @Transactional//
    public Long update(Long id, PersonRequestDto requestDto){
        Person person = personRepository.findById(id).orElseThrow(
                ()-> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );
        person.update(requestDto);
        return person.getId();
    }
}
