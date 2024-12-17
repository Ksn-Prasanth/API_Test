package org.codeprism;

import org.testng.annotations.Test;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.RestAssured.*;

public class jsonschemavalidation {
    @Test
    void schemavalidation()
    {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schema.json"));
    }
}
