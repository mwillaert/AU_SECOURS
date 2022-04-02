package model;

public class Level {
    public static int currentLevel=1;

    public void handleLevel(){
        //numLevel donne le niveau ou on est
        switch (currentLevel) {
            case 1 :
                this.handleLevel1();
        }
    }

    public static void handleLevel1(){
        //Generation aleatoire de meteorites
        //Terrain.terrain1[0].length*Settings.SIZE_CASE;

    }

    public static void generateMeteor(){
        Game.getTerrain();

    }

}
