
package day02;

import static	io.restassured.RestAssured.*;
import	static	 io.restassured.matcher.RestAssuredMatchers.*;
import	static 	org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileReader;
import java.net.http.HttpResponse.BodyHandler;
import java.util.HashMap;

import org.apache.http.impl.client.TargetAuthenticationStrategy;
import org.json.JSONObject;
import org.json.JSONTokener;
import 	org.testng.annotations.Test;

import io.restassured.http.ContentType;



/*
 * 1)Hashmap
2)using org.json
3)using POJO (Plain old Java Object)
4) using external json file
 */
public class Different_ways_to_create_post_request_body {
	
	
	//1) Sending Post Request Body using HashMap
	//@Test(priority = 1)
	void testPostusingHashMap() 
	{
		// HashMap
		HashMap data = new HashMap();
		//Adding data using put method from Map class.
		data.put("name","Scott");
		data.put("location", "France");
		data.put("phone", "123456");
		
		String CourseArr [] = {"C", "C++"};
		data.put("courses", CourseArr);
		
		
		given()
			.contentType("application/json")
			// When using Hashmap , pojo or File no need to convert to string
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type", "application/json")
		.log().all();
		
	}
	
	
	//2) Sending Post Request Body using ORG.JSON
	@Test(priority = 1)
	void testPostusingJsonLibrary() 
	{
	// Adding data using JsonObject 
	// We have put method to add datas in org.json
	JSONObject  data= new JSONObject();
	data.put("first_name", "Shoma");
	data.put("location", "France");
	data.put("phone", "123456");
	String coursesArr[] = {"C","C++"};
	data.put("courses", coursesArr);
		
		given()
			.contentType("application/json")
			// When using org.json, You have to convert to String
			.body(data.toString())
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("first_name", equalTo("Shoma"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type", "application/json")
		.log().all();
		
	}
	
	
	
	
	//3) Sending Post Request Body using POJO Class
	//@Test(priority = 1)
	void testPostusingPOJO() 
	{
		//Instantiating pojo class 
		// object data is created . Object is the instance (illustration) of the class, and Object is the physical reality.
		//Class is blueprint from where individual objects are created
		// default constructor is initialized
	pojo_PostRequest data = new pojo_PostRequest();
	
	// Here adding datas using set method from getter/setter.
	data.setName("shoma");
	data.setLocation("France");
	data.setPhone("123456");
	
	String courseArr[]= {"C", "C++"};
	data.setCourses(courseArr);
	
		
		given()
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("shoma"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type", "application/json")
		.log().all();
		
	}
	
	//Sending Post Request Body Using File
	//@Test 
	void testPostusingExternalJsonFile() 
	{
	// File from java.io
File data = new File("C:\\Users\\ifzal\\eclipse-workspace\\RestAssuredPavan\\body.json");

		given()
		 //TODO Different way to specify Content Type 
		// What body con tent will have= Json Format
		// contentType= Request Specification pop up
		//(COntentType)= Rest Assured Pop UP
		//.JSON= content type pop up
			.contentType(ContentType.JSON)
			.body(data)
		
		.when()
			.post("http://localhost:3000/students")
		
		.then()
		.statusCode(201)
		.body("name", equalTo("Scott"))
		.body("location", equalTo("France"))
		.body("phone", equalTo("123456"))
		//There are 2 elements inside courses since its an array. So we have to specify index Number
		.body("courses[0]", equalTo("C"))
		.body("courses[1]", equalTo("C++"))
		.header("Content-Type", "application/json")
		.log().all();
		
	}
	
	
	//@Test(priority = 2)
	void testDelete()
{
	given()
	
	.when()
		.delete("http://localhost:3000/students/4")
	
	.then()
	.statusCode(200);
	
}
	

}
