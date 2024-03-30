package com.jmachicado.vetapp.integration;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CreatePetIntegrationTest {

  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;
  }

  @Test
  @DisplayName("Create pet when all steps success - OK")
  public void createPet_whenAllStepsSuccess_ok() {
    // Given
    String requestBody = """
        {
             "name": "Rex",
             "breed": "Galgo español",
             "dateOfBirth": "2007-02-25",
             "isVaccinated": true,
             "color": "brown",
             "ownerName": "Jaime Machicado",
             "ownerPhoneNumber": "666666666"
        }
        """;

    // When
    RestAssured
        .given()
        .contentType("application/json")
        .body(requestBody)
        .when()
        .post("/pets")
        // Then
        .then()
        .statusCode(HttpStatus.CREATED.value())
        .extract();
  }

  @Test
  @DisplayName("Create pet with bad formatted body - BAD REQUEST")
  public void createPet_withBadFormattedBody_badRequest() {
    // Given
    String badFormattedRequestBody = """
        {
             "name": "Rex",
             "breed": "Galgo español",
             "dateOfBirth": "2007-02-25",
             "isVaccinated": true
             "color": "brown",
             "ownerName": "Jaime Machicado",
             "ownerPhoneNumber": "666666666"
        }
        """;

    // When
    RestAssured
        .given()
        .contentType("application/json")
        .body(badFormattedRequestBody)
        .when()
        .post("/pets")
        // Then
        .then()
        .statusCode(HttpStatus.BAD_REQUEST.value())
        .extract();
  }

}
