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


public class contentValidation extends base {
	public static Logger Log=LogManager.getLogger(base.class.getName());
	landingPage obj;
	@BeforeTest
	public void initialize() throws IOException{
		driver=initializeDriver();
		Log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		Log.info("navigated to home page");
	}
	
	@Test
	public void contentValidationNavigation() throws IOException	
	{	obj=new landingPage(driver);	 
		System.out.println(obj.getcontent().getText());	
		Assert.assertEquals(obj.getcontent().getText(), "FEATURED COURSES");
		System.out.println("successfully validated content message in content validation");
	}
	@Test
	public void contentValidation1Navigation() throws IOException	
	{
		obj=new landingPage(driver);
		System.out.println(obj.getheadbar().getText());	
		Assert.assertEquals(obj.getheadbar().getText(), "CONTACT");
		System.out.println("successfully validated headbar message");
	}
	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}
	
}
