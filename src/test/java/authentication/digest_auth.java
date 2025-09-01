package authentication;

import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class digest_auth {
    @Test
    public void digestAuthentication(){
        RestAssured.given().auth().digest("postman", "password").
                when().
                get("https://postman-echo.com/digest-auth").
                then().
                statusCode(200).
                body("authenticated", Matchers.equalTo(true)).log().all();
    }
}
