package com.example.advancedsearch.dto.request;

import com.example.advancedsearch.enums.MaritalStatus;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public record PersonRequest(
        @NotEmpty String name,
        @Email @NotEmpty String email,
        @NotNull MaritalStatus maritalStatus,
        @NotEmpty String district,
        @NotEmpty String city,
        @NotEmpty String state,
        @NotNull @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate birthday) {
}
