package day1;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;

public class HTTPrequest {
	
	int id;
	
	
	@Test(priority=1)
	void getuser() {
		
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();

	}
	
	@Test(priority=2)
	void createuser() {
		
		HashMap hp = new HashMap();
		hp.put("name", "Sabari");
		hp.put("Job", "Manager");
		
		id=given()
			.contentType("application/json")
			.body(hp)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
	//	.then()
		//	.statusCode(201)
		//	.log().all();
	}
	
	@Test(priority=3, dependsOnMethods = {"createuser"})
	void update() {
			HashMap hp = new HashMap();
		hp.put("name", "Sabari");
		hp.put("Job", "BEA");
		
		given()
			.contentType("application/json")
			.body(hp)
		
		.when()
			.put("https://reqres.in/api/users/"+id)
		
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	@Test(priority=4, dependsOnMethods = {"update"})
	void deleteuser(){
		
		given()
		
		.when()
			.delete("https://reqres.in/api/users/"+id)
			
		.then()
			.statusCode(204)
			.log().all();
			
		
	}

}
