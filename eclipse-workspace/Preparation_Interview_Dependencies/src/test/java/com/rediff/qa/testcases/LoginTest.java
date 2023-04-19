package com.rediff.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.junit.Ignore;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.rediff.qa.utils.*;
import com.rediff.qa.testData.SupplyTestData;
import com.rediff.qa.testbase.testBase;

public class LoginTest extends testBase {

	public LoginTest() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver driver;
	public static SoftAssert softAssert = new SoftAssert();

	@BeforeMethod
	public void setup() {
		driver = initializeBrowserAndOpenApplication("chrome");
		driver.findElement(By.className("signin")).click();

	}

	@Test(priority = 1, enabled = false, dataProvider = "RediffDataProviderSupply", dataProviderClass = SupplyTestData.class)
	public void verifyRediffLoginWithValidUsernameAndValidPassword(String username, String password) {

		driver.findElement(By.id("login1")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.className("signinbtn")).click();

		AssertJUnit.assertTrue(driver.findElement(By.className("rd_logout")).isDisplayed());
		softAssert.assertAll();

	}

	@Test(priority = 2, enabled = false)
	public void verifyRediffLoginWithInvalidUsernameAndInvalidPassword() {

		driver.findElement(By.id("login1")).sendKeys(UtilitiesClass.generateDate());
		driver.findElement(By.id("password")).sendKeys(dataProp.getProperty("invalidPassword"));
		driver.findElement(By.className("signinbtn")).click();

		String actualWarningMessage = driver.findElement(By.id("div_login_error")).getText();
		String expectedWarningMessage = dataProp.getProperty("tempIssueWarningmessage");
		AssertJUnit.assertTrue(actualWarningMessage.contains(expectedWarningMessage));
		softAssert.assertAll();
	}

	@Test(priority = 3)
	public void verifyRediffLoginWithValidUsernameAndInvalidPassword() {

		driver.findElement(By.id("login1")).sendKeys(dataProp.getProperty("validUsername"));
		driver.findElement(By.id("password")).sendKeys(dataProp.getProperty("invalisPassword"));
		driver.findElement(By.className("signinbtn")).click();

		String actualWarningMessage = driver.findElement(By.id("div_login_error")).getText();
		String expectedWarningMessage = dataProp.getProperty("wrongCredantialsMessage");
		AssertJUnit.assertTrue(actualWarningMessage.contains(expectedWarningMessage));

		softAssert.assertAll();
	}

	@Test(priority = 4, enabled = false)
	public void verifyRediffLoginWithEmptyUsernameAndValidPassword() {

		driver.findElement(By.id("login1")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.className("signinbtn")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataProp.getProperty("alertUsername");
		AssertJUnit.assertEquals(actualAlertText, expectedAlertText);

		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}

		softAssert.assertAll();

	}

	@Test(priority = 5, enabled = false)
	public void verifyRediffLoginWithCorrectUsernameAndEmptyPassword() {

		driver.findElement(By.id("login1")).sendKeys(prop.getProperty("validUsername"));
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.className("signinbtn")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = dataProp.getProperty("alertPassword");
		AssertJUnit.assertEquals(actualAlertText, expectedAlertText);

		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}

		softAssert.assertAll();
	}

	@Test(priority = 6, enabled = false)
	public void verifyRediffLoginWithEmptyUsernameAndEmptyPassword() {

		driver.findElement(By.id("login1")).sendKeys("");
		driver.findElement(By.id("password")).sendKeys("");
		driver.findElement(By.className("signinbtn")).click();

		Alert alert = driver.switchTo().alert();
		String actualAlertText = alert.getText();
		String expectedAlertText = "Please enter a valid user name";
		AssertJUnit.assertEquals(actualAlertText, expectedAlertText);

		if (actualAlertText.equals(expectedAlertText)) {
			alert.accept();
		} else {
			alert.dismiss();
		}

		softAssert.assertAll();

	}

	@AfterMethod
	public void tearDown() {

		driver.quit();
	}

}
