import junitparams.FileParameters;
import junitparams.JUnitParamsRunner;
import junitparams.mappers.CsvWithHeaderMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
@RunWith(JUnitParamsRunner.class)
public class TestGETwithParameters {

    private RestTemplate template;
    private String url = "http://api.openweathermap.org/data/2.5/weather?q={q}&appid={appid}";
    @Before
    public void setUp(){
        template = new RestTemplate();

    }

    @Test
    @FileParameters(value = "file:C:/Users/phild_000/IdeaProjects/cities.csv", mapper = CsvWithHeaderMapper.class)
    public void test(String city){
        HashMap<String, String> vars = new HashMap<String, String>();
        vars.put("q", city);
        vars.put("appid", "c1ff33de9de7cc2f8379eeb6f8333881");

        String response = template.getForObject(url, String.class, vars);
        System.out.println(response);
    }
}
