package rest.basic.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequestSample {

    // Base URI
    public  static String baseURI = "https://maps.googleapis.com";

    public static void searchPlaceInGoogle(){

        RestAssured.baseURI = baseURI;

        given().param("location", "28.644800, 77.216721").
                param("radius", "500").
                param("type", "restaurant").
                param("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").
        when().get("/maps/api/place/nearbysearch/json").
        then().assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
          //      body("results[0].geometry.viewport.northeast.lat", equalTo("28.6471203802915"));
         body("results[0].name", equalTo("Hotel Ajanta"));
        System.out.println("Request is executed successfully");
    }

    public static void main(String[] args){
        searchPlaceInGoogle();
    }
}
