package com.example.advancedsearch.model;

import com.example.advancedsearch.enums.MaritalStatus;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "persons")
public class Person {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private LocalDate birthday;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

}
