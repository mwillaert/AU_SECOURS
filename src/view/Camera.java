package view;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import model.Displayable;
import model.Game;
import model.GameCamera;
import model.Settings;
import model.Terrain;
import resources.Resources;

public class Camera extends JPanel {
	float alpha = 1.0f;
	int timer = 0;
	int timerMax = 500;
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		for (int i = 0; i<4; i++) {
			g2d.drawImage(Resources.background[i], (int)(i*(GameCamera.x/20)), 0,null);
		}
	
		g2d.drawImage(Resources.level, GameCamera.x,0,null);
		
		for (Displayable d : Game.getListeDisplayable()) {
			d.display(g2d);
		}
		g2d.drawImage(Resources.gradient, GameCamera.x,0,null);

	}

	
}
