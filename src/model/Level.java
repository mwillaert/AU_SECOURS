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

    public static void generateRandomMeteor(){
        Game.getTerrain();
        int posx=(int)(Math.random()*Settings.SIZE_SCREEN_X/2+GameCamera.x);
        Meteor m= new Meteor(posx,0,-10,10);
        Game.addObject(m);

    }

}
