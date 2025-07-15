package Animation;

import Objects.Bird;

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

