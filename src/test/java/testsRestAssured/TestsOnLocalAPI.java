package testsRestAssured;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class TestsOnLocalAPI {
	//@Test
	public void get() {
		
		baseURI = "http://localhost:3000";
		given().get("/users").then().statusCode(200).log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void post() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("id", 5);
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.post("/users/")
		.then()
		.statusCode(500)
		.log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void put() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Thomas");
		request.put("lastName", "Edison");
		request.put("id", 5);
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.put("/users/2")
		.then()
		.statusCode(404)
		.log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void patch() {
		
		JSONObject request = new JSONObject();
		
		request.put("firstName", "Albert");
		request.put("lastName", "Einstein");
		request.put("id", 3);
		
		baseURI = "http://localhost:3000";
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(request.toJSONString())
		.when()
		.patch("/users/")
		.then()
		.statusCode(404)
		.log().all();
		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void delete() {
		
		baseURI = "http://localhost:3000";
		
		given()
		.when()
		.delete("/users/2")
		.then()
		.statusCode(404)
		.log().all();
		
	}

}
