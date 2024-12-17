package org.codeprism;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class parsingResponseBody {
   //Approach 1
   // @Test
    void jsonresponse()
    {
        given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .header("Content-Type","application/json; charset=utf-8")
                .body("data[2].avatar", equalTo("https://reqres.in/img/faces/9-image.jpg"));
                System.out.println("The image related to id 9 is matching");
    }
    //Approach 2
    //@Test(priority = 2)
    void Approach2()
    {
        Response res = given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");
        Assert.assertEquals(res.getStatusCode(),200);
       // System.out.println("Status code is passed");
        Assert.assertEquals(res.header("Content-Type"),"application/json; charset=utf-8");
       // System.out.println("The content-type header is matched with response");
        String lastname = res.jsonPath().get("data[5].last_name");
        Assert.assertEquals(lastname, "Howell");
      //  System.out.println("The actual lastname is matched with expected lastname");
    }
    //Approach 3 using JSON object class
    @Test(priority = 1)
    void approach3()
    {
        Response res =
                given()
                .contentType(ContentType.JSON)
                .when()
                .get("https://reqres.in/api/users?page=2");
        JSONObject jo = new JSONObject(res.getBody().asString()); //converting the response to json object
        //printing all the records related to particular field
//        for (int i = 0;i<jo.getJSONArray("data").length();i++) //getting the length of the json elements
//        {
//            String mailid = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
//            System.out.println(mailid);
//        }
        //Search for particular field
        boolean status = false;
        String foundMailId = "";
        for (int i = 0;i<jo.getJSONArray("data").length();i++) //getting the length of the json elements
        {
            String mailid = jo.getJSONArray("data").getJSONObject(i).get("email").toString();
            if (mailid.equals("tobias.funke@reqres.in"))
            {
                status = true;
                foundMailId = mailid;
                break;
            }
        }
        Assert.assertEquals(status,true);
        System.out.println("Found mail ID: " + foundMailId);
    }
}
