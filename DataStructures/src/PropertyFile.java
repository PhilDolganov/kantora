import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFile {
    public static void main (String[] args) throws IOException {
        Properties prop = new Properties();
        prop.load(new FileInputStream("C:/Users/phild_000/IdeaProjects/kv.config"));
        String browser = prop.getProperty("browser");
        String server = prop.getProperty("server");
        System.out.println(browser);
        System.out.println(server);

    }
}
