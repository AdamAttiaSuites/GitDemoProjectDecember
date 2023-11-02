package package2;

import static org.hamcrest.CoreMatchers.equalTo;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class TestClass1 {
	
	@Test
	public void getTest() {
		
		baseURI = "https://reqres.in/";
		
		Response getResponse =  given().param("page", "2")
		.auth().none()
		.when().get("/api/users"); 
//		.then().statusCode(200).body("page", equalTo(2))
//		.log().all();
		System.out.println("Time in MilliSeconds is : "+  getResponse.getTime());
		System.out.println("Time in MilliSeconds is : "+getResponse.getTimeIn(TimeUnit.SECONDS));
		
		System.out.println("Time in MilliSeconds is : "+  getResponse.time());
		System.out.println("Time in MilliSeconds is : "+getResponse.timeIn(TimeUnit.SECONDS));
		
	}

}
