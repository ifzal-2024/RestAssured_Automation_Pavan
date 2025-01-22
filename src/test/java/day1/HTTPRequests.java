package day1;



import static	io.restassured.RestAssured.*;
import	static	 io.restassured.matcher.RestAssuredMatchers.*;
import	static 	org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import 	org.testng.annotations.Test;

//day01


public class HTTPRequests {
	int id;
	String first_name;
	
	@Test(priority = 1)
	
	void getAllUsers() 
	{
		//given()
					
		when()
			.get("https://reqres.in/api/users?page=2")
	
			
		.then()
			.statusCode(200)
			.body("page", equalTo(2))
			.body("per_page", equalTo(6))
			.log().all();
	}
	
	@Test(priority = 2)
		void createUser() 
	
	{
		HashMap hashData=new HashMap();
		
		hashData.put("name","pavan"); 
		hashData.put("job", "trainer");
		
		id=given() 
			.contentType("application/json")
			.body(hashData)
		
		.when()
			.post("https://reqres.in/api/users")
			.jsonPath().getInt("id");
		
		//.then()
		//.statusCode(201)
		//.log().all();
			
	}
	@Test(priority = 3,dependsOnMethods = {"createUser"})
	void updateUser() 
	
	{
		HashMap hashData=new HashMap();
		
		hashData.put("name","John"); 
		hashData.put("job", "Teacher");
		
		given() 
			.contentType("application/json")
			.body(hashData)
		
		.when()
			.post("https://reqres.in/api/users")
				
		.then()
			.statusCode(201)
			.log().all();
		
	}
	
	
	@Test(priority=4)
	void deleteUser()
	
	{
		given()
		
		.when()
			.post("https://reqres.in/api/users")
			
		.then()
			.statusCode(415)
			.log().all();
	}
	
	
	
	
	
	
	
	

}
