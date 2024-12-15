package org.codeprism;

import org.testng.annotations.Test;

import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostMethods {
    @Test(priority = 1)
    void HashMap() {
        HashMap data = new HashMap();
        data.put("email", "");
        data.put("location", "");
        data.put("phone", "");
        String nameArr[] = {"Fname", "Lname"};
        data.put("Username", nameArr);
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .body("email", equalTo(""))
                .body("location", equalTo(""))
                .body("phone", equalTo(""))
                .body("Username[0]", equalTo("Fname"))
                .body("Username[1]", equalTo("Lname"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }
    @Test(priority = 2)
    void Delete() {
        given()
                .when()
                .delete("")
                .then()
                .statusCode(200)
                .log().all();
    }
}
