package Animation;

import Objects.MyObject;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    public JFrame window;
    public JLayeredPane layers;
    public JPanel menuPanel;
    private final JPanel cardPanel;
    private final CardLayout cl;
    private final GameFrame gameFrame;
    public final static int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
    public final static int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width/2;

    public GameWindow(){
        Dimension size = new Dimension(screenWidth, screenHeight);
        window = new JFrame("FlappyTypeShit");
        window.setLocation(screenWidth/2,screenHeight/2);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        layers = new JLayeredPane();
        cl = new CardLayout();
        cardPanel = new JPanel(cl);
        menuPanel = new JPanel();

        BackGround background = new BackGround();
        gameFrame = new GameFrame(this);
        HighScoreTable highScoreTable = new HighScoreTable(this);

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBounds(0,0, screenWidth, screenHeight);

        setButtons(menuPanel);

        cardPanel.setBounds(0,0, screenWidth, screenHeight);
        cardPanel.setOpaque(false);
        cardPanel.add(menuPanel, "MENU");
        cardPanel.add(gameFrame, "GAME");
        cardPanel.add(highScoreTable, "HIGH SCORES");

        cl.show(cardPanel, "MENU");

        layers.add(background, 0);
        layers.add(cardPanel, 1);
        layers.moveToBack(background);

        window.setSize(size);
        window.add(layers);
        window.setVisible(true);
    }

    public void restartGame(){
        MyObject.gameReset();
        cardPanel.remove(gameFrame);
        cardPanel.add(new GameFrame(this), "GAME");
        cl.show(cardPanel, "GAME");
    }

    public void backToMenu(){
        cl.show(cardPanel, "MENU");
    }

    public void setButtons(JPanel buttonPanel){
        int buttonWidth = screenWidth/2;
        int buttonHeight = screenHeight/6-100;
        int buttonGap = buttonHeight/3;
        Dimension prefSize = new Dimension(buttonWidth, buttonHeight);
        Font font = new Font("Arial", Font.ITALIC, buttonHeight/4);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(Box.createVerticalStrut(buttonGap+buttonGap/10));
        buttonPanel.add(createButton("Play", prefSize, font));
        buttonPanel.add(Box.createVerticalStrut(buttonGap));
        buttonPanel.add(createButton("High Score", prefSize, font));
        buttonPanel.add(Box.createVerticalStrut(buttonGap));
        buttonPanel.add(createButton("Settings", prefSize, font));
        buttonPanel.add(Box.createVerticalStrut(buttonGap));
        buttonPanel.add(createButton("Exit", prefSize, font));
        buttonPanel.setOpaque(false);
    }

    private JButton createButton(String name, Dimension size, Font font){
        JButton button = new JButton(name);
        switch(name){
            case "Play" -> button.addActionListener(e-> cl.show(cardPanel, "GAME"));
            case "High Score"  -> button.addActionListener(e-> cl.show(cardPanel, "HIGH SCORES"));
            case "Settings" -> button.addActionListener(e-> cl.show(cardPanel, "SETTINGS"));
            case "Exit" -> button.addActionListener(e-> System.exit(0));
        }
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setFont(font);
        button.setAlignmentX(Box.CENTER_ALIGNMENT);
        return button;
    }
}

class BackGround extends JPanel {
    private final Image img;

    public BackGround(){
        img = new ImageIcon("src/Images/Forest.jpg").getImage();
        setBounds(0,0, GameWindow.screenWidth, GameWindow.screenHeight);
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0 , 0, getWidth(), getHeight(), this);
    }
}

