package model;

import java.awt.Graphics2D;
import java.awt.Image;
import java.util.List;

import resources.Resources;

public abstract class Displayable extends Physical {
	Image[] listeImages;
	
	int anim=0;
	int idAnim=0;

	public Displayable(double _x, double _y) {
		super(_x, _y);
		// TODO Auto-generated constructor stub
	}

	public Displayable(double _x, double _y, double _w, double _h) {
		super(_x, _y);
		width=_w;
		height=_h;
		// TODO Auto-generated constructor stub
	}

	public void display(Graphics2D g) {
		g.drawImage(listeImages[idAnim],(int)x+GameCamera.x+(side?0:1)*(int)width,(int)y+5,(side?1:-1)*(int)width,(int)height,null);
		
	}
	

	public void remove() {
		Game.remove(this);
	}
}
