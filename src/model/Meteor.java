package model;
public class Meteor extends Displayable{
    public Meteor(double _x, double _y, double _speedx, double _speedy) {
        super(_x, _y);
        this.width=30;
        this.height = 10;
        this.setSpeed(_speedx,_speedy);
    }
}
