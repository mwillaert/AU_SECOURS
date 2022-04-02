package model;

import java.util.LinkedList;
import java.util.List;

import controller.Controller;

public class Game {
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
		
		for (Displayable d : listComponents) {
			if (d.calculateCollision) {
				d.calculCollision(listComponents);
			}
			d.loop();
		}
		GameCamera.calculeCamera(p, Terrain.terrain1[0].length*Settings.SIZE_CASE);
		if (p.x>=(Terrain.terrain1[0].length-4)*32) {
			end=true;
		}
	}
	
	public static int[][] getTerrain() {
		return Terrain.terrain1;
	}
	
	public static List<Displayable> getListeDisplayable() {
		return listComponents;
	}
	
	public static void reinitialisation() {
		p = new Player(10,200);
		p.side=true;
		Slime s= new Slime(1200,100);
		listComponents.add(p);
		listComponents.add(s);
	}
	
	public static void remove(Displayable d) {
		toRemove.add(d);
	}
	
}
