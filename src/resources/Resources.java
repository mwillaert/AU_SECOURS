package resources;

import model.Terrain;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Resources {
	public static Image[] background = new Image[4];
	public static Image[] blocs = new Image[17];
	public static Image[] persoanim = new Image[9];
	public static Image[] slimeanim = new Image[9];
	public static Image gradient;
	public static Image title;
	public static Image credits;
	public static Image level;
	
	public static void loadResources() {
		try {
			for (int i = 0;i<4;i++) {
				background[i] = ImageIO.read(new File("src/resources/background"+ (i+1) + ".png"));
			}
			
			for (int i = 0;i<17;i++) {
				blocs[i]=ImageIO.read(new File("src/resources/bloc"+(i+1)+".png"));
			}
			for (int i = 0;i<9;i++) {
				persoanim[i] = ImageIO.read(new File("src/resources/persoanim"+ (i+1) + ".png"));
			}
			for (int i = 0;i<9;i++) {
				slimeanim[i] = ImageIO.read(new File("src/resources/slimeanim"+ (i+1) + ".png"));
			}
			Terrain.genereImageTerrain();
			level=Terrain.imageTerrain;
			gradient=ImageIO.read(new File("src/resources/gradient.png"));
			title = ImageIO.read(new File("src/resources/title.png"));
			credits = ImageIO.read(new File("src/resources/tobecontinued.png"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
