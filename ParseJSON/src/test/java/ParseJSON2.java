import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParseJSON2 {
    @Test
    public void test() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(new HttpGet("https://en.wikipedia.org/w/api.php?action=opensearch&search=russia"));
        String body = EntityUtils.toString(response.getEntity());
        System.out.println(body);

        int status_code = response.getStatusLine().getStatusCode();
        assertEquals(200, status_code);

        JSONArray jsonArray = new JSONArray(body);

        String element0 = jsonArray.get(0).toString();
        System.out.println(element0);
        assertEquals("russia", element0);
    }
}
