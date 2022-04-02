package model;

import java.util.List;

public abstract class Physical {
	static final int SHAPE_CIRCLE = 0;
	static final int SHAPE_RECTANGLE = 1;
	
	static int id_total=0;
	
	boolean side;
	
	int id;
	int type_shape=1;
	
	double x;
	double y;
	double vx = 0;
	double vy = 0;
	double ax = 0;
	double ay = 0;
	double width;
	double height;
	
	double dx1;
	double dx2;
	double dy1;
	double dy2;
	
	boolean calculateCollision = false;
	boolean physics = true;
	
	public Physical(double _x, double _y) {
		id=id_total;
		id_total++;
		x=_x;
		y=_y;
		setBoxCollision();
	}
	
	public void setSpeed(double _vx, double _vy) {
		vx=_vx;
		vy=_vy;
	}
	
	public void setAcceleration(double _ax, double _ay) {
		ax=_ax;
		ay=_ay;
	}
	
	public void loop() {
		x+=vx;
		y+=vy;
		vx+=ax;
		vy+=ay;
		gravity();
		anim();
	}
	
	public abstract void setBoxCollision();
	
	public abstract void setTypeObject();
	
	public abstract void calculCollision(List<Displayable> objects);
	
	public abstract int actionCollisionPerso(int arg);

	public abstract void gravity();
	
	public void anim() {};

}
