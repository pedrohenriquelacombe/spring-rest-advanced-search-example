package com.example.advancedsearch.repository;

import com.example.advancedsearch.dto.PersonFilter;
import com.example.advancedsearch.model.Person;
import org.springframework.data.domain.Page;

public interface PersonRepositoryCustom {

    Page<Person> findAllByFilter(PersonFilter filter);

}
