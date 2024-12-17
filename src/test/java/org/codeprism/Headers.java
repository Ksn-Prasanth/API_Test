package org.codeprism;


import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Headers {
    @Test(priority = 1)
    void testHeaders() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .header("Content-Type", "text/html; charset=ISO-8859-1")
                .header("Content-Encoding", "gzip")
                .header("Server", "gws")
                .log().headers(); //only to print headers
    }

    @Test(priority = 2)
    void getHeaders() {
        Response res = given()
                .when()
                .get("https://www.google.com/");
        //Single header value info
//        String headervalue = res.getHeader("Content-Type");
//        System.out.println("Value of content-type is"+headervalue);
        //get all header value
        io.restassured.http.Headers myheaders = res.getHeaders();
        for (io.restassured.http.Header hd : myheaders) {
            System.out.println(hd.getName() + "       " + hd.getValue());
        }



    }
}
