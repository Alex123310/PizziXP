package pizzixp;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

public class URLtoBufferedImage
{
    public static BufferedImage convert(URL url)
    {
        try
        {
            return ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read in the pic");
        }
    }
}