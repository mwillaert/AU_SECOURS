package model;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

import controller.Controller;

public class Game {
	static List<Displayable> toAdd = new LinkedList<>();
	static List<Displayable> toRemove = new LinkedList<>();
	static List<Displayable> listComponents = new LinkedList<>();
	static Player p;
	public static boolean end;
	public static boolean cont = true;
	
	public static void loop() {
		p.move(Controller.left_pressed, Controller.right_pressed, Controller.up_pressed);
		for (Displayable d : toRemove) {
			listComponents.remove(d);
		}
		toRemove.clear();
		for (Displayable d : toAdd) {
			listComponents.add(d);
		}
		toAdd.clear();
		for (Displayable d : listComponents) {
			if (d.calculateCollision) {
				d.calculCollision(listComponents);
			}
			d.loop();
		}

		GameCamera.calculeCamera(p, Terrain.terrain1[0].length*Settings.SIZE_CASE);
		if (p.x>=(Terrain.terrain1[0].length-4)*32) {
			end = true;
		}
		if (p.y>=(Terrain.terrain1.length-2)*32) {
			Point finalPoint = new Point();
			for (Point point : Terrain.listPointsSave) {
				if (point.x<p.x) {
					finalPoint = point;
				}
			}
			p.x=finalPoint.x;
			p.y=finalPoint.y;
		}

	}
	
	public static int[][] getTerrain() {
		return Terrain.terrain1;
	}
	
	public static List<Displayable> getListeDisplayable() {
		return listComponents;
	}

	public static void addObject(Displayable d) {
		listComponents.add(d);
	}
	
	public static void reinitialisation() {
		p = new Player(10,200);
		p.side=true;
		Water eau = new Water(90,200);
		listComponents.add(eau);
		listComponents.add(p);
	}

	public static void click(int x, int y) {
		double vx = (x-p.x)/100.0;
		double vy = (y-p.y)/100.0;
		Bullet b = new Bullet(p.x,p.y,vx,vy, Bullet.TYPE_ICE);
		listComponents.add(b);
		System.out.println("azefzg");
	}

	public static void remove(Displayable d) {
		toRemove.add(d);
	}

	public void handleLevel(int numLevel){
		//numLevel donne le niveau ou on est
		switch (numLevel) {
			case 1 :
				this.handleLevel1();
		}
	}

	public static void handleLevel1(){
		//Generation aleatoire de meteorites

	}

}
