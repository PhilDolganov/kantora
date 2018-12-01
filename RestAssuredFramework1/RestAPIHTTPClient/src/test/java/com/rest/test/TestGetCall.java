package com.rest.test;

import com.rest.base.TestBase;
import com.rest.client.HTTPClient;
import com.rest.utils.TestUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class TestGetCall extends TestBase {

    TestBase testBase;
    HTTPClient driver;
    String APIURI;
    CloseableHttpResponse apiResponse;

    @BeforeTest
    public void setUp(){
       testBase = new TestBase();
       String URL = prop.getProperty("URI");
       String pathparam = prop.getProperty("ServiceURI");
       APIURI = URL + pathparam;
    }

    @Test
    public void testGetCall() throws IOException {
        driver = new HTTPClient();
        apiResponse = driver.getCall(APIURI);
        assertEquals(apiResponse.getStatusLine().getStatusCode(), RESPONSE_CODE_200);
    }

    @Test
    public void testGetCallResponse() throws IOException {
        driver = new HTTPClient();
        apiResponse = driver.getCall(APIURI);
        String responseString = EntityUtils.toString(apiResponse.getEntity(),"UTF-8");
        JSONObject responseJson = new JSONObject(responseString);

        String responseValue = TestUtils.getValueByJPath(responseJson, "/per_page");

        assertEquals(responseValue, "3");

        assertEquals(TestUtils.getValueByJPath(responseJson, "/data[0]/first_name"), "George");
        assertEquals(TestUtils.getValueByJPath(responseJson, "/data[1]/last_name"), "Weaver");
        assertEquals(TestUtils.getValueByJPath(responseJson, "/data[2]/id"), "3");
    }
}
