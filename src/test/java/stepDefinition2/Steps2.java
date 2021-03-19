package stepDefinition2;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps2 {
	
	
	private static final String BASE_URL = "http://api.openweathermap.org/data/3.0";
	private static Response response;
	
	@Given("base uri is http:\\/\\/api.openweathermap.org\\/data\\/")
	public void base_uri_is_http_api_openweathermap_org_data() {
		RestAssured.baseURI = "http://api.openweathermap.org/data/3.0";
	}

	@When("I get user detail")
	public void i_get_user_detail() {
		RequestSpecification httprequest = RestAssured.given();
		 response = httprequest.request(Method.GET, "/stations");
		response.getBody().prettyPrint();
	}

	@Then("Unauthorized status code is displayed")
	public void unauthorized_status_code_is_displayed() {
		Assert.assertEquals(response.getStatusCode(), 401);
		System.out.println(response.statusCode());
	}
	

	@When("I register the details of first station")
	public void i_register_the_details_of_first_station() {
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject json = new JSONObject();
		json.put("external_id","Interview1");
		json.put("name","Interview Station 3");
		json.put("longitude",-12.44);
		json.put("latitude",33.34);
		
		json.put("altitude",444);
	
		httprequest.body(json.toJSONString());
		
		 response = httprequest.post("/stations?APPID=7764028be3eb9c837014b41c27bde1c6");
		response.getBody().prettyPrint();
	}

	@Then("created status code message is displayed")
	public void created_status_code_message_is_displayed() {
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(response.statusCode());
	}

	

	@When("I register the details of second station")
	public void i_register_the_details_of_second_station() {
		RequestSpecification httprequest = RestAssured.given();
		httprequest.header("Content-Type","application/json");
		JSONObject json = new JSONObject();
		json.put("external_id","DEMO_TEST001");
		json.put("name","Interview Station 2");
		json.put("longitude",-111.43);
		json.put("latitude",33.33);
		
		json.put("altitude",444);
	
		httprequest.body(json.toJSONString());
		
		 response = httprequest.post("/stations?APPID=7764028be3eb9c837014b41c27bde1c6");
		response.getBody().prettyPrint();
	}

	@Then("created status code is displayed")
	public void created_status_code_is_displayed() {
		Assert.assertEquals(response.getStatusCode(), 201);
		System.out.println(response.statusCode());
	}

	

	@When("I get user details")
	public void i_get_user_details() {
		RequestSpecification httprequest = RestAssured.given();
		//httprequest.header("Content-Type","application/json");
		 response = httprequest.request(Method.GET, "/stations?APPID=7764028be3eb9c837014b41c27bde1c6");
		
		
		response.getBody().prettyPrint();
	}

	@Then("success status code is displayed")
	public void success_status_code_is_displayed() {
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.statusCode());
	}


	@When("delete the stations")
	public void delete_the_stations() {

		RequestSpecification httprequest = RestAssured.given();
		
	    response = httprequest.delete("/stations/604f305a09e7430001b9e19b?APPID=7764028be3eb9c837014b41c27bde1c6");
		response = httprequest.delete("/stations/604f305a09e7430001b9e19c?APPID=7764028be3eb9c837014b41c27bde1c6");
		
		
	}

	@Then("Noc content status code is displayed")
	public void noc_content_status_code_is_displayed() {
		Assert.assertEquals(response.getStatusCode(), 204);
		System.out.println(response.statusCode());
	}




}
