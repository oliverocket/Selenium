package firstPackage;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateOperation {
	
	static Date date = new Date();
	static ZephirTest ThisTest = new ZephirTest();
	static int stepCounter = 0; 
	
	public static void main(String[] args) {
		ThisTest.InitCreateOperation();		
		
		try {
			
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver.exe");		
			WebDriver driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
			//Open Convergence 
			driver.get("http://testcnvg.iadb.org/");
			stepCounter++;
			
			//Click on New Operation
			Thread.sleep(1000);
			driver.switchTo().frame(driver.findElement(By.name("someFrame")));
			driver.findElement(By.linkText("New Operation")).click();
			stepCounter++;
			
			//Click on Operation Type 
			driver.findElement(By.id("id-operationType")).click();			
			driver.findElement(By.linkText("ACT - Activities")).click();
			stepCounter++;
			
			//Operation Type * Operation Year 
			driver.findElement(By.id("id-operationYear0000000")).click();			
			driver.findElement(By.linkText("2018")).click();
			stepCounter++;
			
			//Country
			driver.findElement(By.id("id-country")).click();			
			driver.findElement(By.linkText("PARAGUAY")).click();
			stepCounter++;
			
			//MBF Code
			Thread.sleep(2000);
			driver.findElement(By.id("id-mbfCode")).click();			
			driver.findElement(By.linkText("A0502 - Private Sector Operations")).click();
			stepCounter++;
			
			//Sector
			driver.findElement(By.id("id-sector")).click();			
			driver.findElement(By.linkText("ENERGY")).click();
			
			//Sub Sector
			Thread.sleep(2000);
			driver.findElement(By.id("id-subSector")).click();			
			driver.findElement(By.linkText("RURAL ELECTRIFICATION")).click();
			stepCounter++;
			
			//Activity Modality 
			driver.findElement(By.id("id-ActivityModality")).click();			
			driver.findElement(By.linkText("Capital Markets")).click();
			stepCounter++;
			
			
			//Spanish Description
			WebElement element2 = driver.findElement(By.name("operationNameEnglish"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
			element2.sendKeys("This is a text sent with Selenium Webdriver on " + date);
			stepCounter++;
			
			//Spanish Description 
			driver.findElement(By.cssSelector("li[dd-lang=\"es\"]")).click();			
			driver.findElement(By.name("operationNameSpanish")).sendKeys("Espaniol: Este es un texto enviado por Selenium Webdriver en " + date);			
			
			Thread.sleep(5000);
			driver.quit();
			
			ThisTest.TestSucceded();			

			
		} catch (Exception  e) {

			ThisTest.SetStepAsFail(stepCounter,"Error");
			e.printStackTrace();			
		}
	}

}
