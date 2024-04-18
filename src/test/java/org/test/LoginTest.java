package org.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pageobjects.AddtoCart;
import pageobjects.LoginPage;
import pageobjects.RegistrationPage;
import pageobjects.UpdateCart;
import resources.Base;

public class LoginTest extends Base {
	
	WebDriver driver;
	Logger log;


	@BeforeClass
	public void configuration() throws IOException {
		driver=initializeBrowser();
//		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
//		log.debug("Navigated to application URL");
		}
	
	@Test(priority=1)
	public void registration() throws InterruptedException, IOException {
//	    test1.info("Book Cart Website lauched"); 
		
		log = LogManager.getLogger(LoginTest.class.getName());
	    RegistrationPage registration = new RegistrationPage(driver);
		registration.loginbtn1().click();
		registration.registrationbtn1().click();
		log.debug("Clicked on Registration Page");
		registration.firstname().sendKeys("Dileep1");
		log.debug("Entered First Name");
		registration.lastname().sendKeys("Kumar1");
		log.debug("Entered last Name");
		registration.username().sendKeys("dk1@gmail.com");
		log.debug("Entered user Name");
		registration.pwd().sendKeys("Abcd@12346");
		log.debug("Entered password");
		registration.cnfpwd().sendKeys("Abcd@12346");
		log.debug("Entered confirm password");
		
		registration.gender().click();
		log.debug("clicked gender");
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.click(registration.submitbtn()).perform();
		log.debug("Entered all fields and clicked submit button");
//		test1.info("Registration Page executed");
	}

	@Test(priority=2)
	public void login() throws InterruptedException {
		Thread.sleep(3000);
		
		LoginPage login=new LoginPage(driver);
		login.username().sendKeys("dk1@gmail.com");
		log.debug("username entered");
		login.password().sendKeys("Abcd@12346");
		log.debug("password entered");
		login.submit2().click();
//		test1.info("Login Page executed");
		
		Thread.sleep(3000);
//		test1.info("AddtoCart Page executed");
		AddtoCart ac=new AddtoCart(driver);
		ac.iteratecart();
		log.debug("Books added in cart");
		ac.calculatetotalprice1();
		log.debug("Books Price checked in Add to Cart");
		
//		test1.info("UpdateCart Page executed");
		UpdateCart uc=new UpdateCart(driver);
		uc.adding_item().click();
		log.debug("added one quatitiy");
		uc.deleting_item().click();
		log.debug("deleted one quatitiy");
		uc.calculatetotalprice2();
		log.debug("Books Price checked in update to Cart");
		uc.deducting_item().click();
		log.debug("deducting one quatitiy");
	}

	@AfterClass
	public void closure() {
		driver.quit();
//		extent.flush();
	}
	
//	public Object[][] getLoginData() {
//		Object[][] data= {{"Shanvika","Vika0808k"},{"dileepkumar","Ram12365@a"}};
//		return data;
//	}
	
	
	
}
