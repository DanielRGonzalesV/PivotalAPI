package com.jalasoft.PivotalAPI.cucumber.stepdefinitions;

import java.util.Map;

import com.jayway.restassured.response.Response;

/**
 * Created by danielgonzales on 7/1/2016.
 */
public class LocalRepository {

    public static Map<String, Response> projects;

public static void setValues(String key, Response value){
    projects.put (key, value);
}


}
