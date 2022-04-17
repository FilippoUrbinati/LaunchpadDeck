package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.ImageIO;

public class SettingsButton extends JButton {

   public SettingsButton() {
      try {
         Image img = ImageIO.read(getClass().getResource("../res/settings.png"));
         Image icon = img.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
         setIcon(new ImageIcon(icon));
      } catch (Exception ex) {
         System.out.println(ex);
         ex.printStackTrace();
      }
      setSize(new Dimension(50, 50));
      setContentAreaFilled(false);
      setBorderPainted(false);
      setFocusable(false);
      setListener();
   }

   public void setListener() {
      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               //apri schermata settings
               System.out.println("questo e' il settings button");
            }
         }
      });
   }



}
