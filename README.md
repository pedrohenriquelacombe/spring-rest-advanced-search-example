# Spring REST Advanced Search Example

This project is an example of how we can build advanced query search with Spring Data JPA.

## About

The main goal of this project is to show **two ways to build advanced query search with Spring Data JPA**.

- The first one, mapped as version 1 (`/persons/v1`), implements a **custom repository** using the  
  **EntityManager** to build conditional queries;
- The second one, mapped as version 2 (`/persons/v2`), is implemented using **Spring Data JPA Specifications**;

You can use both routes, `/v1` or `/v2`. They will return the same response; the only difference is that they are implemented  
in different ways.

## Technologies

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Jakarta Bean Validation](https://beanvalidation.org/)
- [Lombok](https://projectlombok.org/)
- [ModelMapper](http://modelmapper.org/)
- [Docker](https://docs.docker.com/get-started/)
- [Docker Compose](https://docs.docker.com/compose/)
- [PostgreSQL](https://www.postgresql.org/)

## Features

- DTO (Data Transfer Object) structure
- Advanced query search with:
    - TypedQuery approach
    - Spring Data JPA Specifications
- Custom exception handling with standardized error messages
- Separation of concerns with service and repository layers

## Built With

- [Spring Initializr](https://start.spring.io/)
- [Maven](https://maven.apache.org/)

## Getting Started

### Run Manually

1. Install dependencies:

```bash
  mvn clean install
```

2. Start the PostgreSQL container:

```bash
  docker compose up db -d
```

3. Run the application:

```bash
   mvn spring-boot:run
```

### Run with Docker

Start the full application stack with Docker Compose:

```bash
   docker compose up -d
```

## API Testing

You can test the API endpoints using [Bruno API Client](https://www.usebruno.com/).

> A folder named `bruno/` exists in the root of this project and contains predefined request collections for testing  
> the endpoints.

### How to use:

1. Install Bruno (if you haven't yet):  
   [https://www.usebruno.com/downloads](https://www.usebruno.com/downloads)

2. Open the project in Bruno:

- Open Bruno
- Click **Open Collection Folder**
- Select the `bruno/` folder located in the root of this project

3. Run the requests:

- The requests are organized by resource
- You can test all CRUD operations directly from the interface

Alternatively, you can use Postman, curl, or any other HTTP client to interact with the API.

## Swagger Documentation

The API documentation is available via Swagger UI served in a separate container.

- Once the full application stack is running via Docker Compose, access the Swagger UI at:  
  `http://localhost:8081`

- This container hosts the Swagger UI which reads the OpenAPI spec exposed by the Spring Boot application.

- Use this interface to explore the API interactively.
