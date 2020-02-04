package automationframework.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitHelper {
	private int timeout = 30;
	private WebDriverWait wait;
	
	public WaitHelper(WebDriver webdriver,int timeout)
	{
		wait = new WebDriverWait(webdriver,timeout);	
	}
	
	public WaitHelper(WebDriver webdriver) {
		wait = new WebDriverWait(webdriver,timeout);
	}
	public void waitForElementDisplay(WebElement element)
	{
		wait.until(ExpectedConditions.visibilityOf(element)); 
	}
	
	public void waitForElementClick(WebElement element)
	{
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public void setTimeout(int timeout)
	{
		this.timeout = timeout;
	}
	
}
