package controller;

public class Controller {
	public static boolean left_pressed;
	public static boolean right_pressed;
	public static boolean up_pressed;
	public static boolean down_pressed;
	
	public static void handleControls(int key, boolean pressed) {
		if (key==37) {
			left_pressed=pressed;
		}
		if (key==38) {
			up_pressed=pressed;
		}
		if (key==39) {
			right_pressed=pressed;
		}
		if (key==40) {
			down_pressed=pressed;
		}
	}
	
}
