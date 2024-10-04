package TestMethods03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod {

	@Test
	public void testDelete06()
	{
		RestAssured.baseURI="https://reqres.in/api/users/90";
		RestAssured.given().
		when().
			delete().
		then().
			log().all().
			statusCode(204);
	}
			
}
