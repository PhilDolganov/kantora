
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;

public class TestJSONSimple {

    private String service = "http://maps.googleapis.com";
    private String resource = "/maps/api/geocode/{format}";
    private String params = "?address={address}&sensor={sensor}";
    private String url = service + resource + params;
    private String response;

    @Before
    public void setUp() throws Exception {
        HashMap<String, String> vars = new HashMap<String, String>();
        vars.put("format","json");
        vars.put("address","1600 Amphitheatre Parkway, Mountain View, CA");
        vars.put("sensor","false");

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

        HttpEntity<String> entity = new HttpEntity<String>(headers);
        RestTemplate template = new RestTemplate();
        response = template.postForObject(url, entity, String.class, vars);
    }
    @Test
    public void test(){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject = (JSONObject)parser.parse(response);
        } catch (ParseException e){
            e.printStackTrace();
        }
        String status = (String) jsonObject.get("status");
        System.out.println(response);
        assertEquals("OK", status);
    }
}
