package model;

import java.awt.Graphics2D;
import java.util.List;

import controller.Controller;
import resources.Resources;

public class Player extends Displayable {
	public static final int NOTHING = 0;
	public static final int ATTACK = 1;
	public static final int ATTACKED = 2;
	public static final int SIDE_LEFT = 3;
	public static final int SIDE_RIGHT = 4;
	public static final int SIDE_UP = 5;
	public static final int SIDE_DOWN = 6;
	
	static final int SPEED_MAX = 2;
	static final double DECELERATION = (double)SPEED_MAX/3.0*0.2;
	static final double ACC_WALL_JUMP = 0.3;
	static final double ACC_WALL = 0.2;
	static final double SPEED_WALL_JUMP = 2;
	static final double SPEED_JUMP = 3.5;
	static final double SPEED_SMALL_JUMP = 2.5;
	
	static final int SPEED_ANIM = 80;
	static final int WIDTH = 30;
	static final int HEIGHT = 30;
	
	private boolean accrocher = false;
	private boolean accrochel = false;
	private boolean aboveObject = false;

	public Player(double _x, double _y) {
		super(_x, _y, WIDTH, HEIGHT);
		listeImages = Resources.persoanim;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setBoxCollision() {
		// TODO Auto-generated method stub
		this.calculateCollision=true;
		this.dx1=4;
		this.dx2=4;
	}

	@Override
	public void setTypeObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void calculCollision(List<Displayable> objects) {
		//1.) Collision avec le terrain
		int collisionv = Calculs.collisionTerrainV(this,Game.getTerrain(),0,vy);
		if (collisionv==1) {
			vy=vy>0?vy:0;
		}
		else if (collisionv==2) {
			vy=vy<0?vy:0;
		}
		int collisionh = Calculs.collisionTerrainH(this,Game.getTerrain(),vx,0);
		if (collisionh==3) {
			vx=vx>0?vx:0;
		}
		else if (collisionh==4) {
			vx=vx<0?vx:0;
		}
		
		//2.) Collision avec les ennemis et les objets
		aboveObject=false;
		for (Displayable obj : objects) {	
			int collision = Calculs.collision(this, obj, (int)vx, (int)vy);
			if (collision!=0 && obj.id!=this.id) {

				this.actionObject(obj.actionCollisionPerso(collision, this));
				if (obj.physics) {
					if (collision==3||collision==4) {
						this.vx=0;
					}
					if (collision==1) {
						this.vy=0;
						aboveObject=true;
					}
					else if (collision==2) {
						this.vy=0;
						aboveObject=true;
					}

				}
			}			
		}
	}

	@Override
	public int actionCollisionPerso(int side, Player p) {
		// TODO Auto-generated method stub
		//Nothing happens
		return NOTHING;
	}

	@Override
	public void gravity() {
		// TODO Auto-generated method stub
		if (Settings.SAUT_MURAL) {
			gravity_wall_jump();
		}
		else {
			gravity_normal();
		}

	}
	
	public void gravity_normal() {
		if (vy<5) {
			ay=0.05;
		}
		else {
			ay=0;
		}
	}
	
	public void gravity_wall_jump() {
		if (accrocher==true || accrochel==true) {
			if (vy<-0.5)
				vy=0;
			ay=0.01;
		}
		else {
			gravity_normal();
		}
	}
	
	public void move_mural(boolean left) {
		int mult = left?-1:1;
		int collisionv = Calculs.collisionTerrainH(this,Game.getTerrain(),mult*20,0);			
		if (collisionv!=0) {
			int collisionh = Calculs.collisionTerrainH(this,Game.getTerrain(),-mult*5,35);
			int collisionh2 = Calculs.collisionTerrainV(this,Game.getTerrain(),mult*20,-63);
			if (collisionh==0 && collisionh2 !=0)
				if (left)
					accrochel=true;
				else
					accrocher=true;
			else 
				if (left) 
					accrochel=false;
				else 
					accrocher=false;
		}
		else {
			if (left) 				
				accrochel=false;
			else 
				accrocher=false;
		}
		
		if (left) {
			if (accrocher) {
				accrocher=false;
			}
		}
		else {
			if (accrochel) {
				accrochel=false;
			}
		}
	}
	
	public void move_direction(boolean left) {
		int mult = left?-1:1;

		if ((left && vx>=mult*SPEED_MAX) || (!left && vx<=mult*SPEED_MAX)) {
			ax=mult*DECELERATION;
		}
		else {
			ax=0;
			vx=mult*SPEED_MAX;
		}

	}
	
	public void handle_mural_wall() {
		if (accrocher) {
			int collisionv = Calculs.collisionTerrainH(this,Game.getTerrain(),20,0);			
			if (collisionv==0) {
				accrocher=false;
			}
		}
		if (accrochel) {
			int collisionv = Calculs.collisionTerrainH(this,Game.getTerrain(),-20,0);			
			if (collisionv==0) {
				accrochel=false;
			}
		}
	}
	
	public void move(boolean keyl, boolean keyr, boolean keyu) {
		if (keyl) {
			if (Settings.SAUT_MURAL)
				move_mural(true);
			move_direction(true);
		}
		else if (keyr) {
			if (Settings.SAUT_MURAL)
				move_mural(false);
			move_direction(false);
		}
		else {
			if (Math.abs(vx)>0.05) {
				ax=vx>0?-0.05:0.05;
			}
			else {
				ax=0;
				vx=0;
			}		
			
			if (Settings.SAUT_MURAL) {
				handle_mural_wall();
			}

		}
		
		if (keyu) {
			int collisionv = Calculs.collisionTerrainV(this,Game.getTerrain(),0,10);
			System.out.println(aboveObject);
			if (collisionv==1 || aboveObject) {
				jump();
			}
			if (Settings.SAUT_MURAL) {
				if (accrocher == true || accrochel == true) {
					wall_jump();
				}
			}
		}
	}

	public void jump() {
		vy=-SPEED_JUMP;
	}
	
	public void small_jump() {
		vy=-SPEED_SMALL_JUMP;
	}
	
	public void wall_jump() {
		if (accrocher) {
			ax=-ACC_WALL_JUMP;
			vy=-SPEED_WALL_JUMP;
			side=!side;
		}
		if (accrochel) {
			ax=ACC_WALL_JUMP;
			vy=-SPEED_WALL_JUMP;
			side=!side;
		}
		accrocher=false;
		accrochel=false;
	}
	
	@Override
	public void anim() {
		if (Settings.SAUT_MURAL) {
			anim_wall_jump();
		}
		else {
			anim_normal();
		}

	}
	
	public void anim_normal() {
		if (vy<=0.05 && vy>=-0.05) {
			if (vx==0) {
				idAnim = 4;
			}
			else {
				if (Math.abs(ax)<=0.05 && ay!=0)
					side=Math.abs(vx)>0.2?vx>0:side; 
				anim++;
				if (anim>=SPEED_ANIM) {
					anim=0;
				}
				idAnim = (int)((double)anim/((double)SPEED_ANIM/4));
			}
		}
		else {
			if (Math.abs(ax)<=0.05 && ay!=0)
				side=Math.abs(vx)>0.2?vx>0:side; 
			anim++;
			if (anim>=SPEED_ANIM*3) {
				anim=0;
			}
			idAnim = (int)((double)anim/((double)(SPEED_ANIM*3)/4));
		}
	}
	
	public void anim_wall_jump() {
		if (!accrochel && !accrocher) 
			anim_normal();
		else {
			idAnim++;
			if (idAnim<5 || idAnim>8) {
				idAnim=5;
			}			
			if (accrochel) {
				side=false;
			}
			else {
				side=true;
			}
		}
	}
	
	private void actionObject(int arg) {
		switch (arg) {
		case ATTACK :
			this.small_jump();
		case ATTACKED : 
			this.small_jump();
		}
	}

}
