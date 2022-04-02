package model;

import java.util.List;

public class Meteor extends Displayable{
    public Meteor(double _x, double _y, double _speedx, double _speedy) {
        super(_x, _y);
        this.width=30;
        this.height = 10;
        this.setSpeed(_speedx,_speedy);
    }

    @Override
    public void setBoxCollision() {

    }

    @Override
    public void setTypeObject() {

    }

    @Override
    public void calculCollision(List<Displayable> objects) {

    }

    @Override
    public int actionCollisionPerso(int arg, Player p) {
        return 0;
    }

    @Override
    public void gravity() {

    }
}
