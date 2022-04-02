package game;

import object.ObjectGame;

import java.util.LinkedList;
import java.util.List;

public class Game implements Runnable {
    List<ObjectGame> listObjectGame = new LinkedList<>();
    private static Game instanceGame;

    private Game() {

    }

    public static Game getInstance() {
        return instanceGame;
    }

    public void run() {
        while(true) {
            try {
                Thread.sleep(5);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<ObjectGame> getListObjectGame() {
        return this.listObjectGame;
    }

}
