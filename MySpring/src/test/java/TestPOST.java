import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class TestPOST {
    private String url = "http://www.htmlgoon.com/api/POST_JSON_Service.php";
    private RestTemplate template;
    @Before
    public void setUp(){
        template = new RestTemplate();
    }

    @Test
    public void test(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("firstname", "Vlad");
        map.put("lastname", "B");
        map.put("city", "Los Altos");

        HttpEntity<HashMap<String,String>> requestEntity = new HttpEntity<HashMap<String, String>>(map,requestHeaders);
        String response = template.postForObject(url,requestEntity, String.class);
        System.out.println(response);

    }
}
