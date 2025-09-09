package com.api.tests;

import com.api.base.AuthService;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ForgotPasswordTest {
    @Test(description = "Verify if forgot password is working")

    public void forgotPasswordTest(){
        AuthService authService = new AuthService();
        Response response = authService.forgotPassword("t9daniel@gmail.com");
        System.out.println(response.asPrettyString());
    }
}
