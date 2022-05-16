package metswift;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;



public class MetswiftLogin {
	
	public static String token;
	public static String username;
	public static String eventID;
	public static String rainStationID;
	public static String windStationID;
	public static String tempStationID;
	public static String snowStationID;
	public static String fogStationID;
	public static String hailStationID;
	public static String dustStationID;
	public static String stormStationID;
	public static String rainLat;
	public static String rainLon;
	public static String windLat;
	public static String windlon;
	public static String tempLat;
	public static String templon;
	public static String snowLat;
	public static String snowlon;
	public static String fogLat;
	public static String foglon;
	public static String hailLat;
	public static String hailLon;
	public static String dustLat;
	public static String dustLon;
	public static String stormLat;
	public static String stormLon;
	

	@BeforeSuite
	
	@Parameters({"loginBaseUrl"})  
	public static void newenquiry(String loginBaseUrl)
	{
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
		token = myresponse.getString("data.user.token");
		username=myresponse.getString("data.user.username");
		
	}
	
	
	
	@Parameters({"cStationURI"})
	@BeforeTest
	public static void getCStation(String cStationURI)
	{
	 
		RestAssured.baseURI= cStationURI;
		RestAssured.useRelaxedHTTPSValidation();
		//System.out.println("my token " + token);
		
		String getstation= given().log().all().
		header("Content-Type","application/json").
		header("Authorization", "Bearer "+ token).
		body("{\r\n"
				+ "    \"country\": \"US\",\r\n"
				+ "    \"postCode\": \"xxxxxx\",\r\n"
				+ "    \"username\": \"h"+username+"\",\r\n"
				+ "    \"state\": \"Texas\",\r\n"
				+ "    \"countryName\": \"United States\",\r\n"
				+ "    \"uri\": \"/stats_data/get_c_station\",\r\n"
				+ "    \"lat\": 29.7604267,\r\n"
				+ "    \"lon\": -95.3698028,\r\n"
				+ "    \"delphiRec\": 1,\r\n"
				+ "    \"Start_Date\": \"17/6/2022\",\r\n"
				+ "    \"End_Date\": \"17/7/2022\",\r\n"
				+ "    \"categories\": [\r\n"
				+ "        \"TS\",\r\n"
				+ "        \"C1\",\r\n"
				+ "        \"C2\",\r\n"
				+ "        \"C3\",\r\n"
				+ "        \"C4\",\r\n"
				+ "        \"C5\"\r\n"
				+ "    ],\r\n"
				+ "    \"weathers\": \"\"\r\n"
				+ "}")
		.when().post("/api/v1/stats_data/get_c_station").then().log().all().assertThat().statusCode(200).extract().response().asString();
		
		JsonPath myresponse2=new JsonPath(getstation);
		rainStationID=myresponse2.getString("rain.best.stationId");
		windStationID=myresponse2.getString("wind.best.stationId");
		tempStationID=myresponse2.getString("temperature.best.stationId");
		snowStationID=myresponse2.getString("snow.best.stationId");
		fogStationID=myresponse2.getString("fog.best.stationId");
		dustStationID=myresponse2.getString("dust.best.stationId");
		hailStationID=myresponse2.getString("hail.best.stationId");
		stormStationID=myresponse2.getString("storm.best.stationId");
		rainLat=myresponse2.getString("rain.best.lat");
		rainLon=myresponse2.getString("rain.best.lon");
		windLat=myresponse2.getString("wind.best.lat");
		windlon=myresponse2.getString("wind.best.lon");
		tempLat=myresponse2.getString("temperature.best.lat");
		templon=myresponse2.getString("temperature.best.lon");
		snowLat=myresponse2.getString("snow.best.lat");
		snowlon=myresponse2.getString("snow.best.lon");
		fogLat=myresponse2.getString("fog.best.lat");
		foglon=myresponse2.getString("fog.best.lon");
		hailLat=myresponse2.getString("hail.best.lat");
		hailLon=myresponse2.getString("hail.best.lon");
		dustLat=myresponse2.getString("dust.best.lat");
		dustLon=myresponse2.getString("dust.best.lon");
		stormLat=myresponse2.getString("storm.best.lat");
		stormLon=myresponse2.getString("storm.best.lon");
		
		} 
	@Test
	@Parameters({"loginBaseUrl"})
	public static void addevent(String loginBaseUrl)
	{
		RestAssured.baseURI= loginBaseUrl;
		RestAssured.useRelaxedHTTPSValidation();
		
		String response1=given().log().all().
		header("Content-Type","application/json").
		header("Authorization", "Bearer "+ token).
		body("{\r\n"
				+ "    \"lat\": 29.7604267,\r\n"
				+ "    \"lon\": -95.3698028,\r\n"
				+ "    \"postCode\": \"xxxxxx\",\r\n"
				+ "    \"country\": \"US\",\r\n"
				+ "    \"username\": \""+username+"\",\r\n"
				+ "    \"state\": \"Texas\",\r\n"
				+ "    \"countryName\": \"United States\",\r\n"
				+ "    \"startDate\": \"2022/06/17\",\r\n"
				+ "    \"endDate\": \"2022/07/17\",\r\n"
				+ "    \"delphiRec\": 1,\r\n"
				+ "    \"fsi\": 0,\r\n"
				+ "    \"earthquakes\": 0,\r\n"
				+ "    \"hurricanes\": 1,\r\n"
				+ "    \"tornadoes\": 1,\r\n"
				+ "    \"volcanoes\": 0,\r\n"
				+ "    \"wildfire\": 0,\r\n"
				+ "    \"eventName\": \"\",\r\n"
				+ "    \"locationName\": \"Houston, TX, USA\",\r\n"
				+ "    \"eventId\": -1,\r\n"
				+ "    \"groupId\": -1,\r\n"
				+ "    \"groupName\": null,\r\n"
				+ "    \"weathers\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"itemName\": \"rain\",\r\n"
				+ "            \"stationId\": \""+rainStationID+"\",\r\n"
				+ "            \"stationLat\": "+rainLat+",\r\n"
				+ "            \"stationLon\": "+rainLon+",\r\n"
				+ "            \"stationName\": \"Houston, Houston Hobby Airport\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 2,\r\n"
				+ "            \"itemName\": \"wind\",\r\n"
				+ "            \"stationId\": \""+windStationID+"\",\r\n"
				+ "            \"stationLat\": "+windLat+",\r\n"
				+ "            \"stationLon\": "+windlon+",\r\n"
				+ "            \"stationName\": \"Houston, Tx William P Hobby Arpt\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 3,\r\n"
				+ "            \"itemName\": \"temperature\",\r\n"
				+ "            \"stationId\": \""+tempStationID+"\",\r\n"
				+ "            \"stationLat\": "+tempLat+",\r\n"
				+ "            \"stationLon\": "+templon+",\r\n"
				+ "            \"stationName\": \"Houston, Tx William P Hobby Arpt\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 4,\r\n"
				+ "            \"itemName\": \"snow\",\r\n"
				+ "            \"stationId\": \""+snowStationID+"\",\r\n"
				+ "            \"stationLat\": "+snowLat+",\r\n"
				+ "            \"stationLon\": "+snowlon+",\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 5,\r\n"
				+ "            \"itemName\": \"fog\",\r\n"
				+ "            \"stationId\": \""+fogStationID+"\",\r\n"
				+ "            \"stationLat\": "+fogLat+",\r\n"
				+ "            \"stationLon\": "+foglon+",\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 6,\r\n"
				+ "            \"itemName\": \"hail\",\r\n"
				+ "            \"stationId\": \""+hailStationID+"\",\r\n"
				+ "            \"stationLat\": "+hailLat+",\r\n"
				+ "            \"stationLon\": "+hailLon+",\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 7,\r\n"
				+ "            \"itemName\": \"dust\",\r\n"
				+ "            \"stationId\": \""+dustStationID+"\",\r\n"
				+ "            \"stationLat\": "+dustLat+",\r\n"
				+ "            \"stationLon\": "+dustLon+",\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 8,\r\n"
				+ "            \"itemName\": \"storm\",\r\n"
				+ "            \"stationId\": \""+stormStationID+"\",\r\n"
				+ "            \"stationLat\": "+stormLat+",\r\n"
				+ "            \"stationLon\": "+stormLon+",\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"selectedTypes\": \"rain,wind,temperature,snow,hail,dust,fog,storm,tornado,hurricane\",\r\n"
				+ "    \"totalInsights\": 10\r\n"
				+ "}")
		.when().post("/api/insight/addevent").then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		JsonPath myresponse1= new JsonPath(response1);
		eventID=myresponse1.getString("eventId");
		
	}
	
