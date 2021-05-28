package com.homework01.homework01.personController;


import com.homework01.homework01.domain.Person;
import com.homework01.homework01.domain.PersonRepository;
import com.homework01.homework01.domain.PersonRequestDto;
import com.homework01.homework01.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class PersonController {

    private final PersonRepository personRepository;
    private final PersonService personService;

    @GetMapping("/api/persons")
    public List<Person> getPerson(){
        return personRepository.findAll();
    }

    @PostMapping("/api/persons")
    public Person createPerson(@RequestBody PersonRequestDto requestDto){
        Person person = new Person(requestDto);
        return personRepository.save(person);
    }

    @PutMapping("/api/persons/{id}")
    public Long updatePerson(@PathVariable Long id, @RequestBody PersonRequestDto requestDto){
        return personService.update(id,requestDto);
    }

    @DeleteMapping("/api/persons/{id}")
    public Long deletePerson (@PathVariable Long id){
        personRepository.deleteById(id);
        return id;
    }

}
