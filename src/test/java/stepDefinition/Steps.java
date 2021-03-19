package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Steps {
	
	private static final String BASE_URL = "https://restcountries.eu/rest/v2";
	private static Response response;
	@Given("Base URI is http:\\/\\/restcountries.eu\\/")
	public void base_URI_is_http_restcountries_eu() {
	    // Write code here that turns the phrase above into concrete actions
		RestAssured.baseURI = "https://restcountries.eu/rest/v2";
	    //throw new io.cucumber.java.PendingException();
	}

	@When("I get user details")
	public void i_get_user_details() {
	    // Write code here that turns the phrase above into concrete actions
		
		
		RequestSpecification httprequest = RestAssured.given();
	    response = httprequest.request(Method.GET, "/name/eesti");
		response.getBody().prettyPrint();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("Success status code should be displayed")
	public void success_status_code_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
		
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println(response.getStatusCode());
	   // throw new io.cucumber.java.PendingException();
	}

}
