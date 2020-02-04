package automationframework.logintest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import automationframework.pages.LoginPage;
import automationframework.pages.WelcomePage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class LoginTest {
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();

	}
	@Test
	public void loginTest()
	{
		LoginPage loginpage = new LoginPage(driver).get();
		WelcomePage welcomePage = loginpage.login("demo", "mode");
		Assert.assertEquals("Welcome Page", welcomePage.getHeader());
		//driver.get("http://www.google.com");
	}
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}

}
