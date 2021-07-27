package com.example.advancedsearch.dto.mapper;

import com.example.advancedsearch.dto.request.PersonRequest;
import com.example.advancedsearch.model.Person;

public class PersonMapper {

    public static Person fromDTO(PersonRequest dto) {
        Person person = new Person();
        person.setName(dto.getName());
        person.setEmail(dto.getEmail());
        person.setMaritalStatus(dto.getMaritalStatus());
        person.setBirthday(dto.getBirthday());
        person.setDistrict(dto.getDistrict());
        person.setCity(dto.getCity());
        person.setState(dto.getState());

        return person;
    }

}
