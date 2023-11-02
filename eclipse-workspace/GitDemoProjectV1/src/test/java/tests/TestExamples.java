package tests;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
//import static io.restassured.RestAssured.baseURI;


public class TestExamples {
	
	@Test(enabled = false)
	public void test_1() {
		
		
	    Response response = 
	    		get("https://reqres.in/api/users?page=2");
	    System.out.println(response.getStatusCode());
	    System.out.println(response.getTime());
	    System.out.println(response.getBody().asString());
	    System.out.println(response.getStatusLine());
	    int statusCode = response.getStatusCode();
	    System.out.println(response.getHeader("content-type"));
	    int expectedValue = 200;
		Assert.assertEquals(statusCode, expectedValue);
		
	}
	
	@Test(enabled = false)
	public void Test_2() {
		
		baseURI = "https://reqres.in/";
		
		given().get("/api/users?page=2").
		then().statusCode(200).
		body("data[4].first_name", equalTo("George")).
		body("data.first_name", hasItems("Tobias","Byron"));
	}
	
	@Test
	public void testPost() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("name", "Adam");
//		map.put("job", "Teacher");
//		System.out.println(map);
		
		JSONObject request = new JSONObject();
		request.put("name", "Adam");
		request.put("job", "Teacher");
		
		baseURI = "https://reqres.in/";
		given().header("Content-Type","application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON)
		.body(request.toJSONString()).
		when().post("/api/users").
		then().statusCode(201).log().all();
		
		
	}

}
