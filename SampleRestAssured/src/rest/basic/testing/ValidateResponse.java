package rest.basic.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ValidateResponse {

    @Test
    public void verifyResponse(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        given().param("location", "28.644800, 77.216721").
                param("radius", "500").
                param("type", "restaurant").
                param("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").
                when().get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                body("results[0].name", equalTo("Hotel Ajanta")).and().
                body("results[13].name",equalTo("Capital")).and().
                body("results[5].vicinity",equalTo("1/19a, Nehru Bazar, Pahar Ganj, New Delhi")).and().
                header("server","scaffolding on HTTPServer2");
    }
}
