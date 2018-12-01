import org.junit.Before;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Arrays;

public class TestGETExchange {
    private RestTemplate template;
    private String url = "https://jsonview.com/example.json";

    @Before
    public void setUp(){
        template = new RestTemplate();
    }

    @Test
    public void test(){
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> requestEntity = new HttpEntity<String>(requestHeaders);

        ResponseEntity<String> response = template.exchange(url, HttpMethod.GET, requestEntity, String.class);
        String body = response.getBody();
        System.out.println(body);

        MediaType responseHeader = response.getHeaders().getContentType();
        System.out.println("Response Content - Type: " + responseHeader);
    }
}
