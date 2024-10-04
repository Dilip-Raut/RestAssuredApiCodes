package HttpValidateHeader05;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {
	//https://reqres.in/api/users/2

		@Test
		public void testValidateResponseHeader()
		{
			//Get Request Specification
			RequestSpecification requestSpec = RestAssured.given();
			
			//specify base uri
			requestSpec.baseUri("https://reqres.in");
			requestSpec.basePath("/api/users/2");
			
			//create get request
			Response response = requestSpec.get();
			
			//validate response header
			String contentType = response.getHeader("Content-Type");
							
			//read all the response header attributes/keys and print their values
			Headers headersList = response.getHeaders();
			
			//iterate over header list 
			for (Header header:headersList)
			{
				System.out.println("Header Name and Value is -> "+header.getName() + " : " + header.getValue());
			}
			
			
			//validate header content-type , expected value : application/json; charset=utf-8
			Assert.assertEquals(contentType, "application/xml; charset=utf-8","Header content type mismatch.");
			
		}
		
	}
