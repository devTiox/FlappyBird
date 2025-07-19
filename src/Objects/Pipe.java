package Objects;

import java.awt.*;

public class Pipe extends MyObject{
    private final int movement;

    public Pipe(){
        super(610,90 , 100, 520);
        movement = 1;
    }

    public void drawPipe(Graphics g){
        g.setColor(new Color(58,58,58));
        g.fillRect(positionX, positionY, sizeX, sizeY);
    }

    public void pipeMove(){
        positionX -= movement;
    }
}
