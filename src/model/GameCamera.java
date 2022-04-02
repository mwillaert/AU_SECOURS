package model;

public class GameCamera {
	
	static final int MID_X = 300;
	
	public static int x;
	public static int y;
	
	public static void calculeCamera(Displayable d, int length) {
		if (d.x<MID_X) {
			x=0;
		}
		else if (d.x>length-Settings.SIZE_SCREEN_X+MID_X-32*4) {
			x=(int)(-(length-Settings.SIZE_SCREEN_X-32*4));
		}
		else {
			x=(int)(MID_X-d.x);
		}
	}
}
