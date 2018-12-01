package rest.basic.testing.rest.basic;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJson {
    @Test
    public void verifyResponse(){
        RestAssured.baseURI = "https://maps.googleapis.com";
        Response res = given().param("location", "28.644800, 77.216721").
                param("radius", "500").
                param("type", "cruise").
                param("key", "AIzaSyANW39Bzw2tiRGTeNHbCi0GQp9b8jJIMdg").log().all().
                when().get("/maps/api/place/nearbysearch/json").
                then().assertThat().statusCode(200).and().contentType(ContentType.JSON).log().all().
                extract().response();
        String response = res.asString();
        JsonPath jsonRes = new JsonPath(response);
        int arrSize = jsonRes.getInt("results.size()");
        for (int i = 0; i < arrSize ; i++) {
            String name = jsonRes.getString("results[" + i + "].name");
            //System.out.println(name);
        }
    }
}
