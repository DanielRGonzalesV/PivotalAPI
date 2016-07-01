package com.jalasoft.PivotalAPI.cucumber.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/"}, //, "html:target/cucumber-html-report"
        format = {"pretty"},
        glue = {"src/test/java/com/jalasoft/PivotalAPI/cucumber/"}

)
public class Runner {

}
