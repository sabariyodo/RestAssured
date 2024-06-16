package day1;

import static io.restassured.RestAssured.when;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class Cookies {
	@Test
	void cookies() {
		
		Response res = when()
		.get("https://www.google.com/");
		
		System.out.println(res.getCookie("AEC"));
		Map<String, String> cookies = res.getCookies();
		System.out.println(cookies.keySet());
		
		for(String k:cookies.keySet()) {
			String kk = res.getCookie(k);
			System.out.println("Name"+k+"Value"+kk);
			
		}
	
		
		
	}
	

}
