package com.jalasoft.PivotalAPI.cucumber.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

public class ResponseStepDef {

    private ResourceStepDef requestStepDef;

    public ResponseStepDef (ResourceStepDef requestStepDef){
        this.requestStepDef = requestStepDef;
    }


    @Then("^I expect Status code (\\d+)$")
    public void iExpectStatusCode (int statusCode) {
        assertEquals(statusCode, requestStepDef.getResponse ().statusCode ());

    }

    @And("^store as (.*)$")
    public void storeAsProject (String projectKey) {

        LocalRepository.setValues (projectKey, requestStepDef.getResponse ());


    }

}
