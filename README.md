# Spring REST Advanced Search Example


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
