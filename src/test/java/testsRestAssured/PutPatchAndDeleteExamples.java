package testsRestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PutPatchAndDeleteExamples {
	
	@SuppressWarnings("unchecked")
	@Test
	public void testPut() {

		
		JSONObject req = new JSONObject();
		
		req.put("name", "Warren");
		req.put("job", "Solutions Architect");
		
		System.out.println(req.toJSONString());
		
		baseURI = "https://reqres.in/api";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		put("/users/2").
		then().
		statusCode(200)
		.log().all();
			
	}
	@Test
	@SuppressWarnings("unchecked")
	public void testPatch() {

		
		JSONObject req = new JSONObject();
		
		req.put("name", "Warren");
		req.put("job", "Solutions Architect");
		
		System.out.println(req.toJSONString());
		
		baseURI = "https://reqres.in";
		
		given().
		header("Content-Type","application/json").
		contentType(ContentType.JSON).
		accept(ContentType.JSON).
		body(req.toJSONString()).
		when().
		patch("/api/users/2").
		then().
		statusCode(200)
		.log().all();
		
		
	}
	@Test
	public void testDelete() {
		
		baseURI = "https://reqres.in";
		
		when().
		delete("/api/users/2").
		then().
		statusCode(204)
		.log().all();
		
		
	}

}
