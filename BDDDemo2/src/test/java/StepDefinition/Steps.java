package StepDefinition;

import org.json.simple.JSONObject;
import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class Steps
{
	private static final String USERNAME="TOOLSQA-Test";
	private static final String BASEURL="https://bookstore.toolsqa.com";
	
	RequestSpecification req = null;
	Response res;
	ResponseBody resbody;
	JsonPath path;
	
	@Given("I am on swagger page")
	public void i_am_on_swagger_page()
	{
	   RestAssured.baseURI=BASEURL;
	   req = RestAssured.given();  
	}

	@When("I enter URL for getting books")
	public void i_enter_URL_for_getting_books() 
	{
	   res = req.get("/BookStore/v1/Books"); 
	}

	@Then("Book List is displayed")
	public void book_List_is_displayed() 
	{
	   path = res.jsonPath();
	   String valid = path.getString("books[0].isbn");
	   Assert.assertEquals("9781449325862", valid);
	}

	@When("I enter URL for addinging books")
	public void i_enter_URL_for_addinging_books() 
	{
		 RestAssured.baseURI=BASEURL;
		 RequestSpecification req1 = RestAssured.given(); 
		 req1.contentType("application/json");
		 JSONObject obj = new JSONObject();
		obj.put("userId", USERNAME);
		obj.put("isbn", "9781449325861");
		req1.body(obj.toJSONString());
		res = req1.post("/BookStore/v1/Books"); 
	}

	@Then("Book is Added")
	public void book_is_Added() 
	{
		System.out.println(res.getStatusCode());
	   
	}
	

}
