package model;

import java.awt.*;
import java.util.List;

public class Meteor extends Displayable{
    public Meteor(double _x, double _y, double _speedx, double _speedy) {
        super(_x, _y);
        this.width=20;
        this.height = 20;
        this.setSpeed(_speedx,_speedy);
    }

    @Override
    public void loop(){
        super.loop();
        if (this.x<=5-GameCamera.x){
            this.remove();
        }
    }

    public void display(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x+GameCamera.x,(int)y+5,(int)width,(int)height);
    }

    @Override
    public void setBoxCollision() {
        this.calculateCollision=true;
        this.physics=false;
    }

    @Override
    public void setTypeObject() {

    }

    @Override
    public void calculCollision(List<Displayable> objects) {
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
    public int actionCollisionPerso(int arg) {
        return 0;
    }

    @Override
    public void gravity() {

    }
}
