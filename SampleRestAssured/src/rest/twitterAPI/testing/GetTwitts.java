package rest.twitterAPI.testing;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class GetTwitts {

    String consumerKey = "PUQAGv62qlWdxke8T1iyd8lpS";
    String consumerSecret = "0Wilywy9TvaQU5R06dqJprriBzAkVlZYnXIIX0fvpZ4SiseZok";
    String accessToken = "871085044579811328-1aTeNbD68bd99hgYVAiSOYRw8Z7j3zj";
    String accessTSecret = "8YN2WYp462aXxk2BKyBxffyqxBRqYlncHSLEbrYnDXQVq";

    @Test
    public void getFirstThreeTwitts() throws IOException {

        RestAssured.baseURI = "https://api.twitter.com";
        Response res = given().auth().
                oauth(consumerKey,consumerSecret,accessToken,accessTSecret).
                param("count", 3).log().all().
                when().get("/1.1/statuses/user_timeline.json").
                then().assertThat().statusCode(200).log().all().
                extract().response();
    }
}
