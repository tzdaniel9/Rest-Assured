package authentication;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class pre_emptive_authentication {

    @Test
    public void PreEmptiveAuthentication(){
        given().auth().preemptive().basic("postman", "password").
                when().
                get("https://postman-echo.com/basic-auth").
                then().
                statusCode(200).
                body("authenticated", Matchers.equalTo(true));
    }
}
