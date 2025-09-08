package com.api.tests;

import com.api.base.AuthService;
import com.api.models.requests.LoginRequest;
import com.api.models.response.LoginResponse;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


@Listeners(com.api.listeners.TestListeners.class)
public class LoginTests {

    @Test(description = "verify if login api is working")
    public void login() {
        Response res = given().baseUri("http://64.227.160.186:8080").header("Content-Type", "application/json").body("{" +
                "\"username\": \"muso1234\", " +
                "\"password\": \"muso1234\"" +
                "}").post("/api/auth/login");
        System.out.println(res.asPrettyString());

        Assert.assertEquals((res.getStatusCode()), 200);
    }

    @Test(description = "verify if login api is working")
    public void loginServiceTest() {
        LoginRequest loginRequest = new LoginRequest("muso1234", "muso1234");
        AuthService authService = new AuthService();
        Response response = authService.login(loginRequest);
        LoginResponse loginResponse = response.as(LoginResponse.class);
        System.out.println(response.asPrettyString());
        System.out.println(loginResponse.getToken());
        System.out.println(loginResponse.getEmail());
        System.out.println(loginResponse.getId());
        Assert.assertTrue(loginResponse.getToken() != null);
        Assert.assertEquals(loginResponse.getEmail(), "t9daniel@gmail.com");
        Assert.assertEquals(loginResponse.getId(), 2587);

    }
}
