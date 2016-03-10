package com.mycompany.app.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		monochrome = true,
        format = { "pretty", "html:target/cucumber" },
        glue = "com.mycompany.app.steps",
        features={"src/test/resources/login.feature"}
)
public class RunTest {

}
