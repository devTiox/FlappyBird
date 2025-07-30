package Objects;

import Animation.GameWindow;

import java.awt.*;

import java.util.Random;

public class Pipes{
    private int pipesCount = GameWindow.screenHeight/33 - 1;
    private int visiblePipesCount = GameWindow.screenWidth/200;
    private Pipe[] pipeCollection = new Pipe[pipesCount];
    private Pipe[] visiblePipes = new Pipe[visiblePipesCount];
    private Random rand = new Random();
    private float SPAWN_DELAY = GameWindow.screenWidth/3.3f;
    private float spawnTimer = SPAWN_DELAY/2;
    private final Bird bird;

    public Pipes(Bird bird){
        int pipeNumb = 0;
        this.bird = bird;
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
                if(visiblePipes[i].positionX < -GameWindow.screenWidth/6) {
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
    private final int gapSize = maxY/5;
    public int pipeNumb;
    private final static int startingPosition = GameWindow.screenWidth+20;
    public int upperPipe;
    public int lowerPipe;

    public Pipe(int pipeNumb){
        super(startingPosition, minY, GameWindow.screenWidth/6, maxY);
        this.pipeNumb = pipeNumb;
    }

    public void drawPipe(Graphics g){
        upperPipe = pipeNumb;
        lowerPipe = positionY + pipeNumb + gapSize;
        g.setColor(new Color(58,58,58));
        g.fillRect(positionX, positionY, sizeX, upperPipe);
        g.fillRect(positionX, lowerPipe, sizeX, sizeY - pipeNumb - gapSize - GameWindow.screenHeight/13);
    }

    public void pipeMove(){
        int movement = 2;
        positionX -= movement;
    }

    public void resetPosition(){
        positionX = startingPosition;
    }
}
