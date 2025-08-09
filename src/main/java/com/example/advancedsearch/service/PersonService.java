package com.example.advancedsearch.service;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import com.example.advancedsearch.specification.PersonSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository personRepository;

    public Page<Person> findAllWithCustomFilter(PersonFilter filter) {
        return this.personRepository.findAllByFilter(filter);
    }

    public Page<Person> findAllWithSpecification(PersonFilter filter) {
        return this.personRepository.findAll(PersonSpecification.filterBy(filter), filter.toPageable());
    }

}
