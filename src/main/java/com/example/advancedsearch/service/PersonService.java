package com.example.advancedsearch.service;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import com.example.advancedsearch.specification.PersonSpecification;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

@Service
@AllArgsConstructor
public class PersonService {

    private PersonRepository personRepository;
    private PersonSpecification personSpecification;

    public Page<Person> findAll(PersonFilter filter) {
        filter.setSortBy(ObjectUtils.isEmpty(filter.getSort()) ? "name" : filter.getSortBy());
        Pageable pageable = PageRequest.of(filter.getPageNumber(), filter.getPageSize(), filter.getSort());
        return this.personRepository.findAll(this.personSpecification.persons(filter), pageable);
    }

}
