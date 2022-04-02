package model;

import java.awt.*;
import java.util.List;

public class Water extends Displayable {
    static final int ICE_STATE = 0;
    static final int WATER_STATE = 1;
    static final int EXPANSION_HORIZONTAL = 0;
    static final int EXPANSION_VERTICAL = 1;

    int stateExpansion = EXPANSION_VERTICAL;
    int stateWater = WATER_STATE;
    Water wChildren = null;
    Water wParent = null;
    int xchild;
    int wchild;
    public Water(double _x, double _y, int xchild, int wchild) {
        super(_x, _y);
        this.width=30;
        this.height = 10;
        this.xchild = xchild;
        this.wchild = wchild;
    }

    @Override
    public void display(Graphics2D g) {
        if (stateWater == WATER_STATE) {
            AlphaComposite alcom2 = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 0.5f);
            g.setComposite(alcom2);
            g.setColor(Color.BLUE);
            g.fillRect((int)x+GameCamera.x,(int)y+5,(int)width,(int)height);
            AlphaComposite alcom3 = AlphaComposite.getInstance(
                    AlphaComposite.SRC_OVER, 1f);
            g.setComposite(alcom3);
        }
        else {
            g.setColor(Color.BLUE.brighter());
            g.fillRect((int)x+GameCamera.x,(int)y+5,(int)width,(int)height);
        }

    }

    @Override
    public void setBoxCollision() {
        this.calculateCollision=false;
        this.physics=false;
        this.dx1=-4;
        this.dx2=-4;
    }

    @Override
    public void setTypeObject() {

    }

    public boolean expandWaterHorizontally() {
        int collisionh = Calculs.collisionTerrainH(this,Game.getTerrain(),-8,0);

        if (collisionh!=3 && collisionh != 4) {
            this.width+=1;
            this.x-=0.5;
            this.height-=1;
            this.y+=1;
        }
        else if (this.x>this.wParent.xchild) {
            this.width+=1;
            this.x-=1;
            this.height-=1;
            this.y+=1;
        }
        else if (this.width<this.wParent.wchild) {
            this.width+=1;
            this.height-=1;
            this.y+=1;
        }

        return true;
    }

    public boolean expandWaterVertically() {
        int collisionv = Calculs.collisionTerrainV(this,Game.getTerrain(),0,1);
        if (collisionv!=1 && collisionv!=2) {
            this.height+=1;
        }
        else {
            if (this.wChildren==null) {
                this.wChildren = new Water(this.x, this.y + this.height - 64, 0, 0);
                wChildren.height = 64;
                wChildren.wParent = this;
                wChildren.stateExpansion=EXPANSION_HORIZONTAL;
                Game.addObject(wChildren);
            }
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
    public int actionCollisionPerso(int arg) {
        return 0;
    }

    @Override
    public void gravity() {
        if (this.stateWater==WATER_STATE) {
            if (stateExpansion==EXPANSION_VERTICAL) {
                expandWaterVertically();
            }
            else if (stateExpansion==EXPANSION_HORIZONTAL) {
                expandWaterHorizontally();
            }
        }
    }

    public void changeState(int dx, int dy) {
        if (this.stateWater==WATER_STATE) {
            if (this.stateExpansion==EXPANSION_VERTICAL) {
                if (Math.abs(this.y-dy)<=32) {
                    this.height=32;
                }
                else {
                    this.height=Math.abs(this.y-dy);
                }
                this.physics=true;
                this.calculateCollision=true;
                this.stateWater=ICE_STATE;
            }
            else {
                this.physics=true;
                this.calculateCollision=true;
                this.stateWater=ICE_STATE;
            }

        }

    }
}
