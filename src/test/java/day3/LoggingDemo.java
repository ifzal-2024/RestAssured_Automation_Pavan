package day3;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class LoggingDemo {
	
	//@Test
	
	void testLogs() 
	
	{
		given() 
		
		.when()
		 	.get("https://reqres.in/api/users?page=2")
		
		.then()
				.log().all();
		
				
	}
	
	
	
	//@Test 
	void logsPrintBody() 
	{
		given() 
		
		.when()
		 	.get("https://reqres.in/api/users?page=2")
		 	
		// Just want to print body
		.then()
				.log().body();
		
				
	}
	
	// Printing just cookies
	//@Test
	void logsPrintCookies() 
	{
		given() 
		
		.when()
		 	.get("https://reqres.in/api/users?page=2")
		 	
		// Just want to print body
		.then()
				.log().headers();
						
	}
	
	// Print Just Headers.
	@Test
	void logsPrintHeaders() 
	{
		given() 
		
		.when()
		 	.get("https://reqres.in/api/users?page=2")
		 	
		// Just want to print body
		.then()
				.log().headers();
						
	}
	
	
	
	
	
	
	
	

}
