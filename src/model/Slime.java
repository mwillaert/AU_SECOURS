package model;

import java.util.List;

import resources.Resources;

public class Slime extends Enemy{
	static final int SIZE = 43;
	static final int SPEED_ANIM = 30;
	static final int SPEED_ANIM_DEATH = 2;
	int timer = 0;
	int timer2 = 0;
	
	public Slime(double _x, double _y) {
		super(_x, _y);
		this.width = SIZE;
		this.height = SIZE;
		this.listeImages = Resources.slimeanim;
		this.vx = 0.5;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setBoxCollision() {
		// TODO Auto-generated method stub
		this.dx1=10;
		this.dx2=10;
		this.dy1=15;
		this.calculateCollision=true;
		this.physics=false;
	}

	@Override
	public void setTypeObject() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void loop() {
		super.loop();
		if (vx==0) {
			vx=-0.5;
		}
		timer ++;
		if (timer>=1000) {
			this.vx*=-1;
			timer=0;
		}
		timer2++;
		if (timer2>=200) {
			this.jump();
			timer2=0;
		}
	}
	
	@Override
	public void calculCollision(List<Displayable> objects) {
		// TODO Auto-generated method stub
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
	}

	@Override
	public int actionCollisionPerso(int side) {
		// TODO Auto-generated method stub
		if (side==2) {
			this.death();
			return Player.ATTACK;
		}
		return Player.ATTACKED;
	}

	@Override
	public void gravity() {
		// TODO Auto-generated method stub
		if (vy<5) {
			ay=0.05;
		}
		else {
			ay=0;
		}
	}
	
	@Override
	public void anim() {
		if (!dead) {
			anim++;
			if (anim>SPEED_ANIM) {
				idAnim++;
				if (idAnim>3) {
					idAnim=0;
				}	
				anim=0;
			}
		}
		else {
			anim++;
			if (anim>SPEED_ANIM_DEATH) {
				idAnim++;
				if (idAnim<=3) {
					idAnim=3;
				}	
				if (idAnim>=8) {
					idAnim=8;
				}	
				anim=0;
			}
		}


	}
	
	public void jump() {
		this.vy=-1;
	}

	@Override
	public boolean conditionDeath() {
		// TODO Auto-generated method stub
		return idAnim==8;
	}

}
