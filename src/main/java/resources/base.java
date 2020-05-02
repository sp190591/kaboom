package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException { // to initialize a driver we created a method
		prop = new Properties();
		//System.getProperty("user.dir")
		/*FileInputStream fis = new FileInputStream(
				"C:\\Users\\Salson\\End2endFramework\\src\\main\\java\\resources\\data.properties");*/
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");

		prop.load(fis);
		String browserName = System.getProperty("browser");// used to control browser property using maven command mvn test -Dbrowser=chrome 
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);

		if (browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Salson\\Downloads\\chromedriver.exe");
			
			if (browserName.contains("headless")){
				ChromeOptions opt=new ChromeOptions();
				opt.addArguments("headless");
				driver = new ChromeDriver(opt);				
			}
			else			
			driver = new ChromeDriver();

		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Salson\\Downloads\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Salson\\Downloads\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public void getScreenshot(String result) throws IOException {
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://test//screenshot.png"));
		//FileHandler.copyFile(src, new File("C://test//screenshot.png"));

	}

}
