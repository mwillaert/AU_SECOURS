package model;

import java.util.List;

public class IceShooter extends Displayable {
    public IceShooter(double _x, double _y, double _w, double _h) {
        super(_x, _y, _w, _h);
        this.width=30;
        this.height=30;
    }

    @Override
    public void setBoxCollision() {
        this.physics=false;
        this.calculateCollision=false;
    }

    @Override
    public void setTypeObject() {

    }

    @Override
    public void calculCollision(List<Displayable> objects) {
        for (Displayable d : objects) {
            if (d instanceof Player) {

            }
        }
    }

    @Override
    public int actionCollisionPerso(int arg, Player p) {
        return 0;
    }

    @Override
    public void gravity() {
        if (vy<5) {
            ay=0.05;
        }
        else {
            ay=0;
        }
    }
}
