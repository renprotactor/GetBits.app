package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinition extends Utils {
    RequestSpecification requestSpecification;
    TestDataBuild data = new TestDataBuild();
    Response response;


    @Given("I set the API endpoint and create payload for creating a user with  details {string} {string} {string} {string} {string} {string} {int}")
    public void i_set_the_api_endpoint_and_create_payload_for_creating_a_user_with_details(String title, String firstName, String lastName, String dateOfBirth, String email, String password, int rating) throws IOException {
        requestSpecification = given().spec(requestSpecification())
                .body(data.addUserPayLoad(title, firstName, lastName, dateOfBirth, email, password, rating));
    }

    @When("I send a POST request using {string} with {string} http request")
    public void i_send_a_post_request_using_with_http_request(String resource, String method) {
        APIResources resourceAPI = APIResources.valueOf(resource);
        System.out.println(resourceAPI.getResource());


        if (method.equalsIgnoreCase("POST"))
            response = requestSpecification.when().post(resourceAPI.getResource());
        else if (method.equalsIgnoreCase("GET"))
            response = requestSpecification.when().get(resourceAPI.getResource());

    }

    @Then("I should receive a status code of {int}")
    public void i_should_receive_a_status_code_of(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }


    @Then("{string} in response body is {string}")
    public void in_response_body_is(String keyValue, String expectedValue) {
        assertEquals(getJsonPath(response, keyValue), expectedValue);
    }

}
