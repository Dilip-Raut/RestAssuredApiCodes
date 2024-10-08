package JsonObjecUsingJavaMap15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonObjecUsingJavaMap {

	//https://restful-booker.herokuapp.com/apidoc/index.html
	
	@Test (enabled=false)
	public void createAuthToken()
	{
			/*	{
    				"username" : "admin",
    				"password" : "password123"
				}
			*/
		
		Map<String, String> authToken = new HashMap<String, String>();
		authToken.put("username", "admin");
		authToken.put("password", "password123");
		
		Response response = RestAssured.given()
							.baseUri("https://restful-booker.herokuapp.com/auth")
							.contentType(ContentType.JSON)
							.body(authToken)
							.post();
		
		response.prettyPrint();
		
		//verify status code
		Assert.assertEquals(response.statusCode(), 202,"check for status code.");
		
	
	}
	
	
	@Test
	public void createUser()
	{
		/*	{
   				"firstName":"Dilip",
   				"lastName":"Raut",
   				"age": 28,
   				"salary": 10000.56,
   				"Hobbies":["Music","Computer","Games"],
 				"TechSkill":{
								"Programming language":"Java",
								"WebAutomation":"Selenium",
								"API testing" : "Rest Assured"
		

             				}
   
 }*/
		
		HashMap <String,Object> UserData = new HashMap<String,Object>();
		UserData.put("firstName", "Dilip");
		UserData.put("lastName", "Raut");
		UserData.put("age", 28);
		UserData.put("salary", 10000.56);
		
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("computers");
		hobbies.add("Games");
		UserData.put("Hobbies",hobbies );
		
		HashMap <String,String> TechSkill = new HashMap<String,String>();
		TechSkill.put("Programming language", "Java");
		TechSkill.put("WebAutomation", "Seleniuim");
		TechSkill.put("API testing", "Rest Assured");

		UserData.put("TechSkill",TechSkill );
		
		
		Response response = RestAssured.given()
				.baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON)
				.body(UserData)
				.post();
				
				response.prettyPrint();
				
				//verify status code
				Assert.assertEquals(response.statusCode(), 201,"check for status code.");
		
		
	}
	
}
