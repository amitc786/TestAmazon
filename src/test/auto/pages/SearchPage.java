package test.auto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {
	public SearchPage() {}
	
	public static void SearchProduct(WebDriver driver, String productName)
	{
		//find search input box and enter value 'headphones'  and press enter.
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys(productName);

		search.sendKeys(Keys.ENTER);
	}
}
