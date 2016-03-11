package com.mycompany.app.Config;

import static com.mycompany.app.ExecutionEngine.DriverScript.OR;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.mycompany.app.Utility.log;

public class libraryScript {
	
	public static WebDriver driver;
	
	public static void openBrowser(){
		log.info("FirefoxDriver Instantiation!");
		try{
			
			//driver = new HtmlUnitDriver(BrowserVersion.FIREFOX_24);
			driver = new FirefoxDriver();
			//driver = new HtmlUnitDriver();
			/*
			FirefoxBinary binary = new FirefoxBinary(new File("/usr/bin/firefox"));
   			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			driver = new FirefoxDriver(binary,firefoxProfile);
			*/
		    log.info("FirefoxDriver Instantiated successfully!");
		    System.out.println("Driver Instantiated successfully!");
		}
		catch(Exception e){
			log.error(e.getMessage());
			System.out.println("Driver not Instantiated successfully!");
		}
	}
	
    public static void navigate(){
    	log.info("Launch URL");
    	try{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		log.info("URL Hit Sucessfully!");
		System.out.println("URL Hit Sucessfully! - Current Url is: "+ driver.getCurrentUrl());
		
       }
	catch(Exception e)
       {
		log.error(e.getMessage());
		System.out.println("URL Not Hit Sucessfully!");
	   }
	}
    
    public static void VerifyHomePage(String object){
    	try{
    	log.info("Verify the Home Page Now!");
    	boolean state = CustomWait(object);
    	if(state)
    	{
    		System.out.println(driver.getTitle());
		log.info("Project Dashboard opened successfully!");
		System.out.println("Project Dashboard opened successfully!");
    	}
    	else
    		System.out.println("Project Dashboard not opened successfully!");
    	}
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 		System.out.println("Exception Occured in Verify Home Page");
 	   }
	}
    
    public static void Input(String object){
    	try{
    		log.info("Authenticate User - Entering User Email and Password");
    		System.out.println("Authenticate User - Entering User Email and Password");
    	boolean state = CustomWait(object);
    	if(state)
    	    { 
    		if(object.equals("email")){
    		  WebElement ele = driver.findElement(By.xpath(OR.getProperty(object)));
    				  ele.sendKeys(Constants.email);
    		  System.out.println("Email entered is: "+ ele.getAttribute("value") );
    	    }
    		if(object.equals("password")){
    			WebElement ele = driver.findElement(By.xpath(OR.getProperty(object)));
    					ele.sendKeys(Constants.password);
    					System.out.println("Password entered is: "+ ele.getAttribute("value") );
      	    }
      		}
    	}
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 		System.out.println("Issue in entering user credentials");
 	   }
   	}
    /*public static void UserAuthenticateEnterPassword(String object){
    	try{
    		log.info("Authenticate User - Enter Password!");
    	   	driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.Password);
    	   }
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 	   }
   	}*/
    public static void Click(String object){
    try{
    	log.info("Authenticate User - Click Next!");
    	System.out.println("Authenticate User - Click Next!");
    	driver.findElement(By.xpath(OR.getProperty(object))).click();
       }
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 		System.out.println("Error in Click Next!");
 	   }
   	}
    public static void QuitDriver(String object){
    	log.info("Quit Browser");
    	System.out.println("Quit Browser");
    	driver.quit();
    	
   	}
    public static boolean CustomWait(String object){
    	try{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(OR.getProperty(object))));
    	return true;
    	}
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 		System.out.println("Error in custom wait");
 		return false;
 	    }
    	
    }
    public static void switchTowindow(){
    	for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
    }
    public static void selectdropdownValue(String object, String value){
    	WebElement drp = driver.findElement(By.xpath(OR.getProperty(object)));
    	Select obj = new Select(drp);
    	obj.selectByValue(value);
    }
    
}
