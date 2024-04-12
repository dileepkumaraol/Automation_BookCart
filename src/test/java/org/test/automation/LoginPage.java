package org.test.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	public LoginPage (WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@formcontrolname='username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@formcontrolname='password']")
	private WebElement password;
	
	@FindBy(xpath = "//span[text()='Login']")
	private WebElement submit2;

	public WebElement username() {
		return username;
	}
	
	public WebElement password() {
		return password;
	}
	
	public WebElement submit2() {
		return submit2;
	}
}
