package com.example.advancedsearch.resource;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.dto.mapper.PageMapper;
import com.example.advancedsearch.dto.mapper.PersonMapper;
import com.example.advancedsearch.dto.request.PersonRequest;
import com.example.advancedsearch.dto.response.PageResponse;
import com.example.advancedsearch.dto.response.PersonResponse;
import com.example.advancedsearch.repository.PersonRepository;
import com.example.advancedsearch.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/persons")
public class PersonResource {

    private final PersonService personService;
    private final PersonRepository personRepository;

    @GetMapping("/v1")
    public PageResponse<PersonResponse> findAllWithCustomFilter(PersonFilter filter) {
        var personResponsePage = PersonMapper.toPersonResponsePage(this.personService.findAllWithCustomFilter(filter));

        return PageMapper.toPageResponse(personResponsePage);
    }

    @GetMapping("/v2")
    public PageResponse<PersonResponse> findAllWithSpecification(PersonFilter filter) {
        var personResponsePage = PersonMapper.toPersonResponsePage(this.personService.findAllWithSpecification(filter));

        return PageMapper.toPageResponse(personResponsePage);
    }

    @PostMapping
    public PersonResponse create(@Valid @RequestBody PersonRequest request) {
        return PersonMapper.toPersonResponse(this.personRepository.save(PersonMapper.toPerson(request)));
    }

}
