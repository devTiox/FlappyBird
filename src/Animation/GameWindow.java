package Animation;

import javax.swing.*;
import java.awt.*;

public class GameWindow {
    public JFrame window;
    public JLayeredPane layers;
    public JPanel menuPanel;
    private JPanel cardPanel;
    private CardLayout cl;
    private Dimension size;

    public GameWindow(){
        size = new Dimension(600, 800);
        window = new JFrame("FlappyTypeShit");
        layers = new JLayeredPane();
        cl = new CardLayout();
        cardPanel = new JPanel(cl);
        menuPanel = new JPanel();
        BackGround background = new BackGround();

        menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
        menuPanel.setBounds(0,100,600,800);
        setButtons(menuPanel);

        cardPanel.setBounds(0,100, size.width, size.height);
        cardPanel.setOpaque(false);
        cardPanel.add(menuPanel, "MENU");
        cl.show(cardPanel, "MENU");

        layers.add(background,0);
        layers.add(cardPanel, 1);
        layers.moveToBack(background);

        window.setSize(size);
        window.add(layers);
        window.setVisible(true);
    }

    public void setButtons(JPanel buttonPanel){
        Dimension prefSize = new Dimension(300, 100);
        Font font = new Font("Arial", Font.ITALIC, 20);
        buttonPanel.add(Box.createHorizontalGlue());
        buttonPanel.add(createButton("Play", prefSize, font));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(createButton("Scores Table", prefSize, font));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(createButton("Settings", prefSize, font));
        buttonPanel.add(Box.createVerticalStrut(50));
        buttonPanel.add(createButton("Exit", prefSize, font));
        buttonPanel.setOpaque(false);
    }

    private JButton createButton(String name, Dimension size, Font font){
        JButton button = new JButton(name);
        button.setPreferredSize(size);
        button.setMaximumSize(size);
        button.setFont(font);
        button.setAlignmentX(Box.CENTER_ALIGNMENT);
        return button;
    }
}

class BackGround extends JPanel {
    private Image img;

    public BackGround(){
        img = new ImageIcon("src/Images/Forest.jpg").getImage();
        setBounds(0,0, 600, 800);
        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0 , 0, getWidth(), getHeight(), this);
    }
}

