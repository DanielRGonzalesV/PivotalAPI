package com.jalasoft.PivotalAPI.cucumber.stepdefinitions.Projects;

import cucumber.api.java.en.Then;

import static org.junit.Assert.assertEquals;

/**
 * Created by danielgonzales on 6/30/2016.
 */
public class AssertionsProject {

    private GetProjectSteps getProjectSteps;

    public AssertionsProject(GetProjectSteps getProjectSteps){
        this.getProjectSteps = getProjectSteps;
    }


    @Then("^I expect Status the projects code (\\d+)$")
    public void iExpectStatusTheProjectsCode (int statusCode) {

        assertEquals(statusCode, getProjectSteps.getResponse ().statusCode ());

    }

}
