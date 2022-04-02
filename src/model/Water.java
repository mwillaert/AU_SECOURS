package model;

import java.awt.*;
import java.util.List;

public class Water extends Displayable {
    int volume;
    public Water(double _x, double _y) {
        super(_x, _y);
        this.width=30;
        this.height = 10;
        volume = (int)(width*height);
    }

    @Override
    public void display(Graphics2D g) {
        g.setColor(Color.BLUE);
        g.fillRect((int)x+GameCamera.x,(int)y+5,(int)width,(int)height);
    }

    @Override
    public void setBoxCollision() {
        this.calculateCollision=false;
        this.physics=false;
    }

    @Override
    public void setTypeObject() {

    }

    public boolean expandWaterHorizontally() {
        this.width+=2;
        this.x-=1;
        this.height+=2;
        this.y+=2;
        int collisionh = Calculs.collisionTerrainH(this,Game.getTerrain(),vx,0);
        if (collisionh==3 && collisionh == 4) {
            this.width-=2;
            this.x+=1;
            this.height+=2;
            this.y-=2;
            return false;
        }
        else if (collisionh==3) {

        }
        return true;
    }

    public boolean expandWaterVertically() {
        int collisionv = Calculs.collisionTerrainV(this,Game.getTerrain(),0,1);
        if (collisionv!=1 && collisionv!=2) {
            this.height+=1;
        }
        return true;
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
    public int actionCollisionPerso(int arg, Player p) {
        return 0;
    }

    @Override
    public void gravity() {
        expandWaterVertically();
    }

}
