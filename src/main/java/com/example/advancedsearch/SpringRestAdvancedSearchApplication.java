package com.example.advancedsearch;

import com.example.advancedsearch.enums.MaritalStatus;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class SpringRestAdvancedSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestAdvancedSearchApplication.class, args);
    }

    @Bean
    CommandLineRunner run(PersonRepository personRepository) {
        return args -> {
            personRepository.save(new Person("Pedro", "pedro@gmail.com", MaritalStatus.MARRIED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1992, 8, 28)));
            personRepository.save(new Person("Marcos", "marcos@gmail.com", MaritalStatus.DIVORCED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1990, 2, 11)));
            personRepository.save(new Person("Paulo", "paulo@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1988, 3, 12)));
            personRepository.save(new Person("Vinicios", "vinicios@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1996, 7, 18)));
            personRepository.save(new Person("Jorge", "jorge@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(2000, 9, 21)));
            personRepository.save(new Person("Aline", "aline@gmail.com", MaritalStatus.DIVORCED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1997, 10, 27)));
            personRepository.save(new Person("Paula", "paula@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1995, 11, 2)));
            personRepository.save(new Person("Ana", "ana@gmail.com", MaritalStatus.MARRIED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1993, 3, 1)));
            personRepository.save(new Person("Marcia", "marcia@gmail.com", MaritalStatus.WIDOWED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1964, 8, 9)));
            personRepository.save(new Person("Maria", "maria@gmail.com", MaritalStatus.WIDOWED, "Vila Mariana", "São Paulo", "SP", LocalDate.of(2001, 12, 8)));
            personRepository.save(new Person("Mario", "mario@gmail.com", MaritalStatus.SINGLE, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1991, 11, 9)));
            personRepository.save(new Person("Vanessa", "vanessa@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1999, 4, 7)));
            personRepository.save(new Person("Yuri", "yuri@gmail.com", MaritalStatus.SINGLE, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1984, 6, 15)));
            personRepository.save(new Person("Lauro", "lauro@gmail.com", MaritalStatus.SINGLE, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1988, 7, 14)));
            personRepository.save(new Person("Jessica", "jessica@gmail.com", MaritalStatus.DIVORCED, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1965, 9, 12)));
            personRepository.save(new Person("Hiago", "hiago@gmail.com", MaritalStatus.DIVORCED, "Pampulha", "Belo Horizonte", "MG", LocalDate.of(1968, 1, 19)));
            personRepository.save(new Person("Lucas", "lucas@gmail.com", MaritalStatus.WIDOWED, "Pampulha", "Belo Horizonte", "MG", LocalDate.of(1978, 7, 23)));
        };
    }

}
