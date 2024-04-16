package org.objectrepositary;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.test.automation.AddtoCart;
import org.test.automation.LoginPage;
import org.test.automation.RegistrationPage;
import org.test.automation.UpdateCart;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	WebDriver driver;
	ExtentReports extent;
	
	@BeforeMethod
	public void configuration() {
		String reportPath=System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter er=new ExtentSparkReporter(reportPath);
		er.config().setReportName("Book Cart Report");
		er.config().setDocumentTitle("Book Cart Report Document");
		extent=new ExtentReports();
		extent.attachReporter(er);
		extent.setSystemInfo("Operating System", "Windows 10");
		extent.setSystemInfo("Tested by", "Dileep Kumar");
	}

	@Test
	public void login() throws InterruptedException {
		ExtentTest test1 = extent.createTest("Test case executing");
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		test1.info("Chrome Browser Executed");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://bookcart.azurewebsites.net/");
		test1.info("Book Cart Website lauched");
		RegistrationPage registration = new RegistrationPage(driver);
		registration.loginbtn1().click();
		registration.registrationbtn1().click();
		registration.firstname().sendKeys("Shan");
		registration.lastname().sendKeys("vika");
		registration.username().sendKeys("Shanvika");
		registration.pwd().sendKeys("Vika0808k");
		registration.cnfpwd().sendKeys("Vika0808k");
		registration.gender().click();
		Actions action=new Actions(driver);
		Thread.sleep(2000);
		action.click(registration.submitbtn()).perform();
		test1.info("Registration Page executed");
		
		Thread.sleep(3000);
		
		LoginPage login=new LoginPage(driver);
		login.username().sendKeys("Shanvika");
		login.password().sendKeys("Vika0808k");
		login.submit2().click();
		test1.info("Login Page executed");
		
		Thread.sleep(3000);
		test1.info("AddtoCart Page executed");
		AddtoCart ac=new AddtoCart(driver);
		ac.iteratecart();
		ac.calculatetotalprice1();
		
		test1.info("UpdateCart Page executed");
		UpdateCart uc=new UpdateCart(driver);
		uc.adding_item().click();
		uc.deleting_item().click();
		uc.calculatetotalprice2();
		uc.deducting_item().click();

	}

	@AfterMethod
	public void closure() {
		driver.quit();
		extent.flush();
	}
}


