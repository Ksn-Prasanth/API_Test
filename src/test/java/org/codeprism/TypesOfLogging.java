package org.codeprism;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TypesOfLogging {
    @Test (priority = 1)
    void logs()
    {
        given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                //.log().body() //log only the response without Headers and cookies
                //.log().headers(); //Log only the headers
                //.log().cookies() //Log only the cookies
                .log().all(); //Log all the response
    }
}
