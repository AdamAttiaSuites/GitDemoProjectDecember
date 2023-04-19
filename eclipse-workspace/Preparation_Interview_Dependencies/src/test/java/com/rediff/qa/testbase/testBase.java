package com.rediff.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.rediff.qa.utils.UtilitiesClass;

public class testBase {
	public WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	public FileInputStream ip;
	public ChromeOptions options;
	public testBase() throws Exception {
		 prop = new Properties();
		String projectPath = System.getProperty("user.dir");
		 ip = new FileInputStream(projectPath+"/src/test/java/com/rediff/qa/config/config.properties");
		prop.load(ip);
		
		dataProp = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir") 
					+ "/src/test/java/com/rediff/qa/testData/testData.properties");
		dataProp.load(ip);
	}

	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			options = new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//options.addArguments("--start-maximized");
			//options.addArguments("--incognito");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilitiesClass.implicitWait));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilitiesClass.pageLoadWait));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(UtilitiesClass.scriptTimeLoad));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
