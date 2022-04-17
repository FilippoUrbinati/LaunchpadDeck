package classes;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ButtonSetterDialog extends JDialog {



   public ButtonSetterDialog() {

      setPreferredSize(new Dimension(350, 300));
      setLocation(150, 150);
      setResizable(false);

      setLayout();

      setAlwaysOnTop(true);
      pack();
      setVisible(true);
   }

   public void setLayout() {
      setLayout(new GridLayout(3, 1));
      addColorPanel();
      addSoundPanel();
      addVolumePanel();
   }

   public void addColorPanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JLabel label = new JLabel("Choose color");

      for (int i = 0; i < 7; i++) {
         JButton button = new JButton();
         //setButtonColor(button, i);

         panel.add(button, createGbc(i, 1, 1));
      }

      /*rifai tutto e metti una griglia con tutta la pallette di colori
      *
      *
      *
      *
      *
      *
      *
      */

      JButton redLow = new JButton();
      JButton redFull = new JButton();
      JButton amberLow = new JButton();
      JButton amberFull = new JButton();
      JButton yellowFull = new JButton();
      JButton greenLow = new JButton();
      JButton greenFull = new JButton();

      panel.add(label, createGbc(0, 0, 7));
      panel.add(redLow, createGbc(0, 1, 1));
      panel.add(redFull, createGbc(1, 1, 1));
      panel.add(amberLow, createGbc(2, 1, 1));
      panel.add(amberFull, createGbc(3, 1, 1));
      panel.add(yellowFull, createGbc(4, 1, 1));
      panel.add(greenLow, createGbc(5, 1, 1));
      panel.add(greenFull, createGbc(6, 1, 1));

      this.add(panel);
   }

   public void addSoundPanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JLabel label = new JLabel("Type the sound name:   ");
      JTextField field = new JTextField();
      field.setPreferredSize(new Dimension(100, 20));
      JLabel label2 = new JLabel(".wav");
      panel.add(label, createGbc(0, 0, 1));
      panel.add(field, createGbc(1, 0, 1));
      panel.add(label2, createGbc(2, 0, 1));
      this.add(panel);
   }

   public void addVolumePanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JLabel label = new JLabel("Volume");
      JTextField field = new JTextField();
      field.setPreferredSize(new Dimension(100, 20));
      panel.add(label, createGbc(0, 0, 1));

      this.add(panel);
   }


   private GridBagConstraints createGbc(int x, int y, int width) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.gridwidth = width;
      //gbc.insets = INSETS;
      return gbc;
   }

   /*public void setButtonColor(JButton button, int i) {
      ArrayList <Color> colors = new ArrayList<Color>();
      colors.add(new Color())
   }*/

}
