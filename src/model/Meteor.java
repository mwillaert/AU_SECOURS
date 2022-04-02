package model;

<<<<<<< HEAD
=======
import java.awt.*;
>>>>>>> 8d47340f84c4396163ba423090d6f8e64eb2cd95
import java.util.List;

public class Meteor extends Displayable{
    public Meteor(double _x, double _y, double _speedx, double _speedy) {
        super(_x, _y);
        this.width=30;
        this.height = 10;
        this.setSpeed(_speedx,_speedy);
    }

    @Override
<<<<<<< HEAD
    public void setBoxCollision() {
=======
    public void display(Graphics2D g) {
        g.setColor(Color.ORANGE);
        g.fillRect((int)x+GameCamera.x,(int)y+5,(int)width,(int)height);
>>>>>>> 8d47340f84c4396163ba423090d6f8e64eb2cd95

    }

    @Override
<<<<<<< HEAD
=======
    public void setBoxCollision() {
        this.calculateCollision=true;
        this.physics=false;
    }

    @Override
>>>>>>> 8d47340f84c4396163ba423090d6f8e64eb2cd95
    public void setTypeObject() {

    }

    @Override
    public void calculCollision(List<Displayable> objects) {
<<<<<<< HEAD
=======
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

>>>>>>> 8d47340f84c4396163ba423090d6f8e64eb2cd95

    }

    @Override
    public int actionCollisionPerso(int arg, Player p) {
        return 0;
    }

    @Override
    public void gravity() {
<<<<<<< HEAD

=======
>>>>>>> 8d47340f84c4396163ba423090d6f8e64eb2cd95
    }
}
