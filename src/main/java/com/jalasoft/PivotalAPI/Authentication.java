package com.jalasoft.PivotalAPI;

import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

public class Authentication {

    public static final String CONTENT_TYPE = "application/json";

    public static final String TOKEN_HEADER = "X-TrackerToken";

    private static Authentication instance;

    private RequestSpecification requestSpecification;
    private Authentication() {
        initApi();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        baseURI = PropertiesInfo.getInstance().getBaseUrl();
        requestSpecification = given().relaxedHTTPSValidation()
                .proxy("http://172.20.240.5:8080")
                .header(TOKEN_HEADER, PropertiesInfo.getInstance().getToken());
                //.contentType(CONTENT_TYPE);
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
