package org.codeprism;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class PostMethods {
    @Test(priority = 1)
        //Method 1 using Hashmap
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
    //Method 2 using JSON Object
    @Test(priority = 3)
    void testPostusingJsonLibrary() //Method 2
    {
        JSONObject data = new JSONObject();
        data.put("name", "");
        data.put("location", "");
        data.put("phone", "");
        String nameArr[] = {"Fname", "Lname"};
        data.put("Username", nameArr);
        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("")
                .then()
                .statusCode(201)
                .body("name", equalTo(""))
                .body("location", equalTo(""))
                .body("phone", equalTo(""))
                .body("Username[0]", equalTo("Fname"))
                .body("Username[1]", equalTo("Lname"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }
    //Method 3 using plain old java object (POJO)
    //Using encapsulation wrapping the data into single class
    @Test(priority = 4)
    void POJO() {
        UserData data = new UserData();
        data.setEmail("");
        data.setLocation("");
        data.setPhone("");
        String nameArr[] = {"", ""};
        data.setNameArr(nameArr);
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("")
                .then()
                .statusCode(201)
                .body("name", equalTo(""))
                .body("location", equalTo(""))
                .body("phone", equalTo(""))
                .body("Username[0]", equalTo("Fname"))
                .body("Username[1]", equalTo("Lname"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }
    //Method 4 extracting the data from external files and validating
    @Test(priority = 5)
    void ExternalFile() throws FileNotFoundException {
        File f = new File(".\\data.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener (fr);
        JSONObject data = new JSONObject(jt);
        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("")
                .then()
                .statusCode(201)
                .body("name", equalTo(""))
                .body("location", equalTo(""))
                .body("phone", equalTo(""))
                .body("Username[0]", equalTo("Fname"))
                .body("Username[1]", equalTo("Lname"))
                .header("Content-Type", "application/json; charset=utf-8")
                .log().all();
    }
    @Test(priority = 2)
        void Delete () {
        given()
                .when()
                .delete("")
                .then()
                .statusCode(200)
                .log().all();
    }
    }

