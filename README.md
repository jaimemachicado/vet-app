# Vet-App

Vet-App is a modern, example application built with the Spring Framework, utilizing Java and Maven for its development. It embodies the principles of Hexagonal Architecture and Domain-Driven Design (DDD) to create a maintainable, scalable web application framework. Integration testing is facilitated through RestAssured, ensuring robustness and reliability.

## Features

- Built with Spring Framework, Java, and Maven.
- Designed using Hexagonal Architecture and Domain-Driven Design (DDD) for scalability and maintainability.
- Integration testing with RestAssured.
- Containerized with Docker for easy deployment and execution.

## Getting Started

To run Vet-App, ensure Docker and Docker Compose are installed on your system. You can launch the application using the following command:

```bash
docker compose up
```

This command builds and runs a Docker container for the application, making it accessible on localhost:8080.

## Testing the Application
The application exposes a RESTful endpoint for adding new pets:

- Endpoint: POST localhost:8080/pets
- Sample Body:

```json
{
    "name": "Rex",
    "breed": "German Shepherd",
    "dateOfBirth": "2005-01-01",
    "isVaccinated": true,
    "color": "Brown",
    "ownerName": "Jaime Machicado",
    "ownerPhoneNumber": "666666666"
}
```
