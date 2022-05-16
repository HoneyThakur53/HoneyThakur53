package restassureddemo;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import org.testng.annotations.Test;

public class Basic {
@Test
	public static void test()
	
	{
		// TODO Auto-generated method stub

		RestAssured.baseURI="https://tatras-ux-weather.metswift.live";
		RestAssured.useRelaxedHTTPSValidation();
		given().log().all()
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer "+ "eyJhbGciOiJSUzI1NiJ9.eyJ1c2VybmFtZSI6ImhvbmV5QHRhdHJhc2RhdGEuY29tIiwiZXhwIjoxNjUxMDEwNTIzLCJpYXQiOjE2NTA5NjczMjN9.jlj-GT5dQWScPA-U4nRkT95w6-4am018wp8QbCakkoSS4QDkt820LxcmqWk7haAid-ApOlXq6jmlmOxzBRuKRgR3R4sUiHaM0soPkWL9KFiwR0Rm10TL5wCTUnazq-B7gPIcc7b_EUtecGgO7PgZuS5ayOpYyo-Cn5_oCREXv99oQHa9Hsk4sLDQ05xJWyB5LLl-IjU-pooPjHC_ZqDB_6pfKcgZE8pdIzgbQILfgCyLUQcaASrwEXT5BdcXQbG2SpaSN1mag6hiyRMSIfBtXNVaVAuK_VWmW98pYYUqUi8vVEnWNTYPL_yHtfoULMaX4n3RQ_9GroSEtUKFxGmIQzhxmUqrnfFZfor-nS0cncUh4dbuzcq7D-3s5s74f0zJx46yILmWo2n0OF_bOotTEMyNBb-DcVS18_z9dFHl3WOWIDbv9mSVXI6G0X4bH3PyYzKUPhvs4FH6DCQ48wosAUs8dtN_QICFm6qHz9eL6uewkDV46ql3VNkTwCh58Wu36s3idnqGKrGChMTm2IA1E2qlPGXDDEr81anLhVjVf57Vdxwq01gCJe-mWFoxdBwG6C3CpSxmSTXXhM2JJJxBnod4E0NTWG4dmXKpB4v4BtDMiE43nwIVNMA58fkaQJ4edIrWJ9eoiMDqjQP6a25-JkL4F0ACbZcgyuObCVlgae4")
		//.header("authorization","Bearer eyJhbGciOiJSUzI1NiJ9.eyJ1c2VybmFtZSI6ImhvbmV5QHRhdHJhc2RhdGEuY29tIiwiZXhwIjoxNjQ4ODMwOTUyLCJpYXQiOjE2NDg3ODc3NTJ9.jQtBkj0MTxyJr5lp2COOgldRbDA91sxd5WKYG6-LCqyiuFqht1ByX8j6Y0U4S9fZmkwJhXPqvdmcXSW2VexrhzzJ18AUXKXl9OWCxz32aynXY9T_k9gAL8NuHGpATt2CTaBL-VK9kkHYlK3iDTr7rlJLDMPedzRy0OqbVuLv4XUh2NRjTlI15NWxTMBziWIkFp1IskVgmZxZ2_oiHwi0NrREuHSraCFRvsA5vqqYGaLRFGrq7T_NsQIGssXgzKmu4z6ptRsH3PvBaw4Ul7ASw75gJXXfhz0rJG-5qu4p8chPH7nfKfUboFUqVhzKWumAzogDZcc7pFIsHlyQa5KisWdCw80h98jE-ZcRWbbBQWlt_-xHewrKnmRsLdXDHoqcpwCZxr-nNVGNS9MNcLhQZXXe-A8HRjdctaeB3sO0aQsgrHsDLqpuX_SZXjv0WDhro77cc71rXvowMfGomqHDCA_uOOlCFez_qaM-3xt9ep_BLsE61aj_dVp6lM6e9yR5Tu4Y67IgPyp8GtjL7aHrjpMKZSg3PhMjJUWip9Hs5YR536aOlrl9VDR_vn7SuTHiE0xyWshM_rakC22_NcU1zzm2chO-SSi2YcTFGKOJOUEC6WUBzHCHa-UY-R3MEq_MNC6w5GU7U3JDQJ5olrZLYrqttnYpZQRpbkRWJbFVLr4")
		.body("{\r\n"
				+ "    \"country\": \"GB\",\r\n"
				+ "    \"postCode\": \"TW3 3SY\",\r\n"
				+ "    \"username\": \"honey@tatrasdata.com\",\r\n"
				+ "    \"state\": \"England\",\r\n"
				+ "    \"countryName\": \"United Kingdom\",\r\n"
				+ "    \"uri\": \"/stats_data/get_c_station\",\r\n"
				+ "    \"lat\": 51.46087139999999,\r\n"
				+ "    \"lon\": -0.3731758,\r\n"
				+ "    \"delphiRec\": 1,\r\n"
				+ "    \"Start_Date\": \"07/04/2022\",\r\n"
				+ "    \"End_Date\": \"30/04/2022\",\r\n"
				+ "    \"weathers\": \"\"\r\n"
				+ "}").when().post("/api/v1/stats_data/get_c_station")
		.then().log().all()
		.assertThat().statusCode(200);
	}

}
