package view;

import game.Game;
import object.ObjectGame;

import javax.swing.*;
import java.awt.*;

public class Camera extends JPanel {
    public void paint(Graphics g) {
        g.setColor(Resources.BACKGROUND_COLOR);
        g.fillRect(0,0,600,400);
        for (ObjectGame og : Game.getInstance().getListObjectGame()) {
            og.draw(g);
        }
    }
}
