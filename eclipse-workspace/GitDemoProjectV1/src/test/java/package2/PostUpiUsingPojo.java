package package2;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;
public class PostUpiUsingPojo {
	
	@Test
	public static void main(String[] args) {
		
		EmployeePojo ep = new EmployeePojo("morpheus", "leader", 
				new String[] {"Java", "C"}, "Comcast", "AdamAtt@Gmail.com");
		
		
				given().auth().none().
				header("Content-Type", "application/json").
				contentType(ContentType.JSON).when().
				body(ep).log().all().
				post("https://reqres.in/api/users");
				
	}

}
