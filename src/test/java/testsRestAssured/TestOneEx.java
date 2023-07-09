package testsRestAssured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class TestOneEx {
	@Test
	public void test_one() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
		
		System.out.println(response.getBody().asString());
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeader("content-type"));
		
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
		
	}
	
	public void test_two() {
		
		baseURI = "https://reqres.in/api";
		
		given().
		get("/users?page=2").
		then().
		statusCode(200).
		body("x.data[1].id", equalTo(8))
		.log().all();
		
		
		
		
		
		
	}

}
