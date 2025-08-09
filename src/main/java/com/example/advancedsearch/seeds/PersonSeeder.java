package com.example.advancedsearch.seeds;

import com.example.advancedsearch.enums.MaritalStatus;
import com.example.advancedsearch.model.Person;
import com.example.advancedsearch.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Profile({"test", "default"})
@Component
@RequiredArgsConstructor
public class PersonSeeder implements CommandLineRunner {

    private final PersonRepository personRepository;

    @Override
    public void run(String... args) {
        if (this.personRepository.count() == 0) {
            this.personRepository.save(new Person("Pedro", "pedro@gmail.com", MaritalStatus.MARRIED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1992, 8, 28)));
            this.personRepository.save(new Person("Marcos", "marcos@gmail.com", MaritalStatus.DIVORCED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1990, 2, 11)));
            this.personRepository.save(new Person("Paulo", "paulo@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1988, 3, 12)));
            this.personRepository.save(new Person("Vinicios", "vinicios@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1996, 7, 18)));
            this.personRepository.save(new Person("Jorge", "jorge@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(2000, 9, 21)));
            this.personRepository.save(new Person("Aline", "aline@gmail.com", MaritalStatus.DIVORCED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1997, 10, 27)));
            this.personRepository.save(new Person("Paula", "paula@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1995, 11, 2)));
            this.personRepository.save(new Person("Ana", "ana@gmail.com", MaritalStatus.MARRIED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1993, 3, 1)));
            this.personRepository.save(new Person("Marcia", "marcia@gmail.com", MaritalStatus.WIDOWED, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1964, 8, 9)));
            this.personRepository.save(new Person("Maria", "maria@gmail.com", MaritalStatus.WIDOWED, "Vila Mariana", "São Paulo", "SP", LocalDate.of(2001, 12, 8)));
            this.personRepository.save(new Person("Mario", "mario@gmail.com", MaritalStatus.SINGLE, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1991, 11, 9)));
            this.personRepository.save(new Person("Vanessa", "vanessa@gmail.com", MaritalStatus.SINGLE, "Tijuca", "Rio de Janeiro", "RJ", LocalDate.of(1999, 4, 7)));
            this.personRepository.save(new Person("Yuri", "yuri@gmail.com", MaritalStatus.SINGLE, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1984, 6, 15)));
            this.personRepository.save(new Person("Lauro", "lauro@gmail.com", MaritalStatus.SINGLE, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1988, 7, 14)));
            this.personRepository.save(new Person("Jessica", "jessica@gmail.com", MaritalStatus.DIVORCED, "Vila Mariana", "São Paulo", "SP", LocalDate.of(1965, 9, 12)));
            this.personRepository.save(new Person("Hiago", "hiago@gmail.com", MaritalStatus.DIVORCED, "Pampulha", "Belo Horizonte", "MG", LocalDate.of(1968, 1, 19)));
            this.personRepository.save(new Person("Lucas", "lucas@gmail.com", MaritalStatus.WIDOWED, "Pampulha", "Belo Horizonte", "MG", LocalDate.of(1978, 7, 23)));
        }
    }

}
