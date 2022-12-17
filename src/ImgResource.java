import java.io.File;
import java.io.IOException;
// import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
public class ImgResource {
    public static BufferedImage get(String fileName) throws IOException {
        BufferedImage img = ImageIO.read(new File(Resource.getResourcePath(fileName)));
        return img;
    }
}
