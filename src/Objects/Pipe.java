package Objects;

import java.awt.*;
import java.util.LinkedList;
import java.util.Random;

public class Pipe extends MyObject{
    public static LinkedList<Pipe> pipesQueue = new LinkedList<>();
    private final int gapSize = 100;
    private final int randomNumb;

    public Pipe(){
        super(610,90 , 100, 520);
        Random rand = new Random();
        randomNumb = rand.nextInt(maxY - gapSize - minY + 1) + minY + gapSize;
    }

    public void drawPipe(Graphics g){
        g.setColor(new Color(58,58,58));
        g.fillRect(positionX, positionY, sizeX, randomNumb);
        g.fillRect(positionX, positionY + randomNumb + gapSize, sizeX, sizeY - randomNumb - gapSize);
    }

    public void pipeMove(){
        int movement = 1;
        positionX -= movement;
        if(positionX == 400) {
            Pipe newPipe = new Pipe();
            pipesQueue.add(newPipe);
            newPipe.pipeMove();
        }
        if(positionX == -10){
            pipesQueue.remove(this);
        }
    }
}

