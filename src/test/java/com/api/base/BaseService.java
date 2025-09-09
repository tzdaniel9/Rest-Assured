package com.api.base;

import static io.restassured.RestAssured.*;

import com.api.filters.LoggingFilter;
import com.api.models.requests.LoginRequest;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
    private static final String BASE_URL = "http://64.227.160.186:8080";
    public RequestSpecification requestSpecification;

    static {
        RestAssured.filters(new LoggingFilter());
    }
    public BaseService() {
        requestSpecification = given().baseUri(BASE_URL);
    }

    protected Response postRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
    }

    protected Response putRequest(Object payload, String endpoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
    }

    protected Response postRequest(String payload, String endPoint) {
        return requestSpecification.contentType(ContentType.JSON).body(payload).post(endPoint);
    }

    protected Response getRequest(String endPoint) {
        return requestSpecification.get(endPoint);
    }

    protected void setAuthToken(String token) {
        requestSpecification.header("Authorization", "Bearer " + token);
    }
}
