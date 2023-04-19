package com.rediff.qa.trial;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.rediff.qa.testData.SupplyTestData;

public class TutorialsNinjaClassDataProvider {
	
	public WebDriver driver;

	@Test(priority = 1, dataProvider = "RediggExcelData", dataProviderClass = SupplyTestData.class)
	public void gettoLogInString(String username, String  password) throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).sendKeys(password);
		driver.findElement(By.cssSelector("input.btn.btn.btn-primary")).click();
		
		Thread.sleep(2000);
		driver.quit();

	}

}
