package rest.basic.testing.rest.basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ParsingJson2 {
    @Test
    public void verifyResponse(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        Response res = given().param("location", "52.345846, 35.347828").
                param("radius", "500").
                //param("type", "food").
                param("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").
                when().get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all().
                extract().response();
        String response = res.asString();
        JsonPath jsonRes = new JsonPath(response);
        int arrSize = jsonRes.getInt("results.size()");
        for (int i = 0; i < arrSize ; i++) {
            String name = jsonRes.getString("results[" + i + "].name");
            System.out.println(name);
        }
    }
}
