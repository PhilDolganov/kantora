package com.easybix.Issue;

import com.easybix.RestAssuredCore.BaseAssertions;
import com.easybix.RestAssuredCore.BaseTest;
import com.easybix.RestAssuredCore.RESTCalls;
import com.easybix.utils.PayloadGenerator;
import com.easybix.utils.TestUtils;
import com.easybix.utils.URL;
import io.restassured.response.Response;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateIssue {

    private String sessionID;
    Response response;
    private static Logger log = LogManager.getLogger(CreateIssue.class.getName());

    @BeforeMethod
    public void setUp(){
        sessionID = BaseTest.doLogin();
    }

    @Test
    public void createIssue(){
        log.info("Starting Create Issue Test");
        String URI = URL.getEndPoint("/rest/api/2/issue/");
        String createIssuePayload = PayloadGenerator.generatePayloadString("CreateBug.json");
        response = RESTCalls.POSTRequest(URI, createIssuePayload, sessionID);
        BaseAssertions.verifyStatusCode(response,201);
    }
}
