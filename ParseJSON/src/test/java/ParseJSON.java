
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.*;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class ParseJSON {

    @Test
    public void test() throws IOException {
        HttpClient client = HttpClientBuilder.create().build();

        HttpResponse response = client.execute(new HttpGet("http://jsonplaceholder.typicode.com/posts/1/comments"));
        String body = EntityUtils.toString(response.getEntity());
        System.out.println(body);

        int status_code = response.getStatusLine().getStatusCode();
        assertEquals(200, status_code);

        JSONArray  jsonArray = new JSONArray(body);
        JSONObject element0 = jsonArray.getJSONObject(0);
        int id0 = element0.getInt("id");
        String email0 = element0.getString("email");
        assertEquals(1,id0);
        assertEquals("Eliseo@gardner.biz",email0);

        JSONObject element4 = jsonArray.getJSONObject(4);
        int id4 = element4.getInt("id");
        String email4 = element4.getString("email");
        assertEquals(5,id4);
        assertEquals("Hayden@althea.biz",email4);

    }
}
