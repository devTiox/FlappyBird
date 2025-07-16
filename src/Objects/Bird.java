package Objects;

import java.awt.*;

public class Bird{
    private final int positionX;
    private int positionY;
    private final int jumpPower;
    private final Dimension size;
    private final int sizeX;
    private final int sizeY;
    private final int maxY;
    private final int minY;
    private boolean gameOver = false;
    private final int startingVelocity;
    private double velocity;
    private double acceleration;

    public Bird(){
        positionX = 100;
        positionY = 200;
        startingVelocity = 2;
        velocity = startingVelocity;
        jumpPower = 40*startingVelocity;
        acceleration = 0.02;
        sizeX = 50;
        sizeY=50;
        maxY=555;
        minY=95;
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
        velocity = startingVelocity;
    }

    public void drawBird(Graphics g){
        g.setColor(new Color(150,200,120));
        g.fillOval(positionX, positionY , sizeX, sizeY);
    }

    public void spaceAction(){
        if(positionY >= maxY || positionY <= minY){
            gameOver = true;
        }
        if(!gameOver) {
            positionY += (int)velocity;
            velocity += acceleration;

        }
    }
}
