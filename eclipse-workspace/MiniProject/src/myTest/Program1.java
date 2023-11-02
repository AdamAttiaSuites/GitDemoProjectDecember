package myTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v111.audits.model.HeavyAdIssueDetails;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Program1 {
	
	public WebDriver driver;
	@BeforeMethod
	public void setUp() {
	
		driver = new ChromeDriver();
		driver.get("https://amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	
	@Test(priority = 1)
	public void VerifyTitle() {
		
	String actualTitle =  driver.getTitle();
	String expectedTitle = "Amazon.com. Spend less. Smile more.";
	Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2)
	public void verifylogo() {
		
		WebElement logo = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']"));
		Assert.assertTrue(logo.isDisplayed());
	}

	@AfterMethod
	public void tearDowb() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.quit();
	}
}
