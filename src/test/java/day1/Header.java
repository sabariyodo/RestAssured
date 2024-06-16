package day1;
import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

import io.restassured.response.Response;



public class Header {
	@Test
	void header() {
		Response res = when().get("https://www.google.com/");
		String value =res.getHeader("Content-Type");
		System.out.println(value);

	}
	
	

}
