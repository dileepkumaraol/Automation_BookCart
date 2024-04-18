package stepdefinitions;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.LoginPage;

public class Login {

	WebDriver driver;
	LoginPage login;

	@Before
	public void openBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();

	}

	@Given("^Open any Browser$")
	public void Open_any_Browser() throws IOException {
		driver.get("https://bookcart.azurewebsites.net/login");
		

	}

	@And("^Navigate to Login page$")
	public void Navigate_to_Login_page() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
	public void User_enters_username_as_something_and_password_as_something_into_the_fields(String username, String password) {
		login = new LoginPage(driver);
		login.username().sendKeys(username);
		login.password().sendKeys(password);
	}

	@And("^User clicks on Login button$")
	public void User_clicks_on_Login_button() {
		Actions actions = new Actions(driver);
		actions.moveToElement(login.submit2()).click().perform();
		
	}
	
	@Then("^Verify user is able to successfully login$")
	public void Verify_user_is_able_to_successfully_login()
	{
		WebElement element = driver.findElement(By.xpath("//span[text()=' dileepkumar']"));
		String actual = element.getText();
		String expected="dileepkumar";
		if(actual.equalsIgnoreCase(expected))
			System.out.println("Login Sucessfully");
		else
			System.out.println("Login Failed");
	}
	
	@After
	public void closeBrowser() {
		driver.quit();

	}

}
