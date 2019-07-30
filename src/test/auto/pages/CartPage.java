package test.auto.pages;

import org.openqa.selenium.WebDriver;
import java.util.List;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage {
	public CartPage() {}
	
	
	public static void AddtoCartItems(WebDriver driver, String productDetails) {
		
		String parentWindow = driver.getWindowHandle();
		
		//all result
		List<WebElement> listResult = driver.findElements(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div"));
		
		System.out.println(listResult.size());
		int i = 0;
		for (WebElement we : listResult)
		{
			i = i + 1;
			//System.out.println(we.getAttribute("data-asin"));
			try{
				WebElement ele = driver.findElement(By.xpath("//*[@id='" + we.getAttribute("data-asin") + "-label']/span/span"));
				if (productDetails.equals(ele.getText()))
				{
					WebElement ele1 = driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div["+i+"]//*/h2/a"));
					JavascriptExecutor executor = (JavascriptExecutor)driver;
					executor.executeScript("arguments[0].click();", ele1);

					//driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div["+i+"]//*/h2/a")).click();

					Thread.sleep(4000);

					//System.out.println(driver.getTitle());

					for (String childTab:driver.getWindowHandles())
					{
						driver.switchTo().window(childTab);
					}

					Thread.sleep(4000);

					System.out.println(driver.getTitle());
					WebDriverWait wait = new WebDriverWait(driver, 20);
					if(!driver.findElements(By.xpath("//*[@id='LDBuybox']/div/div[1]/a/h5/div[1]/span[1]")).isEmpty()){
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='a-autoid-0-announce']"))).click();
					}else{
						wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='add-to-cart-button']"))).click();
					}
					
					driver.close(); 
					Thread.sleep(4000);

					driver.switchTo().window(parentWindow);
				}
			}catch(Exception e){ 
					//e.printStackTrace(); 
			}			
		}
	}//Method End
	
	public static void ViewCart(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("nav-cart"))).click();
	}
	
}
