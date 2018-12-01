package rest.jiraAPI.testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;

public class UpdateComment {

    @Test
    public void verifyResponse() throws IOException {
        String requestBody = generateString("JiraLogin.json");

        RestAssured.baseURI = "http://localhost:8100";
        Response res = given().contentType(ContentType.JSON).body(requestBody).when().post("/rest/auth/1/session").
                then().assertThat().statusCode(200).extract().response();
        String response = res.asString();

        JsonPath jsonRes = new JsonPath(response);
        String sessionID = jsonRes.getString("session.value");


        // Add Comment

        String createCmntBody = generateString("AddCmnt.json");
        Response addCmntResponse = given().contentType(ContentType.JSON).
                header("cookie","JSESSIONID=" + sessionID + "").
                body(createCmntBody).when().
                //        post("/rest/api/2/issue/"+issueID+"/comment").
                        post("/rest/api/2/issue/RAT-2/comment").
                        then().assertThat().statusCode(201).log().all().
                        extract().response();

        JsonPath addCmntResJson = new JsonPath(addCmntResponse.asString());
        String cmntID = addCmntResJson.getString("id");

        System.out.println("Comment Added");

        // Update comment
        String updateCmntBody = generateString("UpdateCmnt.json");
        Response updateCmntResponse = given().contentType(ContentType.JSON).
                header("cookie","JSESSIONID=" + sessionID + "").
                body(updateCmntBody).when().
                        put("/rest/api/2/issue/RAT-2/comment/" + cmntID + "").
                        then().assertThat().statusCode(200).log().all().
                        extract().response();

//        JsonPath addCmntResJson = new JsonPath(addCmntResponse.asString());
//        String cmntID = jsonRes.getString("id");

        given().contentType(ContentType.JSON).
                header("cookie","JSESSIONID=" + sessionID + "").
                delete("/rest/api/2/issue/RAT-2/comment/" + cmntID + "").
                then().assertThat().statusCode(204).log().all();
    }

    public static String generateString(String filename) throws IOException {
        String filePath = System.getProperty("user.dir") + "\\Payloads\\" + filename;
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }
}
