package Objects;

import Animation.GameWindow;

import java.awt.*;

public abstract class MyObject {
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
//
//    public Dimension getSize() {
//        return size;
// }
//
//    public int getSizeX() {
//        return sizeX;
//    }
//
//    public int getSizeY() {
//        return sizeY;
//    }
    public int getPositionX() {
        return positionX;
    }
//
//    public int getPositionY() {
//        return positionY;
//    }

}
