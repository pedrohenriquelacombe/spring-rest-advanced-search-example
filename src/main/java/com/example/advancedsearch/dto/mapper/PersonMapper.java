package com.example.advancedsearch.dto.mapper;

import com.example.advancedsearch.dto.request.PersonRequest;
import com.example.advancedsearch.dto.response.PersonResponse;
import com.example.advancedsearch.model.Person;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class PersonMapper {

    public static Person toPerson(PersonRequest dto) {
        var person = new Person();

        person.setName(dto.name());
        person.setEmail(dto.email());
        person.setMaritalStatus(dto.maritalStatus());
        person.setBirthday(dto.birthday());
        person.setDistrict(dto.district());
        person.setCity(dto.city());
        person.setState(dto.state());

        return person;
    }

    public static PersonResponse toPersonResponse(Person person) {
        return new PersonResponse(
                person.getId(),
                person.getName(),
                person.getEmail(),
                person.getMaritalStatus(),
                person.getDistrict(),
                person.getCity(),
                person.getState(),
                person.getBirthday()
        );
    }

    public static Page<PersonResponse> toPersonResponsePage(Page<Person> pagedPersons) {
        return pagedPersons.map(PersonMapper::toPersonResponse);
    }

}
