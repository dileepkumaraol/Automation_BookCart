package org.test.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class UpdateCart {
	WebDriver driver;

	public UpdateCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// adding one more quantity to the cart
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/app-shoppingcart[1]/mat-card[1]/mat-card-content[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[3]/button[1]")
	private WebElement adding_item;

	// deleting one product to the cart
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/app-shoppingcart[1]/mat-card[1]/mat-card-content[1]/table[1]/tbody[1]/tr[2]/td[6]/button[1]/span[4]")
	private WebElement deleting_item;

	// deducting one product to the cart
	@FindBy(xpath = "//body[1]/app-root[1]/div[1]/app-shoppingcart[1]/mat-card[1]/mat-card-content[1]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/div[1]/button[1]")
	private WebElement deducting_item;

	public WebElement adding_item() throws InterruptedException {
		Thread.sleep(2000);
		return adding_item;
	}

	public WebElement deleting_item() throws InterruptedException {
		Thread.sleep(2000);
		return deleting_item;
	}
	
	public WebElement deducting_item() throws InterruptedException {
		Thread.sleep(2000);
		return deducting_item;
	}

	public void calculatetotalprice2() {
		driver.navigate().refresh();

		WebElement cartOption = driver.findElement(By.xpath("//button[@*='/shopping-cart']"));
		cartOption.click();

		List<WebElement> prices = driver.findElements(By.xpath("//td[contains(@class,'cdk-column-total')]"));

		double totalPrice = 0;

		for (WebElement price : prices) {

			String priceText = price.getText().trim().replace("₹", "").replace(",", "");
			double priceValue = Double.parseDouble(priceText);
			totalPrice = totalPrice + priceValue;

		}

		WebElement cartTotalPrice = driver
				.findElement(By.xpath("(//strong[text()='Cart Total:']/following::strong)[1]"));
		String cartTotalPriceText = cartTotalPrice.getText().trim().replace("₹", "").replace(",", "");
		double caretTotalPriceValue = Double.parseDouble(cartTotalPriceText);

		Assert.assertEquals(totalPrice, caretTotalPriceValue);
	}

}
