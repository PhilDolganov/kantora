package com.rest.client;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HTTPClient {

    //1.GET call
    public CloseableHttpResponse getCall(String url) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet getCall = new HttpGet(url); // REST get Call
        CloseableHttpResponse response = httpClient.execute(getCall);

        return response;
//        //A. Extracting the Response Code
//        int statusCode = response.getStatusLine().getStatusCode();
//        System.out.println("Status Code is : " + statusCode);
//
//        //B. Getting Response JSON
//        String responseString = EntityUtils.toString(response.getEntity(),"UTF-8");
//        JSONObject responseJson = new JSONObject(responseString);
//        System.out.println("API Response JSON : " + responseJson);
//
//        // C. Getting Response Headers
//        Header[] responseHeaders = response.getAllHeaders();
//
//        HashMap<String,String> headerAll = new HashMap<String, String>();
//
//        for (Header header: responseHeaders) {
//            headerAll.put(header.getName(), header.getValue());
//        }
//
//        System.out.println("All Headers are : " + headerAll);
    }
}
