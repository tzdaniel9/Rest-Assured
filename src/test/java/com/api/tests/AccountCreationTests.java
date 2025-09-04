package com.api.tests;

import com.api.base.AuthService;
import com.api.models.requests.SignUpRequest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AccountCreationTests {
    @Test(description =  "Verify account creation works")

    public void createAccountTest(){
        SignUpRequest signUpRequest = new SignUpRequest.Builder()
                .username("bhense1234")
                .password("bhense1234")
                .email("t9daniel9@gmail.com")
                .firstName("bhense")
                .lastName("bhense")
                .mobileNumber("0789012344")
                .build();

        AuthService authService = new AuthService();
        Response response = authService.signUp(signUpRequest);
        Assert.assertEquals(response.asPrettyString(), "User registered successfully!");
        Assert.assertEquals(response.statusCode(), 200);
    }
}
