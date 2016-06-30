package com.jalasoft.PivotalAPI.cucumber.stepdefinitions.Projects;

import com.jalasoft.PivotalAPI.Request;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class GetProjectSteps {

    private Response response;

    public Response getResponse () {
        return response;
    }

    @Given("^I have set a connection to pivotal_tracker API service$")
    public void iHaveSetAConnectionToPivotalTrackerAPIService () {

    }

    @When("^I send to (.*) a GET request all the projects$")
    public void iSendToProjectAGETRequestAllTheProjects (String endPoint) {
        response = Request.getRequest (endPoint);
    }


}
