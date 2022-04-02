package model;

import java.util.List;

/**
 * Projectile tiré par le joueur
 */
public class Bullet extends Displayable {
    public final static int TYPE_ICE = 0;
    int typeBullet = 0;

    public Bullet(double _x, double _y, double vx, double vy, int type) {
        super(_x, _y);
        this.width = 5;
        this.height = 5;
        this.vx = vx;
        this.vy = vy;
    }

    @Override
    public void setBoxCollision() {

    }

    @Override
    public void setTypeObject() {

    }

    @Override
    public void calculCollision(List<Displayable> objects) {
        for (Displayable d : objects) {
            if (d instanceof Water) {
                this.remove();
                ((Water)d).changeState(Water.ICE_STATE);
            }
        }
    }

    @Override
    public int actionCollisionPerso(int arg, Player p) {
        return 0;
    }

    @Override
    public void gravity() {

    }
}
