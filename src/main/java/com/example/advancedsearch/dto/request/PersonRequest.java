package com.example.advancedsearch.dto.request;

import com.example.advancedsearch.enums.MaritalStatus;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
public class PersonRequest {

    @NotEmpty
    private String name;

    @NotEmpty
    private String email;

    @NotNull
    private MaritalStatus maritalStatus;

    @NotEmpty
    private String district;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

}
