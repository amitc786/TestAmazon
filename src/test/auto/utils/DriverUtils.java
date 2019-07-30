package test.auto.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {
	 
 public static  WebDriver driver;
	
 public static WebDriver getDriver() {
	try { 
		System.setProperty("webdriver.chrome.driver",".//chromedriver//chromedriver.exe");
	        
	 	if ( driver == null) {
	
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        
	    }
	    return driver;
	}catch(Exception e)
	{
		e.printStackTrace();
		return null;
	}
 }
	
 public static void quitDriver() {
	 try{
		 driver.close();
		 driver.quit();
	 }catch(Exception e)
	 {
		 e.printStackTrace();
		 
	 }
 }
 
 public static void waitForLoad(WebDriver driver) {
	 try {
	     ExpectedCondition<Boolean> pageLoadCondition = new
	             ExpectedCondition<Boolean>() {
	                 public Boolean apply(WebDriver driver) {
	                     return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
	                 }
	             };
	     WebDriverWait wait = new WebDriverWait(driver, 30);
	     wait.until(pageLoadCondition);
	 }catch(Exception e)
	 {
		 e.printStackTrace();
	 }
 }
 
 
 
}
