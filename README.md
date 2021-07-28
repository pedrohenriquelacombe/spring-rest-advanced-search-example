# Spring REST Advanced Search example

This project is an example of how can we build advanced query search with Spring Data JPA.

## About

The main goal of this project is to show **two forms that we can build advanced query search with Spring Data JPA**.

- First one, mapped as version 1 ("/persons/v1"), we are implementing a **custom repository** and using the
  **EntityManager** for build our condition query;
- Second one, mapped as version 2 ("/persons/v2"), implementated using **Spring Data JPA Specifications**;

You can use both routes, /v1 or /v2. They will bring the same response, the only difference is thay they are implemented
in differentes ways. Check below for some examples.

**Advanced Search** examples:

```
localhost:8080/persons/v1?name=Ma
localhost:8080/persons/v1?name=Ma&email=pedro@
localhost:8080/persons/v1?name=Ma&email=pedro@&maritalStatus=MARRIED
localhost:8080/persons/v1?name=Ma&email=pedro@&maritalStatus=MARRIED&district=Tijuca
localhost:8080/persons/v1?name=Ma&email=pedro@&maritalStatus=MARRIED&district=Tijuca&city=Rio de Janeiro
localhost:8080/persons/v1?name=Ma&email=pedro@&maritalStatus=MARRIED&state=RJ
```

**Pagination** and **Sorting** examples:

```
localhost:8080/persons/v1?pageSize=5
localhost:8080/persons/v1?pageSize=5&pageNumber=0
localhost:8080/persons/v1?sortBy=name&orderBy=asc
localhost:8080/persons/v1?pageSize=5&pageNumber=0&sortBy=name&orderBy=desc
```

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Validation](https://beanvalidation.org/)
- [Lombok](https://projectlombok.org/)
- [H2 Database](https://www.h2database.com/html/quickstart.html)

## Features

- DTO (Data Transfer Object) principles
- Advanced query search with:
    - Spring Data JPA Specifications
    - TypedQuery way
- Custom Exception Handler messages

## Built With

- [Maven](https://maven.apache.org/index.html)
- [Spring Initializr](https://start.spring.io/#!type=maven-project&language=java&platformVersion=2.5.3.RELEASE&packaging=jar&jvmVersion=11&groupId=com.example&artifactId=advancedsearch&name=SpringRestAdvancedSearch&description=Demo%20project%20for%20Spring%20Boot&packageName=com.example.advancedsearch&dependencies=web,lombok,h2,data-jpa,devtools,validation)

## How can I test my endpoints?

First, open your preference code editor and run the following code below:

```
mvn clean install
```

After the maven downloaded all dependencies, run the **SpringRestAdvancedSearchApplication.class**.

For tests cases, you can check the API endpoints with Postman.

- [Postman Collection](https://www.getpostman.com/collections/91845af25e9d11fb4f2f)
