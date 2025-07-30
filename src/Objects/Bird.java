package Objects;

import Animation.GameWindow;

import java.awt.*;

public class Bird extends MyObject{
    private boolean gameOver = false;
    private final int startingVelocity = 2;
    private double velocity = startingVelocity;
    private final double gravity = 0.02;

    public Bird(){
        super(GameWindow.screenWidth/3, GameWindow.screenHeight/3,
                GameWindow.screenWidth/12, GameWindow.screenHeight/26);
    }

    public boolean isGameOver(){
        return gameOver;
    }

    public void jump(){
        int jumpPower = 35*startingVelocity;
        positionY -= jumpPower;
        velocity = startingVelocity;
    }

    public void drawBird(Graphics g){
        g.setColor(new Color(250,120,160));
        g.fillOval(positionX, positionY , sizeX, sizeY);
        g.setColor(Color.BLACK);
        g.fillOval(positionX+sizeX-sizeX/8, positionY+sizeY/3, sizeX/10, sizeY/10);
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
