package SalsonAcademy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.landingPage;
import pageObjects.loginPage;
import resources.base;

public class HomePage extends base{
	public static Logger Log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException{
		driver=initializeDriver();
		Log.info("driver is initialised");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password,String text) throws IOException, InterruptedException
	
	{
		driver.get(prop.getProperty("url"));
		landingPage obj=new landingPage(driver);
		obj.getLogin().click();
		loginPage obj1=new loginPage(driver);
		obj1.getemail().sendKeys(Username);
		obj1.getpassword().sendKeys(Password);
		Log.info(text);
		obj1.getsubmit().click();
		
	}
	@DataProvider
	public Object[][] getData(){
		Object[][] data=new Object[2][3];// row=how many times column=how many values per each test
		data[0][0]="hello@gmail.com";
		data[0][1]="123456";
		data[0][2]="restricted user";
		
		data[1][0]="hi@gmail.com";
		data[1][1]="123456";
		data[1][2]="nonrestricted user";
		return data;
	}
	@AfterTest
	public void teardown(){
		driver.close();
		driver=null;
	}

}
