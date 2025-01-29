package day3;

import static	io.restassured.RestAssured.*;
import	static	 io.restassured.matcher.RestAssuredMatchers.*;
import	static 	org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

public class CookiesDemo {
	
	//@Test
	void testCookies() 
	{
		
		given()
				
		
		.when()
		.get("https://www.google.com/")
		
		
		.then()
		.cookie("AEC", "AZ6Zc-VOiFercPcamOl3wvIYUQ35j2_n-KRrWM13jG2VHD4cZPyGP0RI_w")
		.log().all();
	}
	
	//@Test
	void getCookiesInfo()
	{
		
		Response res=	given()
				
		
		.when()
		.get("https://www.google.com/");
		
		//get single cookie info
		//get cookie is a method in restAssured. Cookie 
		//String	Cookie_value =	res.getCookie("AEC");
		//System.out.println("Value of AEC Cookie is:===> " +Cookie_value);
		
		//Get all Cookies info 
	
		Map<String,String> cookies_values = 	res.getCookies();
		
		//System.out.println(cookies_values.keySet());
		for (String k:cookies_values.keySet() ) 
		{
			String Cookie_value =	res.getCookie(k);
			System.out.println( "Key:--> " + k+  "  value:-->"  + cookies_values );
		}
		
		
		
		}
	
	
}

