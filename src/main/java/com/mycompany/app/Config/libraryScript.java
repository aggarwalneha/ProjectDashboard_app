package com.mycompany.app.Config;

import static com.mycompany.app.ExecutionEngine.DriverScript.OR;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.mycompany.app.Utility.log;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class libraryScript {
	
	public static WebDriver driver;
	
	public static void openBrowser(){
		log.info("FirefoxDriver Instantiation!");
		try{
			//driver = new FirefoxDriver();
			driver = new HtmlUnitDriver();
		    log.info("FirefoxDriver Instantiated successfully!");
		}
		catch(Exception e){
			log.error(e.getMessage());
		}
	}
	
    public static void navigate(){
    	log.info("Launch URL");
    	try{	
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.get(Constants.URL);
		log.info("URL Hit Sucessfully!");
		driver.manage().window().maximize();
       }
	catch(Exception e)
       {
		log.error(e.getMessage());
	   }
	}
    
    public static void VerifyHomePage(String object){
    	try{
    	log.info("Verify the Home Page Now!");
    	boolean state = CustomWait(object);
    	if(state)
    	{
		log.info("Project Dashboard opened successfully!");
    	}
    	}
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 	   }
	}
    
    public static void Input(String object){
    	try{
    		log.info("Authenticate User - Entering User Email and Password");
    	boolean state = CustomWait(object);
    	if(state)
    	    { 
    		if(object.equals("email")){
    		  driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.email);
    	    }
    		if(object.equals("password")){
      		  driver.findElement(By.xpath(OR.getProperty(object))).sendKeys(Constants.password);
      	    }
      		}
    	}
    	catch(Exception e)
        {
 		log.error(e.getMessage());
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
    	log.info("Authenticate User - ClickNext!");
    	driver.findElement(By.xpath(OR.getProperty(object))).click();
       }
    	catch(Exception e)
        {
 		log.error(e.getMessage());
 	   }
   	}
    public static void QuitDriver(String object){
    	log.info("Quit Browser");
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
