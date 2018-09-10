package TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NewTest {
	
  public WebDriver driver; 
  @Test
  public void f() {
		//Open Convergence 
		driver.get("http://www.google.com");
		
		driver.findElement(By.name("q")).sendKeys("Interamerican development bank");
		
		driver.findElement(By.name("q")).submit();
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
		Thread.sleep(1000);
		  driver.quit();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

}
