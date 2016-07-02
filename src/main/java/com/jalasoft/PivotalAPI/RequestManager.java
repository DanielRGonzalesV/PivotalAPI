package com.jalasoft.PivotalAPI;

import java.util.Map;

import com.google.gson.JsonParser;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


public class RequestManager {
    private static final RequestSpecification RESPONSE_SPECIFICATION = Authentication.getInstance ().getRequestSpecification ();

    private RequestManager () {
    }

    public static Response getRequest (String endpoint) {
        return RESPONSE_SPECIFICATION.when ().get (endpoint);
    }

    public static Response postRequest (String endpoint, Map<String, Object> parameters) {
        JsonParser jsonParser = new JsonParser ();
        //par = jsonParser.parse(parameters.toString()).getAsJsonObject());//change to logger
        return RESPONSE_SPECIFICATION.contentType (ContentType.JSON).body (jsonParser.parse (parameters.toString ())).when ().post (endpoint);
    }

    public static Response deleteRequest (String endpoint) {
    return RESPONSE_SPECIFICATION.when ().delete (endpoint);
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters ){
        JsonParser jsonParser = new JsonParser ();
        return RESPONSE_SPECIFICATION.contentType (ContentType.JSON).body (jsonParser.parse (parameters.toString ())).when ().put(endpoint);
    }


}

