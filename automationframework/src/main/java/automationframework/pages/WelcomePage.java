package automationframework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automationframework.util.WaitHelper;

public class WelcomePage {
private WebDriver diver;
private WaitHelper waithelper;

@FindBy(css="#container > h1")
private WebElement header;

	public WelcomePage(WebDriver driver)
	{
		this.diver = driver;
		PageFactory.initElements(driver, this);
		waithelper = new WaitHelper(diver);
		waithelper.waitForElementDisplay(header);
		
	}
	
	public String getHeader()
	{
		return header.getText();
	}
	
}
