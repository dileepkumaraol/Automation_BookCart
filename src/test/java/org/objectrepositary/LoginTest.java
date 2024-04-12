package org.objectrepositary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.automation.AddtoCart;
import org.test.automation.LoginPage;
import org.test.automation.RegistrationPage;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;

	@Test
	public void login() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://bookcart.azurewebsites.net/");

		RegistrationPage registration = new RegistrationPage(driver);
		registration.loginbtn1().click();
//		registration.registrationbtn1().click();
//		registration.firstname().sendKeys("Raja16");
//		registration.lastname().sendKeys("Kumaran16");
//		registration.username().sendKeys("RajaKumaran16");
//		registration.pwd().sendKeys("Sanmugan6");
//		registration.cnfpwd().sendKeys("Sanmugan6");
//		registration.gender().click();
//		registration.submitbtn().submit();
//		registration.submitbtn().submit();
		
		//Thread.sleep(3000);
		
		LoginPage login=new LoginPage(driver);
		login.username().sendKeys("RajaKumaran16");
		login.password().sendKeys("Sanmugan6");
		login.submit2().click();
	
		AddtoCart ac=new AddtoCart(driver);
		ac.iteratecart();
		ac.calculatetotalprice();
		

	}

//	@AfterMethod
//	public void closure() {
//		driver.close();
//	}
}
