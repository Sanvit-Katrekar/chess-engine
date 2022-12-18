import java.nio.file.Path;
public class Resource{
    public static String getResourcePath(String fileName) {
        String base = Path.of("src", "assets").toString();
        if (fileName.endsWith(".png")) {
            return Path.of(System.getProperty("user.dir"), base, "images", fileName).toString();
        }
        return base;
    }
}
