package com.example.advancedsearch.resource;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.dto.mapper.PageMapper;
import com.example.advancedsearch.dto.mapper.PersonMapper;
import com.example.advancedsearch.dto.request.PersonRequest;
import com.example.advancedsearch.dto.response.PageResponse;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import com.example.advancedsearch.service.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonResource {

    private PersonService personService;
    private PersonRepository personRepository;

    @GetMapping
    public PageResponse<Person> findAll(PersonFilter filter) {
        return PageMapper.toDTO(this.personService.findAll(filter));
    }

    @PostMapping
    public Person create(@Valid @RequestBody PersonRequest request) {
        return this.personRepository.save(PersonMapper.fromDTO(request));
    }

}
