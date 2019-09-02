package com.epam.vladislav_sharachev.tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.vladislav_sharachev.users.User;

public class AllTests {

    @BeforeClass
    public void initTest() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void checkStatusCode() {
        Response response = RestAssured.when().get("/users").andReturn();
        Assert.assertEquals(response.getStatusCode(), 200);
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("ID Current Thread: " + Thread.currentThread().getId());
    }

    @Test
    public void checkResponseHeader() {
        Response response = RestAssured.when().get("/users").andReturn();
        String responseContentTypeHeader = response.getHeader("Content-type");
        Assert.assertEquals(responseContentTypeHeader, "application/json; charset=utf-8");
        System.out.println("ID Current Thread: " + Thread.currentThread().getId());
    }

    @Test
    public void checkResponseBody() {
        Response response = RestAssured.when().get("/users").andReturn();
        ResponseBody responseBody = response.getBody();
        User[] users = responseBody.as(User[].class);
        Assert.assertEquals(users.length, 10);
        System.out.println("Users: " + users.length);
        System.out.println("ID Current Thread: " + Thread.currentThread().getId());
    }
}