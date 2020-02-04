package automationframework.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import automationframework.util.WaitHelper;

public class LoginPage extends LoadableComponent<LoginPage> {

	private WebDriver webdriver;
	private WaitHelper waithelper;
	private static final String URL ="http://localhost:7272/" ;
	private static final String HEADER ="Login Page";
	
	@FindBy(xpath="//*[@id='container']/h1")
	private WebElement header;
	@FindBy(id="username_field")
	private WebElement usernameField;
	@FindBy(id="password_field")
	private WebElement passwordField;
	@FindBy(id="login_button")
	private WebElement loginbutton;
	

	
	public LoginPage(WebDriver webdriver)
	{
		this.webdriver = webdriver;
		PageFactory.initElements(webdriver, this);
		waithelper = new WaitHelper(webdriver);
		
	}
	public WelcomePage login(String username,String password)
	{
		waithelper.waitForElementClick(loginbutton);
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginbutton.click();
		return new WelcomePage(webdriver);
	}
	
	
	@Override
	protected void load() {
		webdriver.get(URL);
	}

	@Override
	protected void isLoaded() throws Error {
		String url = webdriver.getCurrentUrl();
		Assert.assertEquals(URL, url);
		
	}

}
