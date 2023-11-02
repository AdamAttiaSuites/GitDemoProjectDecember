package package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class ValidatePostRequest {

	public WebDriver driver;
	@Test
	public void dataBasetesting() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("The Driver Was loaded!");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/livesession", "root",
				"Loloissa20@");
		Statement statement = connection.createStatement();
		System.out.println("Statement Got Created!");
		ResultSet result = statement.executeQuery("SELECT * FROM Eployees");
		System.out.println("QuesrruGot Excuted Seccesfully!");
		while (result.next()) {
//			System.out.println(result.getInt("EmpId"));
//			System.out.println(result.getString("LastName"));
//			System.out.println(result.getString("FirstName"));
//			System.out.println(result.getString("Address"));
//			System.out.println(result.getString("City"));
			driver = new ChromeDriver();
			driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
			WebElement userName = driver.findElement(By.id("input-email"));
			userName.sendKeys(result.getString("Lastname"));
			WebElement password = driver.findElement(By.id("input-password"));
			password.sendKeys(result.getString("Firstname"));
			WebElement login = driver.findElement(By.cssSelector("input.btn.btn-primary"));
			login.click();
			

		}
		
		Thread.sleep(3000);
		driver.quit();
		
 
	}

}

//public static void main(String[] args) throws SQLException {
//
//Connection connection = 
//		DriverManager
//		.getConnection("jdbc:mysql://localhost:3306/skilla", "root", "Loloissa20@");
//if(connection.isClosed()) {
//	System.out.println("The Connection is Connected or Established");
//}else {
//	System.out.println("We have Succesfully Connected to database");
//}
//
//}
