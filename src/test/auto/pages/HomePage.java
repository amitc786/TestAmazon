package test.auto.pages;

import org.openqa.selenium.WebDriver;

import test.auto.utils.DriverUtils;

public class HomePage {

	public HomePage() {}
	
	public static void openHomePage(WebDriver driver, String URL)
	{
		//Open website
		driver.get(URL);
		
		//will wait for 30 seconds to ready with page.
		DriverUtils.waitForLoad(driver);

	}
}
