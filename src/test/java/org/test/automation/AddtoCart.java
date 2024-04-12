package org.test.automation;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddtoCart {

	WebDriver driver;

	public AddtoCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void iteratecart() {
		List<WebElement> categories = driver.findElements(By.xpath("//mat-list-item[@routerlink='/filter']//a"));

		int size = categories.size();
		
		System.out.println(size);

		for (int i = 1; i <=size; i++) {

			String xpathText = "(//mat-list-item[@routerlink='/filter']//a)[" + i + "]";
			driver.findElement(By.xpath(xpathText)).click();
			WebElement firstBook = driver.findElement(By.xpath("(//mat-card[contains(@class,'book-card')]//span[@class='mdc-button__label'])[1]"));
			firstBook.click();
//			WebElement addToCartButton = driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[1]"));
//			addToCartButton.click();
			driver.navigate().back();
		}
	}

	public void calculatetotalprice() {
		driver.navigate().refresh();

		WebElement cartOption = driver.findElement(By.xpath("//button[@*='/shopping-cart']"));
		cartOption.click();

		List<WebElement> prices = driver.findElements(By.xpath("//td[contains(@class,'cdk-column-total')]"));

		double totalPrice = 0;

		for (WebElement price : prices) {

			String priceText = price.getText().trim().replace("₹", "").replace(",", ""); // "123.00"
			double priceValue = Double.parseDouble(priceText);
			totalPrice = totalPrice + priceValue;

		}

		WebElement cartTotalPrice = driver.findElement(By.xpath("(//strong[text()='Cart Total:']/following::strong)[1]"));
		String cartTotalPriceText = cartTotalPrice.getText().trim().replace("₹", "").replace(",", "");
		double caretTotalPriceValue = Double.parseDouble(cartTotalPriceText);

		Assert.assertEquals(totalPrice, caretTotalPriceValue);
	}

//	@FindBy(xpath = "//mat-list-item[@routerlink='/filter']//a")
//	private WebElement categories;
//
//	public List<WebElement> categories() {
//		return (List<WebElement>) categories;
//	}
}
