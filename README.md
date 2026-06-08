# Spring Boot Architecture Demo

A small teaching repository for showing software architecture with Spring Boot.

## Architecture

- `controller` handles HTTP requests
- `service` contains business logic
- `repository` provides data access
- `model` defines domain data

## Requirements

- Java 17+
- Maven 3.9+

## Run the application

```bash
mvn spring-boot:run
```

## Test the API

- `http://localhost:8080/api/coffee`
- `http://localhost:8080/api/coffee/Campus%20Cafe`
- `http://localhost:8080/api/coffee/accessible`

## Run tests

```bash
mvn test
```

## Suggested classroom flow

1. Run the app.
2. Call the endpoints.
3. Trace request flow through controller, service, and repository.
4. Extend the repository data.
5. Add a new endpoint.
6. Optionally migrate to H2 and Spring Data JPA.
