package authentication;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class basic_auth {
    @Test
    public void basicAuthentication(){
        RestAssured.given().auth().basic("postman", "password").
                when().
                get("https://postman-echo.com/basic-auth").
                then().
                statusCode(200).
                body("authenticated", Matchers.equalTo(true)).log().all();
    }
}
