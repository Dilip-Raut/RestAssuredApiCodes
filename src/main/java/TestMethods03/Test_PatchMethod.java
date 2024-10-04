package TestMethods03;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Test_PatchMethod {

	@Test
	public void testPatch05()
	{
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Vikas");
		jsonData.put("job", "Tester");
		
		RestAssured.baseURI="https://reqres.in/api/users/90";
		RestAssured.given().
			header("Content-type","application/json").
			contentType(ContentType.JSON).
			body(jsonData.toJSONString()).
        when().
        	patch().
        then().
        	statusCode(200).
        	log().all();
	}
}