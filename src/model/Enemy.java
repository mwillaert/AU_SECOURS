package model;

public abstract class Enemy extends Displayable {
	boolean dead;
	public Enemy(double _x, double _y) {
		super(_x, _y);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void loop() {
		super.loop();
		if (dead && conditionDeath()) {
			dissappear();
		}
	}
	public void death() {
		dead=true;
	}
	
	public void dissappear() {
		this.remove();
	}
	
	public abstract boolean conditionDeath();
	
	
}
