package model;

public class Level {
    public static int currentLevel=1;

    public static long dateLastMeteor=System.currentTimeMillis();
    public static int minMeteorInterval=5000;
    public static int maxMeteorInterval=10000;
    public static int timeUntilMeteor=1000;

    public void handleLevel(){
        //numLevel donne le niveau ou on est
        switch (currentLevel) {
            case 1 :
                Level.handleLevel1();
        }
    }

    public static void handleLevel1(){
        long timeInterval=System.currentTimeMillis()-dateLastMeteor;
        System.out.println(timeInterval);
        if (timeInterval>=timeUntilMeteor){
            generateRandomMeteor();
            dateLastMeteor=System.currentTimeMillis();
        }
        //Generation aleatoire de meteorites
        //Terrain.terrain1[0].length*Settings.SIZE_CASE;

    }

    public static void generateRandomMeteor(){
        Game.getTerrain();
        int posx=(int)(Math.random()*Settings.SIZE_SCREEN_X/2+GameCamera.x);
        Meteor m= new Meteor(posx,0,-1,1);
        Game.addObject(m);

    }

}
