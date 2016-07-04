package com.jalasoft.PivotalAPI.cucumber.stepdefinitions;


import java.util.Map;

import com.jalasoft.PivotalAPI.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import static com.jalasoft.PivotalAPI.cucumber.stepdefinitions.LocalRepository.projects;


public class ResourceStepDef {

    StringBuilder str = new StringBuilder();

    private Response response;



    @Given("^I have set a connection to pivotal_tracker API service$")
    public void iHaveSetAConnectionToPivotalTrackerAPIService () {

    }

    @When("^I send a POST request to (.*) with:$")
    public void iSendPostRequest (String endPoint, Map<String, Object > values) {
        if(endPoint.equalsIgnoreCase ("/projects")) {
            response = RequestManager.postRequest (endPoint, values);
        }
        else{
            response = RequestManager.postRequest(getEndPoint(endPoint),values);

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

    public Response getResponse () {
        return response;
    }

    public String getEndPoint(String verifyEndPoint){

        String finalEndPoint = verifyEndPoint;

        if(verifyEndPoint.contains ("Project.id")) {
            int id = projects.get ("Project1").path ("id");
            finalEndPoint = finalEndPoint.replace ("[Project1.id]", String.valueOf (id));
        }

        return finalEndPoint;

    }


}

