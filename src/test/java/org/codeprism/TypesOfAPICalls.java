package org.codeprism;
import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class TypesOfAPICalls {
    int id;
//    @Test(priority = 2)
//    void getUser() {
////        given ()
////                .when ()
////                .get("https://jsonplaceholder.typicode.com/posts")
////                        .then ()
////                        .statusCode (200)
////                        .body ("id", hasItem (1))
////                        .log().all();
//        given()
//                .when()
//                .get("https://jsonplaceholder.typicode.com/posts")
//                .then()
//                .statusCode(200)
//                .body("size()", greaterThan(0)) // Check if the response has elements
//                .log().all();
//
//
//    }
    @Test(priority = 1)
    void singleUserbasedon3() {
        int postId = 3;
        given()
                .when()
                .get("https://jsonplaceholder.typicode.com/posts/" + postId)
                .then()
                .statusCode(200)
                .body("id", equalTo(postId))
                .body("userId", equalTo(1))
                .log().all();
    }

//    @Test(priority = 1)
//    void createUser()
//    {
//        HashMap data = new HashMap();
//        data.put("name", "prasanth");
//        data.put("job", "QA");
//        given()
//                .contentType("application/json")
//                .body(data)
//                .when()
//                .post("https://reqres.in/api/users")
//                .then()
//                .statusCode(201)
//                .log().all();
//    }
@Test (priority=2)
    void createUser()
    {
        HashMap data=new HashMap ();
        data.put("name", "Prasanth");
        data.put("job", "Software Tester");
        id=given ()
                .contentType ("application/json")
                .body (data)
                .when ()
                .post("https://reqres.in/api/users")
                .then()  // chaining starts here
                .statusCode(201)
                .log().all()
                .extract().jsonPath().getInt("id");
    }

    @Test (priority=3, dependsOnMethods= {"createUser"})
    void updateUser ()
{
    HashMap data = new HashMap ();
    data.put("name", "KSN Prasanth");
    data.put("job", "QA");
    given ( )
            .contentType ("application/json")
            .body (data)
            .when ()
            .put("https://reqres.in/api/users/"+id)
            .then ()
            .statusCode (200)
            .log().all();
}
    @Test(priority = 4)
        void deleteUser ()
    {
        given()
                .when()
                .delete("https://reqres.in/api/users/"+id)
                .then()
                .statusCode(204)
                .log().all();
    }

}


