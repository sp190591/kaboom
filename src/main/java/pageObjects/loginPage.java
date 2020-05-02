package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	public WebDriver drive;
	private By email = By.xpath("//input[@id='user_email']");
	private By password = By.xpath("//input[@id='user_password']");
	private By submit = By.xpath("//input[@name='commit']");

	public loginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		drive = driver;
	}

	public WebElement getemail() {

		return drive.findElement(email);
	}

	public WebElement getpassword() {

		return drive.findElement(password);
	}

	public WebElement getsubmit() {

		return drive.findElement(submit);
	}

}
