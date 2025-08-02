package Animation;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JPanel implements ActionListener {
    private final Bird bird;
    private final Timer timer;
    private final Pipes pipesQueue;

    public GameFrame(GameWindow parentWindow ){
        bird = new Bird();
        pipesQueue = new Pipes(bird);
        setPreferredSize(new Dimension(GameWindow.screenWidth, GameWindow.screenHeight));
        setMaximumSize(new Dimension(GameWindow.screenWidth, GameWindow.screenHeight));
        setLayout(null);
        setBounds(0, 0, GameWindow.screenWidth, GameWindow.screenHeight);
        setOpaque(false);

        timer = new Timer(10,this);
        timer.start();
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("SPACE"), "jumping");
        getInputMap(WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");

        getActionMap().put("escape", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                parentWindow.backToMenu();
            }
        });

        getActionMap().put("jumping", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (!MyObject.isGameOver()) {
                    bird.jump();
                } else {
                    parentWindow.restartGame();
                }
            }
        });
    }

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        paintSky(g);
        paintGround(g);
        bird.drawBird(g);
        pipesQueue.drawVisiblePipes(g);
    }

    private void paintSky(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GameWindow.screenWidth, GameWindow.screenHeight/10);
    }

    private void paintGround(Graphics g){
        int dirtPosition = GameWindow.screenHeight - GameWindow.screenHeight/5;
        int grassPosition = dirtPosition - GameWindow.screenWidth/10;
        g.setColor(new Color(111,78,55));
        g.fillRect(0, dirtPosition, GameWindow.screenWidth ,GameWindow.screenHeight/5);
        g.setColor(new Color(140, 200,100));
        g.fillRect(0, grassPosition, GameWindow.screenWidth,GameWindow.screenHeight/10);
    }

    public void actionPerformed(ActionEvent actionEvent){
        bird.spaceAction();
        pipesQueue.gameOn();
        repaint();
        if(MyObject.isGameOver()) {
            timer.stop();
            System.out.println(("Game Over|Points:" + MyObject.points));
        }
    }
}