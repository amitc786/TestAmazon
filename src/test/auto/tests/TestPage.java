package test.auto.tests;

import org.openqa.selenium.WebDriver;

import test.auto.pages.CartPage;
import test.auto.pages.HomePage;
import test.auto.pages.SearchPage;
import test.auto.utils.DriverUtils;

public class TestPage {
	
	public static String URL = "https://www.amazon.in/";
	public static String ProductName = "books";
	
	
	public static void main(String[] args) {
		try {
			WebDriver driver;
			
			driver = DriverUtils.getDriver();
	
			HomePage.openHomePage(driver, URL);			
			
			SearchPage.SearchProduct(driver, ProductName);
			
			CartPage.AddtoCartItems(driver, "Best seller");
			
			CartPage.ViewCart(driver);			
			
			Thread.sleep(5000);		
		
			DriverUtils.quitDriver();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
