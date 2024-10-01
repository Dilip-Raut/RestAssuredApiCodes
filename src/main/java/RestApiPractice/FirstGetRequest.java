package RestApiPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstGetRequest {

	@Test
	public void getFirstRequest() {
		
	Response response =	RestAssured.get("https://reqres.in/api/users/2");
	System.out.println("response is :"+response.asString());
	System.out.println("Status code is :"+response.getStatusCode() );
	}
}
