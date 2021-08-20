package com.example.advancedsearch.model;

import com.example.advancedsearch.enums.MaritalStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "persons")
public class Person implements Serializable {

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

    public Person(String name, String email, MaritalStatus maritalStatus, String district, String city, String state, LocalDate birthday) {
        this.name = name;
        this.email = email;
        this.maritalStatus = maritalStatus;
        this.district = district;
        this.city = city;
        this.state = state;
        this.birthday = birthday;
    }

    @PrePersist
    private void prePersist() {
        this.id = UUID.randomUUID().toString();
        this.createdAt = LocalDateTime.now();
    }

}
