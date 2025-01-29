package day3;

import static	io.restassured.RestAssured.*;
import	static	 io.restassured.matcher.RestAssuredMatchers.*;
import	static 	org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Path_and_query_parametrs  
{
	// Topic: Query param and path Para,
	//https://reqres.in/api/users?page=2&id=5
	
	@Test
	void testQueryandPathParameters() 
	{
	
		//Specify PreRequistes
		given()
			//.pathparam is method with key value pair and we can give any name as variable
			.pathParam("mypath", "users")
			//queryparam are not variable. So we have to put page as page excatly same as appears in url. 
			//we cannot give our own name.
			.queryParam("page"	, 1)
			//queryparam is not variable, so id as id exactly same as appears in url
			//.queryParam("id", 8)
		
			
		//Request Type get, post, put , delete
		.when()
		// We do not have to add query in the url , it will automatically go
	
			.get("https://reqres.in/api/{mypath}")
		//Validations
		.then()
		.statusCode(200)
		.log().all();
		

		
		
		
		
	}
	
	

}
