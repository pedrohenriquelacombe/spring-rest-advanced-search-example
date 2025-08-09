package com.example.advancedsearch.dto.response;

import com.example.advancedsearch.enums.MaritalStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class PersonResponse {

    private String id;
    private String name;
    private String email;
    private MaritalStatus maritalStatus;
    private String district;
    private String city;
    private String state;
    private LocalDate birthday;

}
