package authentication;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class digest_auth {
    @Test
    public void digestAuthentication(){
        given().auth().digest("postman", "password").
                when().
                get("https://postman-echo.com/digest-auth").
                then().
                statusCode(200).
                body("authenticated", Matchers.equalTo(true)).log().all();
    }
}
