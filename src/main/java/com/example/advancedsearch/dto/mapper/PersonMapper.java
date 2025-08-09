package com.example.advancedsearch.dto.mapper;

import com.example.advancedsearch.dto.request.PersonRequest;
import com.example.advancedsearch.dto.response.PersonResponse;
import com.example.advancedsearch.model.Person;
import org.springframework.data.domain.Page;

public class PersonMapper {

    public static Person toPerson(PersonRequest dto) {
        var person = new Person();

        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setMaritalStatus(dto.getMaritalStatus());
        person.setBirthday(dto.getBirthday());
        person.setDistrict(dto.getDistrict());
        person.setCity(dto.getCity());
        person.setState(dto.getState());

        return person;
    }

    public static PersonResponse toPersonResponse(Person person) {
        var response = new PersonResponse();

        response.setId(person.getId());
        response.setName(person.getName());
        response.setEmail(person.getEmail());
        response.setMaritalStatus(person.getMaritalStatus());
        response.setBirthday(person.getBirthday());
        response.setDistrict(person.getDistrict());
        response.setCity(person.getCity());
        response.setState(person.getState());

        return response;
    }

    public static Page<PersonResponse> toPersonResponsePage(Page<Person> pagedPersons) {
        return pagedPersons.map(PersonMapper::toPersonResponse);
    }

}
