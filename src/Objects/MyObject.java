package Objects;

import java.awt.*;

public abstract class MyObject {
    protected int positionX;
    protected int positionY;
    protected final Dimension size;
    protected final int sizeX;
    protected final int sizeY;
    protected final int maxY;
    protected final int minY;

    public MyObject(int positionX, int positionY, int sizeX, int sizeY){
        this.positionX = positionX;
        this.positionY = positionY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.maxY =  555;
        this.minY = 95;
        size = new Dimension(sizeX,sizeY);
    }

    public Dimension getSize() {
        return size;
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

}
