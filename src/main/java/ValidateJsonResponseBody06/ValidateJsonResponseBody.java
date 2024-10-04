package ValidateJsonResponseBody06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	//https://reqres.in/api/users?page=2
		
		@Test
		public void testUserListResponseBody()
		{
			//Get RequestSpecifction Reference
			RequestSpecification requestSpec = RestAssured.given();
			
			//specify base URI & base path
			requestSpec.baseUri("https://reqres.in");
			requestSpec.basePath("api/users?page=2");
			
			//create/perform get request
			Response response = requestSpec.get();
			
			//read response body
			ResponseBody responseBody =  response.getBody();
			
			String responseString = responseBody.asPrettyString();
			
			//print response body
			System.out.println("Response body:" + responseString);
			
			//check for presence of George in response body
			
		/*	Assert.assertEquals(responseString.contains("George"),true,"Check for presence of George");*/
			
			//get json path view of response body
			
			JsonPath jsonPathView  = responseBody.jsonPath();
			
			//using https://jsonpathfinder.com/
			String firstName = jsonPathView.get("data[0].first_name");
			
			System.out.println("email address:"+ jsonPathView.get("data[0].email"));
		
			
			Assert.assertEquals(firstName,"George","Check for presense of firstname as George");
		
			
			
			
			

			
		}
	}
