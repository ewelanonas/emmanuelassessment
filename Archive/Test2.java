package testcases.Functions;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.cucumber.java.en.*;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import io.restassured.http.ContentType;
import io.restassured.response.*;
import utilities.ReadXLSData;

public class Test2 {
	/*
	 * @Given("I want to write a step with precondition") public void
	 * i_want_to_write_a_step_with_precondition() {
	 * System.out.println("Given cucumber"); }
	 * 
	 * @And("some other precondition") public void some_other_precondition() { //
	 * Write code here that turns the phrase above into concrete actions
	 * System.out.println("And cucumber"); }
	 * 
	 * @When("I complete action. input <username> and <password>") public void
	 * i_complete_action_input_username_and_password() {
	 * System.out.println("When cucumber"); }
	 * 
	 * @Then("I validate the outcomes") public void i_validate_the_outcomes() {
	 * System.out.println("Then cucumber"); }
	 */
	@Test (enabled = false)
	void testTwo() {
		Response response = get("https://reqres.in/api/users?page=2");

		System.out.println(response.asString()+"/n");
		System.out.println(response.getBody()+"/n");
		System.out.println(response.getStatusCode()+"/n");
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeader("content-type"));
		System.out.println(response.getTime());


	}

	@Test (enabled = false)
	void testTworShort() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.assertThat()
		.body("data.id[0]", equalTo(7));
	}

	@Test (enabled = false)
	public void testTwoGet() {
		given()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.body("data.first_name", hasItems("Michael", "Lindsay"))
		.log()
		.all();

	}
	
	@Test (enabled = true)
	public void testTwoPost() {
		/*
		 * Map<String, Object> map = new HashMap<String, Object>();
		 * 
		 * map.put("\"name\"", "Ewel"); map.put("\"job\"", "Automation Engineer");
		 * 
		 * System.out.println(map);
		 */
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\TestData.xlsx");
		baseURI = "https://petstore.swagger.io/";
		String endpoint = "/v2/pet/2/uploadImage";
		JSONObject jsono = new JSONObject();
		
		jsono.put("petId", "2");
		jsono.put("additionalMetadata", "doggo");
		
		System.out.println(jsono);
		
		given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.header("Content-Type", "multipart/form-data")
		.multiPart("file",file,"application/json")
		.body(jsono.toJSONString())
		
		.when()
		.post("/v2/pet/2/uploadImage")
		
		.then()
		.statusCode(200)
		.log().all();
	}

}

//@Test (dataProviderClass=ReadXLSData.class, dataProvider = "TestData.xlsx", enabled = true)
//public static void testTwoPost(String URI, String Path, String StatusCode, String ID,
//		String Category, String FName, String LName, String Status) {
//
//	baseURI = URI;//URI;
//	String endpoint = Path;
//	int sc = Integer.parseInt(StatusCode);
//	
////	JSONObject jsono = new JSONObject();
////	String category1 = jsono.put("id", "1").toString();
////	String category2 = jsono.put("name", "Cat").toString();
////	Map<String, Object> map = new HashMap<String, Object>();
////	
////	jsono.put("id", "1");
////	jsono.put("category", Arrays.asList(category1, category2));
////	//jsono.put("category", Arrays.asList(put("id", "1").toString()+","+put("name", "Cat").toString()));
////	jsono.put("name", "Ticky");
////	jsono.put("photoUrls", Arrays.asList("string"));
////	jsono.put("tags", Arrays.asList(new LinkedHashMap<String, Object>(){
////	    {
////	        put("id", "1");
////	        put("name", "Anonas");
////	    }}));
////	jsono.put("status", "available");
//	
//	String jsono = "{ \"id\" : \""+ID+"\", " +
//			"\"category\" : {\"id\" : \""+ID+"\",\"name\" : \""+Category+"\"}," +
//            "\"name\" : \""+FName+"\", " +
//            "\"photoUrls\" : [\"string\"]," +
//            "\"tags\" : [{\"id\" : \""+ID+"\",\"name\" : \""+LName+"\"}]," +
//            "\"status\" : \""+Status+"\"}";
//
//	
//	System.out.println(jsono);
//	
//	given()
//	.header("Content-Type", "application/json")
//	.body(jsono)
//	
//	.when()
//	.post(endpoint)
//	
//	.then()
//	.statusCode(sc)
//	.log().all();
//}
