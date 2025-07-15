package Objects;

import java.awt.*;

public class Bird{
    private final int positionX;
    private int positionY;
    private final int startinVelocity;
    private final int jumpPower;
    private final Dimension size;
    private final int sizeX;
    private final int sizeY;
    private final int maxY;
    private final int minY;
    private boolean gameOver = false;
    private int velocity;
    private int acceleration;

    public Bird(){
        positionX = 150;
        positionY = 150;
        startinVelocity = 1;
        velocity = startinVelocity;
        jumpPower = 40* startinVelocity;
        sizeX = 50;
        sizeY=50;
        maxY=450;
        minY=-50;
        size = new Dimension(sizeX,sizeY);
    }

    public Dimension getSize() {
        return size;
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void jump(){
        positionY -= jumpPower;
        velocity = startinVelocity;
    }

    public void spaceAction(){
        if(positionY >= maxY || positionY <= minY){
            gameOver = true;
        }
        if(!gameOver) {
            positionY += velocity;
            velocity += acceleration;

        }
    }
}
