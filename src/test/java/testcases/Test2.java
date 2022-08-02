package testcases;

import org.json.simple.JSONObject;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.*;
import utilities.ReadXLSData;

public class Test2 {

	@Test (priority = 3, dataProviderClass=ReadXLSData.class, dataProvider = "TestData.xlsx", enabled = false)
	public static void testTwoPostPrereq(String directory, String URI, String StatusCode,String petId, String additionalMetadata, 
			String ContentType, String path) {

		File file = new File(System.getProperty("user.dir")+directory);
		baseURI = URI;
		String endpoint = "/v2/pet/2/uploadImage";
		int sc = Integer.parseInt(StatusCode);
		
		JSONObject jsono = new JSONObject();
		
		jsono.put("petId", petId);
		jsono.put("additionalMetadata", additionalMetadata);
		
		System.out.println(jsono);
		
		given()
		.header("Content-Type", ContentType)
		.multiPart("file",file,"application/json")
		.body(jsono.toJSONString())
		
		.when()
		.post(path)
		
		.then()
		.statusCode(sc)
		.log().all();
	}

	@Test (priority = 2, dataProviderClass=ReadXLSData.class, dataProvider = "TestData.xlsx", enabled = true)
	public static void testTwoGet(String ID, String StatusCode, String URI, String path)  {
		
		int id = Integer.parseInt(ID);
		int sc = Integer.parseInt(StatusCode);
		baseURI = URI;
		given()
		.get(path+ID)
		.then()
		.header("Content-Type", "application/json")
		.statusCode(sc)
		.assertThat()
		.log().all();
		
	}

	@Test (dataProviderClass=ReadXLSData.class, dataProvider = "TestData.xlsx", enabled = true)
	public static void testTwoPost(String URI, String Path, String StatusCode, String ID,
			String Category, String FName, String LName, String Status) {

		baseURI = URI;//URI;
		String endpoint = Path;
		int sc = Integer.parseInt(StatusCode);
		
		String jsono = "{ \"id\" : \""+ID+"\", " +
				"\"category\" : {\"id\" : \""+ID+"\",\"name\" : \""+Category+"\"}," +
	            "\"name\" : \""+FName+"\", " +
	            "\"photoUrls\" : [\"string\"]," +
	            "\"tags\" : [{\"id\" : \""+ID+"\",\"name\" : \""+LName+"\"}]," +
	            "\"status\" : \""+Status+"\"}";

		
		System.out.println(jsono);
		
		given()
		.header("Content-Type", "application/json")
		.body(jsono)
		
		.when()
		.post(endpoint)
		
		.then()
		.statusCode(sc)
		.log().all();
	}



}
