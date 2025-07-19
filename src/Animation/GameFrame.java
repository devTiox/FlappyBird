package Animation;

import Objects.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JPanel implements ActionListener {
    private Bird bird;
    private Timer timer;
    private Pipe pipe;

    public GameFrame(){
        bird = new Bird();
        pipe = new Pipe();
        setPreferredSize(new Dimension(600, 800));
        setMaximumSize(new Dimension(600, 800));
        setLayout(null);
        setBounds(0, 0, 600, 800);
        setOpaque(false);

        timer = new Timer(10,this);
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
        paintSky(g);
        paintGround(g);
        bird.drawBird(g);
        pipe.drawPipe(g);
    }

    private void paintSky(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 600, 100);
    }

    private void paintGround(Graphics g){
        g.setColor(new Color(111,78,55));
        g.fillRect(0, 650, 600,100);
        g.setColor(new Color(140, 200,100));
        g.fillRect(0, 600, 600,50);
    }

    public void actionPerformed(ActionEvent actionEvent){
        bird.spaceAction();
        pipe.pipeMove();
        repaint();
        if(bird.isGameOver()) {
            timer.stop();
            System.out.println("Game Over");
        }
    }
}

