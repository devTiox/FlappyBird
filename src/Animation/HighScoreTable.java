package Animation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class HighScoreTable extends JPanel{
//Ye probably ll add something here (ll not)
   public HighScoreTable(GameWindow parentWindow){
       setPreferredSize(new Dimension(GameWindow.screenWidth, GameWindow.screenHeight));
       setMaximumSize(new Dimension(GameWindow.screenWidth, GameWindow.screenHeight));
       setLayout(null);
       setBounds(0, 0, GameWindow.screenWidth, GameWindow.screenHeight);
       setOpaque(false);
       getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escape");
       getActionMap().put("escape", new AbstractAction() {
           @Override
           public void actionPerformed(ActionEvent e) {
               parentWindow.backToMenu();
           }
       });
   }


}
