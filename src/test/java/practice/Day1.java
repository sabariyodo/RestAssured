package practice;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;


public class Day1 {
	
	int id;
	
	@Test
	public void listusers (){
		
		given()
		.pathParam("mypath","users")
		.queryParam("page", 2)
		.when()
			.get("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.log().all();			
	}
	
	//hashmap method
	//@Test
	void createuser() {
		
		HashMap hp = new HashMap();
		hp.put("name", "sabari");
		hp.put("job", "BEA");
		
		given()
		
		.contentType("application/json")
		.body(hp)
		.pathParam("mypath","user")
		
		
		.when()
		.post("https://reqres.in/api/{mypath}")
		
		.then()
			.statusCode(201);
	}
	
	//org.json method
		@Test
		void createusers() {
			
			JSONObject hp = new JSONObject();
			hp.put("name", "sabari");
			hp.put("job", "BEA");
			
			
			given()
			
			.contentType("application/json")
			.body(hp)
			.pathParam("mypath","user")
			
			
			.when()
			.post("https://reqres.in/api/{mypath}")
			
			.then()
				.statusCode(201);
		}
		
		//POJO method
				@Test
				void createuserss() {
					
					POJO hp = new POJO();
					hp.setName("sabari");
					hp.setJob("PMO");
					
					given()
					
					.contentType("application/json")
					.body(hp)
					.pathParam("mypath","user")
					
					
					.when()
					.post("https://reqres.in/api/{mypath}")
					
					.then()
						.statusCode(201);
				}
				
				
				//externalfile method
				@Test
				void createusersss() throws FileNotFoundException {
					
					File hp = new File(".\\day.json");
					FileReader hpp = new FileReader(hp);
					JSONTokener hp1 = new JSONTokener(hpp);
					JSONObject data = new JSONObject();
					
					
					given()
					
					.contentType("application/json")
					.body(data.toString())
					.pathParam("mypath","user")
					
					
					.when()
					.post("https://reqres.in/api/{mypath}")
					
					.then()
						.statusCode(201)
						.log().all();
				}

}
