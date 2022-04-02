package object;

import java.awt.*;

public abstract class ObjectGame {
    //position, vitesse et accélération
    int x, y;
    int vx, vy;
    int ax, ay;

    //Image
    String imageName;

    public ObjectGame(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public void handleObject() {
        x+=vx;
        y+=vy;
        vx+=ax;
        vy+=ay;
    }

    public abstract void draw(Graphics g);
}
