package org.objectrepositary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.test.automation.AddtoCart;
import org.test.automation.LoginPage;
import org.test.automation.RegistrationPage;
import org.test.automation.UpdateCart;
import org.testng.annotations.AfterMethod;
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
	/*	registration.registrationbtn1().click();
		registration.firstname().sendKeys("Raji");
		registration.lastname().sendKeys("Kumari");
		registration.username().sendKeys("RajaKumari");
		registration.pwd().sendKeys("Sanmugai1");
		registration.cnfpwd().sendKeys("Sanmugai1");
		registration.gender().click();
		registration.submitbtn().submit();  */
		
		LoginPage login=new LoginPage(driver);
		login.username().sendKeys("RajaKumari");
		login.password().sendKeys("Sanmugai1");
		login.submit2().click();
		
		Thread.sleep(3000);
		
		AddtoCart ac=new AddtoCart(driver);
		ac.iteratecart();
		ac.calculatetotalprice1();
		
		UpdateCart uc=new UpdateCart(driver);
		uc.adding_item().click();
		uc.deleting_item().click();
		uc.calculatetotalprice2();
		uc.deducting_item().click();

	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}
}