	@Test
	@Parameters({"loginBaseUrl"})
	public static void getmodels(String loginBaseUrl)
	{
		RestAssured.baseURI= loginBaseUrl;
		RestAssured.useRelaxedHTTPSValidation();
		
		given().log().all().
		header("Content-Type","application/json").
		header("Authorization", "Bearer "+ token).
		body("{\r\n"
				+ "    \"username\": \""+username+"\",\r\n"
				+ "    \"eventId\": "+eventID+",\r\n"
				+ "    \"startDate\": \"17-06-2022\",\r\n"
				+ "    \"endDate\": \"17-07-2022\",\r\n"
				+ "    \"hurriCategory\": \"\",\r\n"
				+ "    \"weathers\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"itemName\": \"rain\",\r\n"
				+ "            \"stationId\": \""+rainStationID+"\",\r\n"
				+ "            \"stationLat\": 29.6375,\r\n"
				+ "            \"stationLon\": -95.2825,\r\n"
				+ "            \"stationName\": \"Houston, Houston Hobby Airport\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 2,\r\n"
				+ "            \"itemName\": \"wind\",\r\n"
				+ "            \"stationId\": \""+windStationID+"\",\r\n"
				+ "            \"stationLat\": 29.6333333333,\r\n"
				+ "            \"stationLon\": -95.2666666667,\r\n"
				+ "            \"stationName\": \"Houston, Tx William P Hobby Arpt\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 3,\r\n"
				+ "            \"itemName\": \"temperature\",\r\n"
				+ "            \"stationId\": \""+tempStationID+"\",\r\n"
				+ "            \"stationLat\": 29.6333333333,\r\n"
				+ "            \"stationLon\": -95.2666666667,\r\n"
				+ "            \"stationName\": \"Houston, Tx William P Hobby Arpt\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 4,\r\n"
				+ "            \"itemName\": \"snow\",\r\n"
				+ "            \"stationId\": \""+snowStationID+"\",\r\n"
				+ "            \"stationLat\": 29.638,\r\n"
				+ "            \"stationLon\": -95.282,\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 5,\r\n"
				+ "            \"itemName\": \"fog\",\r\n"
				+ "            \"stationId\": \""+fogStationID+"\",\r\n"
				+ "            \"stationLat\": 29.638,\r\n"
				+ "            \"stationLon\": -95.282,\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 6,\r\n"
				+ "            \"itemName\": \"hail\",\r\n"
				+ "            \"stationId\": \""+hailStationID+"\",\r\n"
				+ "            \"stationLat\": 29.638,\r\n"
				+ "            \"stationLon\": -95.282,\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 7,\r\n"
				+ "            \"itemName\": \"dust\",\r\n"
				+ "            \"stationId\": \""+dustStationID+"\",\r\n"
				+ "            \"stationLat\": 29.638,\r\n"
				+ "            \"stationLon\": -95.282,\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 8,\r\n"
				+ "            \"itemName\": \"storm\",\r\n"
				+ "            \"stationId\": \""+stormStationID+"\",\r\n"
				+ "            \"stationLat\": 29.638,\r\n"
				+ "            \"stationLon\": -95.282,\r\n"
				+ "            \"stationName\": \"WILLIAM P. HOBBY AIRPORT\",\r\n"
				+ "            \"isRecommended\": 1\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"selectedWeatherTypes\": \"rain,temperature,snow,wind,hail,dust,fog,storm,tornado,hurricane\",\r\n"
				+ "    \"numberInsights\": 10,\r\n"
				+ "    \"hurricanename\": \"hurricanes\"\r\n"
				+ "}")
		.when().post("/api/insight/getmodels").then().assertThat().statusCode(200);
		
	}
			
}




