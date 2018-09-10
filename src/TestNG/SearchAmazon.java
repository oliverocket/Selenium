package TestNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class SearchAmazon {
	
  public WebDriver driver; 
	
  @Test
  public void f() {
	  
		try {
			driver.get("http://www.amazon.com");		
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("furniture");		
			driver.findElement(By.id("twotabsearchtextbox")).submit();
			
			//Scroll down and Click on Sleeper Sofas
			WebElement element2 = driver.findElement(By.name("s-ref-checkbox-3248838011"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
			Thread.sleep(3000);
			element2.click();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
  }
  
  
  @BeforeMethod
  public void beforeMethod() {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.manage().window().maximize();	 
  }

  @AfterMethod
  public void afterMethod() {
	  
	  try {
			Thread.sleep(4000);
			  driver.quit();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

}
