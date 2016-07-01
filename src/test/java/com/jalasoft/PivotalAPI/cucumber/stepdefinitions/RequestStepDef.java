package com.jalasoft.PivotalAPI.cucumber.stepdefinitions;


import java.util.Map;

import com.jalasoft.PivotalAPI.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;


public class RequestStepDef {

    StringBuilder str = new StringBuilder();

    private Response response;

    public Response getResponse () {
        return response;
    }

    @Given("^I have set a connection to pivotal_tracker API service$")
    public void iHaveSetAConnectionToPivotalTrackerAPIService () {

    }

    @When("^I send a POST request to (.*) with:$")
    public void iSendPostRequest (String endPoint, Map<String, Object > values) {
        if(endPoint.equalsIgnoreCase ("/projects")) {
            response = RequestManager.postRequest (endPoint, values);
        }
        else{
            int idProject = response.getBody ().path ("id");
            str.append("/projects/");
            str.append(idProject);
            String strI = str.toString();
            System.out.println(strI + endPoint);
            response = RequestManager.postRequest((strI + endPoint),values);
        }

    }

    @When("^I send to (.*) a GET request all the projects$")
    public void iSendToProjectAGETRequestAllTheProjects (String endPoint) {
        response = RequestManager.getRequest (endPoint);
    }

    @When("^I send a DELETE request to (.*)$")
    public void iSendToProjectsADELETERequestAllTheProjects (String endPoint) {
        int deleteEndpoint = response.getBody ().path ("id");
        str.append("/");
        str.append(deleteEndpoint);
        String strI = str.toString();
        response = RequestManager.deleteRequest (endPoint + strI);
    }

    @When("^I change the name project$")
    public void iChangeTheNameProjectToNewName ()  {

    }

    @And("^I send a PUT request to (.*) with:$")
    public void iSendAPUTRequestToProjects (String endPoint, Map<String, Object > values){
        int putEndpoint = response.getBody ().path ("id");
        str.append("/");
        str.append(putEndpoint);
        String strI = str.toString();
        response = RequestManager.putRequest((endPoint + strI), values);

    }

}

