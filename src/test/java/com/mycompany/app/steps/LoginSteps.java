package com.mycompany.app.steps;

import java.io.IOException;

import com.mycompany.app.Config.libraryScript;
import com.mycompany.app.ExecutionEngine.DriverScript;
import com.mycompany.app.Utility.log;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class LoginSteps {
	@Given("^Launch Url$")
	public void launch_url() 	    {
	libraryScript.openBrowser();
	libraryScript.navigate();
	
    }

@When("^user enter email for User authentication$")
    public void enter_email() 
    {
	libraryScript.Input("email");

    }

@When("^user enter Password for User authentication$")
public void enter_password()
{
libraryScript.Input("password");

}
/*
@And("^user click Next button$")
public void click_next()
{
	libraryScript.Click("next_btn");
	
}*/

@And("^user click on SignIn$")
public void click_SignIn()
{
	libraryScript.Click("signIn");

}

@And("^user should be on Project Dashboard Page$")
public void Verify_homepage()
{
	libraryScript.VerifyHomePage("link_projectList");

}

@Before()
public void beforeScenario(){
	//DriverScript DS = new DriverScript();
	  try {
		DriverScript.loadOR();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  log.info("OR loaded");
	  DriverScript.InitializeLogs();
}
}
