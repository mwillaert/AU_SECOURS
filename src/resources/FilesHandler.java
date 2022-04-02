package resources;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class FilesHandler {
	public static void sauverImage(BufferedImage image,String nomImage) throws IOException
	{
		File nomfichier = new File("src/resources/" + nomImage + ".png");// ou jpg
		ImageIO.write(image, "PNG", nomfichier);//ou JPG
	}
}
