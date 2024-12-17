package org.codeprism;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Cookies {
    //@Test
    void testCookies() {
        given()
                .when()
                .get("https://www.google.com/")
                .then()
                .cookie("AEC", "AakniGOLxRQC9fgi6mjPYfT76_mMHEZC-z_5xRB2ApPi8Ag2HZdJvBWMxZU")
                .log().all();
    }

    @Test(priority = 1)
    void getCookieInfo() {
        Response res = given()
                .when()
                .get("https://www.google.com/");
        //get single cookie info
        //String cookie_value = res.getCookie("AEC");
        //System.out.println("Value of cookie is====>" + cookie_value);
        //get all cookies info
        Map<String, String> cookies_values = res.getCookies();
        System.out.println(cookies_values.keySet());
        for (String k : cookies_values.keySet()) {
            String cookie_value = res.getCookie(k);
            System.out.println(k + "     " + cookie_value);
        }
    }
}
