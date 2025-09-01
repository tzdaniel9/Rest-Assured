package authentication;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class pre_emptive_authentication {

    @Test
    public void PreEmptiveAuthentication(){
        RestAssured.given().auth().preemptive().basic("postman", "password").
                when().
                get("https://postman-echo.com/basic-auth").
                then().
                statusCode(200).
                body("authenticated", Matchers.equalTo(true));
    }
}
