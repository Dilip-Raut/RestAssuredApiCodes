package AuthorizationTypes_BearerToken09;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Authorization_BearerToken {


	@Test
	public void BearerToken()
	{
		//https://gorest.co.in/public/v2/users
		//create requsest specification
		RequestSpecification requestSpec = RestAssured.given();
		
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");
	
		JSONObject payload = new JSONObject();
		payload.put("name", "Dilip0123");
		payload.put("gender", "Male");
		payload.put("email", "xyzfortesting01@gmail.com");
		payload.put("status", "Active");
		
		String AuthToken = "Bearer 4d6291d7f7e9626f82f040dd114fb0584b4207ad31be0e043238f04e7e385d60";
	
		requestSpec.headers("Authorization", AuthToken).
					contentType(ContentType.JSON).
					body(payload.toJSONString());
		
		//perform post request
		Response response = requestSpec.post();
		

		//validate status code 
		Assert.assertEquals(response.statusCode()/*actual*/, 201/*expected*/,"check for status code");
	
		//print status line & response boy
		System.out.println("Responsne status line:" + response.statusLine());
		System.out.println("Response body:" + response.body().asPrettyString());
		
		
	}
}