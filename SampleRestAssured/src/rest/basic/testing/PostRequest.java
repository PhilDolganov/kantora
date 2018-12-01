package rest.basic.testing;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;

public class PostRequest {

    @Test
    public void verifyResponse(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        given().given().queryParam("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").
                body("{\n" +
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
                        "}").when().post("/maps/api/place/add/json").then().assertThat().statusCode(200).and().
                body("status", equalTo("OK"));
                /*.and().contentType(ContentType.JSON).and().
                body("results[0].name", equalTo("Hotel Ajanta")).and().
                body("results[13].name",equalTo("Capital")).and().
                body("results[5].vicinity",equalTo("1/19a, Nehru Bazar, Pahar Ganj, New Delhi")).and().
                header("server","scaffolding on HTTPServer2"); */
    }
}
