package Objects;

import java.awt.*;

import java.util.Random;

public class Pipes{
    private int pipesCount = 24;
    private int visiblePipesCount = 3;
    private Pipe[] pipeCollection = new Pipe[pipesCount];
    private Pipe[] visiblePipes = new Pipe[visiblePipesCount];
    private Random rand = new Random();
    private int SPAWN_DELAY = 360;
    private int spawnTimer = 30;

    public Pipes(){
        int pipeNumb = 0;
        for(int i = 0; i < pipesCount; i++){
            pipeCollection[i] = new Pipe(pipeNumb);
            pipeNumb += 20;
        }
    }

    public void gameOn() {
        spawnTimer++;

        // Spawn new pipes at intervals
        if (spawnTimer >= SPAWN_DELAY) {
            for(int i = 0; i < visiblePipesCount; i++) {
                if(visiblePipes[i] == null) {
                    int randomIndex = rand.nextInt(pipesCount);
                    visiblePipes[i] = pipeCollection[randomIndex];
                    visiblePipes[i].resetPosition();
                    spawnTimer = 0;
                    break; // Only spawn one pipe at a time
                }
            }
        }

        // Move existing pipes
        for(int i = 0; i < visiblePipesCount; i++) {
            if(visiblePipes[i] != null) {
                visiblePipes[i].pipeMove();
                if(visiblePipes[i].positionX < -100) {
                    visiblePipes[i] = null;
                }
            }
        }
    }

    public void drawVisiblePipes(Graphics g){
        for(Pipe p : visiblePipes){
            if(p != null) {
                p.drawPipe(g);
            }
        }
    }
}

class Pipe extends MyObject{
    private final int gapSize = 100;
    public int pipeNumb;


    public Pipe(int pipeNumb){
        super(610,90 , 100, 520);
        this.pipeNumb = pipeNumb;
    }

    public void drawPipe(Graphics g){
        g.setColor(new Color(58,58,58));
        g.fillRect(positionX, positionY, sizeX, pipeNumb);
        g.fillRect(positionX, positionY + pipeNumb + gapSize, sizeX, sizeY - pipeNumb - gapSize);
    }

    public void pipeMove(){
        int movement = 1;
        positionX -= movement;
    }

    public void resetPosition(){
        positionX = 610;
    }
}
