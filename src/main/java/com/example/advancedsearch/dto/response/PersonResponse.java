package com.example.advancedsearch.dto.response;

import com.example.advancedsearch.enums.MaritalStatus;

import java.time.LocalDate;

public record PersonResponse(
        String id,
        String name,
        String email,
        MaritalStatus maritalStatus,
        String district,
        String city,
        String state,
        LocalDate birthday) {
}
