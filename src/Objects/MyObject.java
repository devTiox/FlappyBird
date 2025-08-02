package Objects;

import Animation.GameWindow;

import java.awt.*;

public abstract class MyObject {
    protected static boolean gameOver = false;
    public static int points = 0;
    public int positionX;
    public int positionY;
    protected final Dimension size;
    public final int sizeX;
    protected final int sizeY;
    protected final static int maxY = GameWindow.screenHeight - GameWindow.screenHeight/5 - GameWindow.screenHeight/10 ;
    protected final static int minY = GameWindow.screenHeight/10;

    public MyObject(int positionX, int positionY, int sizeX, int sizeY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        size = new Dimension(sizeX,sizeY);
    }


    public static boolean isGameOver(){
        return gameOver;
    }

    public static void gameReset(){
        points = 0;
        gameOver = false;
    }

}
