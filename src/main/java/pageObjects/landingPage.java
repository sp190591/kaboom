package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingPage {
	public WebDriver drive;

	private By signin = By.xpath("//span[contains(text(),'Login')]");
	private By content = By.xpath("//h2[contains(text(),'Featured Courses')]");
	private By navbar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	private By Header=By.xpath("//a[contains(text(),'Contact')]");

	public landingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		drive = driver;
	}

	public WebElement getLogin() {

		return drive.findElement(signin);
	}

	public WebElement getcontent() {

		return drive.findElement(content);
	}
	public WebElement getnavbar() {

		return drive.findElement(navbar);
	}
	public WebElement getheadbar() {

		return drive.findElement(Header);
	}

}
