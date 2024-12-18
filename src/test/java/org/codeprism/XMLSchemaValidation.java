package org.codeprism;

import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class XMLSchemaValidation {
    @Test
    void XMLSchemavaliadtion()
    {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("file name in the resources with extension .xsd"));
    }
}
