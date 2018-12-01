package com.easybix.RestAssuredCore;

import com.easybix.utils.TestUtils;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import static org.testng.Assert.*;

public class BaseAssertions {

    private static Logger log = LogManager.getLogger(BaseAssertions.class.getName());

    public static void verifyTrue(boolean flag){
        assertTrue(flag);
    }

    public static void verifyFalse(boolean flag){
        assertFalse(flag);
    }

    public static void verifyStatusCode(Response response, int status){
        assertEquals(TestUtils.getStatusCode(response),status);
    }

    public static void verifyStatusMessage(Response response, String status){
        assertEquals(TestUtils.getStatusCode(response),status);
    }
}
