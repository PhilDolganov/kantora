import org.junit.Test;
import org.springframework.web.client.RestTemplate;

public class TestGet {
    @Test
    public void test(){
        RestTemplate template = new RestTemplate();
        String response = template.getForObject("https://jsonview.com/example.json", String.class);
        System.out.println(response);
    }
}
