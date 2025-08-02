package Objects;

import Animation.GameWindow;

import java.awt.*;

import java.util.Random;

public class Pipes{
    private final int pipesCount = GameWindow.screenHeight/33 - 4;
    private final int visiblePipesCount = GameWindow.screenWidth/200;
    private final Pipe[] pipeCollection = new Pipe[pipesCount];
    private final Pipe[] visiblePipes = new Pipe[visiblePipesCount];
    private final Random rand = new Random();
    private final float SPAWN_DELAY = GameWindow.screenWidth/3.3f;
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
        for(int i = 0 ; i < visiblePipesCount; i++) {
            if(visiblePipes[i] != null) {
                visiblePipes[i].pipeMove();
                if(visiblePipes[i].positionX <= bird.positionX+bird.sizeX && visiblePipes[i].positionX+visiblePipes[i].sizeX >= bird.positionX){
                    visiblePipes[i].checkForCollision(bird);
                    if(bird.positionX == visiblePipes[i].positionX + visiblePipes[i].sizeX/2 ) MyObject.points++;
                }
                if(visiblePipes[i].positionX < -GameWindow.screenWidth/6)
                    visiblePipes[i] = null;
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
    private final static int startingPosition = GameWindow.screenWidth + GameWindow.screenWidth/6;
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

    public void checkForCollision(Bird bird){
        gameOver = !(((bird.positionY + bird.sizeY) < lowerPipe) && (bird.positionY > (upperPipe + 2*bird.sizeY)));
    }

    public void resetPosition(){
        positionX = startingPosition;
    }
}
