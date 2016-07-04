package com.jalasoft.PivotalAPI;

import java.util.Map;

import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;


public class RequestManager {
    private static final RequestSpecification RESPONSE_SPECIFICATION = Authentication.getInstance ().getRequestSpecification ();

    private static final Logger LOGGER = Logger.getLogger(RequestManager.class.getName());

    private RequestManager () {
    }

    public static Response getRequest (String endpoint) {
        return RESPONSE_SPECIFICATION.when ().get (endpoint);
    }

    public static Response postRequest (String endpoint, Map<String, Object> parameters) {
        JsonParser jsonParser = new JsonParser ();
        JsonElement jsonObject = jsonParser.parse(parameters.toString());
        LOGGER.info("The JSON object is: " + jsonObject);
        return RESPONSE_SPECIFICATION.contentType (ContentType.JSON).body (jsonParser.parse (parameters.toString ())).when ().post (endpoint);
    }

    public static Response deleteRequest (String endpoint) {
    return RESPONSE_SPECIFICATION.when ().delete (endpoint);
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters ){
        JsonParser jsonParser = new JsonParser ();
        JsonElement jsonObject = jsonParser.parse(parameters.toString());
        LOGGER.info("The JSON object is: " + jsonObject);
        return RESPONSE_SPECIFICATION.contentType (ContentType.JSON).body (jsonParser.parse (parameters.toString ())).when ().put(endpoint);
    }


}

