import java.io.IOException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import java.io.File;

public class ImgResource extends JLabel {
    String imgName;
    int width;
    int height;
    public ImgResource(String imgName) throws IOException {
        super();
        this.imgName = imgName;
        this.setIcon(this.get());
    }
    public ImgResource(String imgName, int x, int y, int w, int h) throws IOException {
        super();
        this.imgName = imgName;
        this.width = w;
        this.height = h;
        this.setIcon(this.getScaled());
    }
    public ImageIcon get() throws IOException {
        ImageIcon img = new ImageIcon(Resource.getResourcePath(imgName));
        return img;
    }
    public ImageIcon getScaled() throws IOException {
        ImageIcon img = new ImageIcon(Resource.getResourcePath(imgName));
        Image scaled = img.getImage().getScaledInstance(this.width, this.height, java.awt.Image.SCALE_SMOOTH);
        ImageIcon scaledImg = new ImageIcon(scaled);
        return scaledImg;
    }
    public BufferedImage getBuff() throws IOException {
        BufferedImage img = ImageIO.read(new File(Resource.getResourcePath(imgName)));
        return img;
    }
}
