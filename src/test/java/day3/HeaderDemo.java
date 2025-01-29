package day3;

import static io.restassured.RestAssured.given;

import java.util.Map;

import org.testng.annotations.Test;

import groovy.util.logging.Log;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class HeaderDemo {
	
	//@Test
	
	// This is not related . Its just stesting mathematical Functions.
	void testingMath()
	{
		System.out.println("1/16:Remainder --->"+ 1%16);
		System.out.println("5/16:Remainder --->" + 5%16);
		System.out.println("9/16:Remainder --->" + 9%16);
		System.out.println("1/16:Remainder --->" + 1%16);
		System.out.println("15/16:Remainder---> "+ 15%16);
		System.out.println("16/ 16 Remainder:-->" + 16%16);
		System.out.println("50/16:-->Remainder " + 50%16);
		
	}
	
		//@Test
	void testHeaders()
	{		
		given()
				
		.when()
		.get("https://www.google.com/")
				
		.then()
			//expected : text/html; charset=ISO-8859-1. it will match with actual from response.
			.header("Content-Type","text/html; charset=ISO-8859-1")
			//when you doing mutliple validation you can use and() 
			//Not Mandatory but you can use if you want to.
			.and()
			.header("Content-Encoding", "gzip")
			.and()
			.headers("Server", "gws");
		
	}
	
	@Test
	void getHeaders()
	{		
	
		//TODO  : To Understand what res is doing here?
		Response  res=	given()
				
		.when()
		.get("https://www.google.com/");
				
		// Get Single Header Info
		//String headervalue = res.getHeader("Content-Type");
		//System.out.println("The value of content Type Header is: " + headervalue);
		
		// Capture  All Headers Info
		//Headers (collection) from io.restassured
		
		Headers	myHeaders = res.getHeaders();
		
		for (Header hd:myHeaders) 
		{
			System.out.println("Header's Name:-- > "+ hd.getName()+ ",  value:--> " + hd.getValue());
			
		}
		

		}
		
		
		
	
	
	
	
	
	
	
	

}
