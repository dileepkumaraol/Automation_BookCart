package org.test.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	WebDriver driver;

	public RegistrationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//button[@mattooltip='Login']")
	private WebElement loginbtn1;
	
	@FindBy(xpath="//button[@class='mdc-button mdc-button--raised mat-mdc-raised-button mat-unthemed mat-mdc-button-base']")
	private WebElement registrationbtn1;
	
	@FindBy(xpath="//input[@formcontrolname='firstname']")
	private WebElement firstname;
	
	@FindBy(xpath="//input[@formcontrolname='lastname']")
	private WebElement lastname;
	
	@FindBy(xpath="//input[@formcontrolname='username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	private WebElement pwd;
	
	@FindBy(xpath="//input[@formcontrolname='confirmPassword']")
	private WebElement cnfpwd;
	
	@FindBy(xpath="//input[@value='Male']")
	private WebElement gender;
	
	@FindBy(xpath="//button[@class='mdc-button mdc-button--raised mat-mdc-raised-button mat-primary mat-mdc-button-base']")
	private WebElement submitbtn;
	
	public WebElement loginbtn1()
	{
		return loginbtn1;
		
	}
	
	public WebElement registrationbtn1()
	{
		return registrationbtn1;
		
	}
	
	public WebElement firstname ()
	{
		return firstname;
		
	}
	
	public WebElement lastname()
	{
		return lastname ;
		
	}
	
		
	public WebElement username()
	{
		return username;
		
	}
	
	public WebElement pwd()
	{
		return pwd;
		
	}
	
	public WebElement cnfpwd ()
	{
		return cnfpwd;
		
	}
	
	public WebElement gender()
	{
		return gender;
		
	}
	
	public WebElement submitbtn()
	{
		return submitbtn;
		
	}
}
