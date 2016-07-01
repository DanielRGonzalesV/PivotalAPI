package com.jalasoft.PivotalAPI.cucumber.stepdefinitions;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ResponseStepDef {

    private RequestStepDef requestStepDef;

    public ResponseStepDef (RequestStepDef requestStepDef){
        this.requestStepDef = requestStepDef;
    }


    @Then("^I expect Status code (\\d+)$")
    public void iExpectStatusCode (int statusCode) {
        assertEquals(statusCode, requestStepDef.getResponse ().statusCode ());

    }

}
