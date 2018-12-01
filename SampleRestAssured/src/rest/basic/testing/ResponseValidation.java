package rest.basic.testing;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class ResponseValidation {

    @Test
    public void verifyResponse() {
        String requestBody = "{\n" +
                "\t\n" +
                "  \"location\": {\n" +
                "    \"lat\": -33.8669710,\n" +
                "    \"lng\": 151.1958750\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Google Shoes!\",\n" +
                "  \"phone_number\": \"(02) 9374 4000\",\n" +
                "  \"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\",\n" +
                "  \"types\": [\"shoe_store\"],\n" +
                "  \"website\": \"http://www.google.com.au/\",\n" +
                "  \"language\": \"en-AU\"\n" +
                "\n" +
                "}";

        RestAssured.baseURI = "https://maps.googleapis.com";
        Response res = given().queryParam("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").
        body(requestBody).when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).extract().response();
        String response = res.asString();
        System.out.println(response);
        JsonPath jsonResponse = new JsonPath(response);
        String placeId = jsonResponse.get("place_id");
        System.out.println(placeId);

        given().queryParam("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").
        body("{" +
                "\"place_id\": \""+placeId+"\"" +
                "}").when().post("/maps/api/place/delete/json").then().assertThat().statusCode(200).
                and().body("status", equalTo("OK"));
    }
}
