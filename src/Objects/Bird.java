package Objects;

import java.awt.*;

public class Bird extends MyObject{
    private boolean gameOver = false;
    private final int jumpPower;
    private final int startingVelocity;
    private double velocity;
    private double acceleration;

    public Bird(){
        super(100, 200, 50, 50);
        startingVelocity = 2;
        velocity = startingVelocity;
        jumpPower = 40*startingVelocity;
        acceleration = 0.02;

    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void jump(){
        positionY -= jumpPower;
        velocity = startingVelocity;
    }

    public void drawBird(Graphics g){
        g.setColor(new Color(250,120,160));
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
