package model;

import java.awt.Rectangle;

public class Calculs {
	public static int collision(Physical p1, Physical p2, int speed_x, int speed_y) {
		Rectangle r1 = new Rectangle((int)(p1.x+p1.dx1)+speed_x, (int)(p1.y+p1.dy1)+speed_y, (int)(p1.width -p1.dx1-p1.dx2), (int)(p1.height -p1.dy1-p1.dy2));
		Rectangle r2 = new Rectangle((int)(p2.x+p2.dx1), (int)(p2.y+p2.dy1), (int)(p2.width -p2.dx1-p2.dx2), (int)(p2.height -p2.dy1-p2.dy2));
		Rectangle r21 = new Rectangle((int)(p2.x+p2.dx1), (int)(p2.y+p2.dy1)+(speed_y==0?10:(speed_y>0?10:-10)), (int)(p2.width -p2.dx1-p2.dx2), (int)(p2.height -p2.dy1-p2.dy2));
		Rectangle r22 = new Rectangle((int)(p2.x+p2.dx1), (int)(p2.y+p2.dy1)+(speed_y==0?10:(speed_y>0?10:-10)), (int)(p2.width -p2.dx1-p2.dx2), (int)(p2.height -p2.dy1-p2.dy2));
		Rectangle r23 = new Rectangle((int)(p2.x+p2.dx1)+2*speed_x, (int)(p2.y+p2.dy1+5), (int)(p2.width -p2.dx1-p2.dx2), (int)(p2.height -p2.dy1-p2.dy2));
		Rectangle r24 = new Rectangle((int)(p2.x+p2.dx1)+2*speed_x, (int)(p2.y+p2.dy1-5), (int)(p2.width -p2.dx1-p2.dx2), (int)(p2.height -p2.dy1-p2.dy2));

		if (CollisionTwoRectangle(r1,r2)) {
			if (CollisionTwoRectangle(r1,r21)) {
				return 3;
			}
			else if (CollisionTwoRectangle(r1,r22)) {
				return 4;
			}
			else if (CollisionTwoRectangle(r1,r23)) {
				return 1;
			}
			else if (CollisionTwoRectangle(r1,r24)) {
				return 2;
			}
		}
		return 0;
	}

	
	public static boolean CollisionTwoRectangle(Rectangle box1, Rectangle box2) {
		if	((box2.x >= box1.x + box1.width) || (box2.x + box2.width <= box1.x)
				|| (box2.y >= box1.y + box1.height) || (box2.y + box2.height <= box1.y))			
			{
				return false; 
			}					
			else
			{
				return true;	
			}	
	}
	
	public static int collisionTerrainV(Displayable p, int[][] terrain, double speedx, double speedy) {
		int px = (int)((p.x+speedx+p.dx1)/Settings.SIZE_CASE);
		int px2 = (int)((p.x+p.width+speedx-p.dx2)/Settings.SIZE_CASE);

		int pyu = (int)((p.y-3+speedy+p.dy1)/Settings.SIZE_CASE);
		int pyu2 = (int)((p.y-3+p.height+speedy-p.dy2)/Settings.SIZE_CASE);
		int pyd = (int)((p.y+3+speedy+p.dy1)/Settings.SIZE_CASE);
		int pyd2 = (int)((p.y+3+p.height+speedy-p.dy2)/Settings.SIZE_CASE);
		
		if (collisionTerrain(px,pyu,px2,pyu2,terrain)) {
			return 1;
		}
		if (collisionTerrain(px,pyd,px2,pyd2,terrain)) {
			return 2;
		}
		
		return 0;
	}
	
	public static int collisionTerrainH(Displayable p, int[][] terrain, double speedx, double speedy) {
		int py = (int)((p.y+speedy+p.dy1)/Settings.SIZE_CASE);
		int pxr = (int)((p.x-3+speedx+p.dx1)/Settings.SIZE_CASE);
		int pxl = (int)((p.x+3+speedx+p.dx1)/Settings.SIZE_CASE);
		int py2 = (int)((p.y+p.height+speedy-p.dy2)/Settings.SIZE_CASE);
		int pxr2 = (int)((p.x-3+p.width+speedx-p.dx2)/Settings.SIZE_CASE);
		int pxl2 = (int)((p.x+3+p.width+speedx-p.dx2)/Settings.SIZE_CASE);

		if (collisionTerrain(pxr,py,pxr2,py2,terrain)) {
			return 3;
		}
		if (collisionTerrain(pxl,py,pxl2,py2,terrain)) {
			return 4;
		}
		
		return 0;
	}
	
	public static boolean collisionTerrain(int x, int y, int x2, int y2, int[][] terrain) {
		
		if (terrain[y][x]!=0) {
			return true;
		}
		if (terrain[y2][x]!=0) {
			return true;
		}
		if (terrain[y][x2]!=0) {
			return true;
		}
		if (terrain[y2][x2]!=0) {
			return true;
		}
		return false;
	}
	
}
