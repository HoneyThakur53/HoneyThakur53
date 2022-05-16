package metswift;

import static io.restassured.RestAssured.given;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class LoginClass {
LoginClass()
{
	
	String loginBaseUrl = null;
	RestAssured.baseURI= loginBaseUrl;
	RestAssured.useRelaxedHTTPSValidation();
	
	String response = given().
	header("Content-Type","application/json").
	body("{\r\n"
			+ "    \"username\": \"honey@tatrasdata.com\",\r\n"
			+ "    \"password\": \"Tatras@123\"\r\n"
			+ "}").log().all().
	when().post("/api/user/login").
	then().log().all().extract().response().asString();
	JsonPath myresponse = new JsonPath(response);
	String token = myresponse.getString("data.user.token");
	System.out.println("Testing");
}
}
