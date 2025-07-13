package Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JPanel implements ActionListener {
    private Bird bird;
    private Timer timer;

    public GameFrame(){
        bird = new Bird();
        setPreferredSize(new Dimension(600, 800));
        setMaximumSize(new Dimension(600, 800));
        setLayout(null);
        setBounds(100, 0, 600, 700);
        setOpaque(false);

        timer = new Timer(30,this);
        timer.start();
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "jumping");
        getActionMap().put("jumping", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
               bird.jump();
            }
        });
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(new Color(10,50,30));
        g.fillOval(bird.getPositionX(), bird.getPositionY(), bird.getSizeX(), bird.getSizeY());
    }


    public void actionPerformed(ActionEvent actionEvent){
        bird.spaceAction();
        repaint();
        if(bird.isGameOver()) {
            timer.stop();
            System.out.println("Game Over");
        }
    }
}

class Bird{
    private final int positionX;
    private int positionY;
    private final int spaceShift;
    private final int jumpPower;
    private final Dimension size;
    private final int sizeX;
    private final int sizeY;
    private final int maxY;
    private final int minY;
    private boolean gameOver = false;

    public Bird(){
        positionX = 150;
        positionY = 150;
        spaceShift = 1;
        jumpPower = 40*spaceShift;
        sizeX = 50;
        sizeY=50;
        maxY=450;
        minY=-50;
        size = new Dimension(sizeX,sizeY);
    }

    public Dimension getSize() {
        return size;
    }

    public boolean isGameOver(){
        return gameOver;
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

    public void jump(){
        positionY -= jumpPower;
    }

    public void spaceAction(){
        if(positionY >= maxY || positionY <= minY){
            gameOver = true;
        }
        if(!gameOver) {
            positionY += spaceShift;

        }
    }
}
