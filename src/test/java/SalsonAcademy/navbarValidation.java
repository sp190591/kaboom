package SalsonAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pageObjects.landingPage;
import resources.base;

public class navbarValidation extends base{
	public static Logger Log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException{
		driver=initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void navigationbarValidation() throws IOException	
	{		
		landingPage obj=new landingPage(driver);
		System.out.println(obj.getcontent().getText());	
		Assert.assertTrue(obj.getnavbar().isDisplayed());
		Log.info("successfully validated navbar");
	}
	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
}
