package Objects;

import java.awt.*;

public class Bird extends MyObject{
    private boolean gameOver = false;
    private final int startingVelocity = 2;
    private double velocity = startingVelocity;
    private final double gravity = 0.02;

    public Bird(){
        super(100, 200, 50, 30);
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void jump(){
        int jumpPower = 40*startingVelocity;
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
            velocity += gravity;

        }
    }
}
