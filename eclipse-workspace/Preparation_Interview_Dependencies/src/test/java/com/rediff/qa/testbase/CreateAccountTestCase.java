package com.rediff.qa.testbase;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rediff.qa.utils.UtilitiesClass;

public class CreateAccountTestCase extends testBase {

	public CreateAccountTestCase() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public static SoftAssert softAssert = new SoftAssert();
	public Select select;

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication("chrome");
		driver.findElement(By.linkText("Create Account")).click();
		//
	}

	@Test(priority = 1)
	public void EnterAllCredantials() throws InterruptedException {

		driver.findElement(By.xpath("//input[starts-with(@name,'name')]")).sendKeys(dataProp.getProperty("fullName"));
		driver.findElement(By.xpath("//input[starts-with(@name,'login')]")).sendKeys(UtilitiesClass.generateNameForEmailWithTimeStamp());
		driver.findElement(By.xpath("//input[starts-with(@name,'btnchkavail')]")).click();
		String actualTextValidation = driver.findElement(By.xpath("//div[@id='check_availability']")).getText();
		String expectedTextValidation = dataProp.getProperty("successAvailabilityIDMessage");
		AssertJUnit.assertTrue(actualTextValidation.contains(expectedTextValidation));
		Thread.sleep(2000);
		driver.findElement(By.xpath(" //input[starts-with(@name,'passwd')]")).sendKeys(dataProp .getProperty("createPassword"));
		driver.findElement(By.xpath("//input[starts-with(@name,'confirm_passwd')]")).sendKeys(dataProp.getProperty("retypeSeleniumPassword"));
		driver.findElement(By.xpath("//input[starts-with(@name,'altemail')]")).sendKeys(dataProp.getProperty("alternateEmail"));
		driver.findElement(By.xpath("//input[starts-with(@name,'mobno')]")).sendKeys(dataProp.getProperty("phoneNumber"));

		select = new Select(driver.findElement(By.xpath(" //select[starts-with(@name,'DOB_Day')]")));
		select.selectByVisibleText("26");

		select = new Select(driver.findElement(By.xpath(" //select[starts-with(@name,'DOB_Month')]")));
		select.selectByVisibleText("APR");

		select = new Select(driver.findElement(By.xpath(" //select[starts-with(@name,'DOB_Year')]")));
		select.selectByVisibleText("1990");

		driver.findElement(By.xpath(" //input[@value='m']")).click();

		select = new Select(driver.findElement(By.xpath(" //select[starts-with(@name,'country')]")));
		select.selectByVisibleText("United States");
		driver.findElement(By.className("captcha")).sendKeys("ABCD");
		driver.findElement(By.id("Register")).click();

		String actualMessageCreateAccountFailure = driver.findElement(By.className("errbody")).getText();
		String expectedMessageCreateAccountFailure = dataProp.getProperty("failRegestrationMessage");
		AssertJUnit.assertTrue(actualMessageCreateAccountFailure.contains(expectedMessageCreateAccountFailure));
		softAssert.assertAll();

	}

	
	
	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

}
