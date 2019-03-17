package testDefs;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import com.jayway.restassured.specification.RequestSpecification;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.StringUtils;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.equalTo;

import java.util.Map;

import static com.jayway.restassured.RestAssured.given;

public class Users {
    private Response response;
    private ValidatableResponse jsonResponse;
    private RequestSpecification request;


    @When("^I get to \"([^\"]*)\"$")
    public void iGetTo(String url) {
        response = given().when().get(url);
    }


    @Then("^the status code (\\d+)")
    public void theStatusCode(int statusCode) throws Throwable {
        jsonResponse = response.then().statusCode(statusCode);
    }

    @And("^response includes following$")
    public void responseIncludesFollowing(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                jsonResponse.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                jsonResponse.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @And("^response includes the following in any order$")
    public void responseIncludesTheFollowingInAnyOrder(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                jsonResponse.body(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                jsonResponse.body(field.getKey(), equalTo(field.getValue()));
            }
        }
    }

    @And("^response headers includes$")
    public void responseHeadersIncludes(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            if (StringUtils.isNumeric(field.getValue())) {
                jsonResponse.header(field.getKey(), equalTo(Integer.parseInt(field.getValue())));
            } else {
                jsonResponse.header(field.getKey(), equalTo(field.getValue()));
            }
        }
    }


    @When("^I send POST to \"([^\"]*)\"$")
    public void iSendPOSTTo(String url) {
        String myJson = "{\"name\":\"arsens\", \"surname\":\"morins\"}";
        response = given().body(myJson).when().post(url);

    }

    @Then("^the status is (\\d+)")
    public void theStatusIs(int statusCode) throws Throwable {
        jsonResponse = response.then().statusCode(statusCode);
    }

    @And("^response includes following body$")
    public void responseIncludesFollowingBody(Map<String, String> responseFields) {
        for (Map.Entry<String, String> field : responseFields.entrySet()) {
            jsonResponse.body(field.getKey(), equalTo(field.getValue()));
        }
    }
}
