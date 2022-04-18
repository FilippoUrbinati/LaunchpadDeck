package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class ButtonSetterDialog extends JDialog {

   int[] colorsInt = {12, 28, 44, 60,
                  13, 29, 45, 61,
                  14, 30, 45, 62,
                  15, 31, 47, 63};
   ArrayList <Color> colors = new ArrayList<Color>();

   Color buttonColor;
   String sound;
   int volume;

   public ButtonSetterDialog() {
      inizializeColors();
      
      setPreferredSize(new Dimension(350, 400));
      setLocation(150, 150);
      setModal(true);
      setResizable(false);
      //togli setAlwaysOnTops
      setAlwaysOnTop(true);
      //
      setLayout();
      pack();
      setVisible(true);
   }

   public void setLayout() {
      setLayout(new GridLayout(4, 1));
      addColorPanel();
      addSoundPanel();
      addVolumePanel();
      addClosePanel();
   }

   public void addColorPanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JLabel label = new JLabel("Choose color:");
      JPanel buttonPanel = new JPanel(new GridLayout(4, 4));
      JPanel square = new JPanel();
      square.setPreferredSize(new Dimension(50, 50));
      int counter = 0;
      for (int i = 0; i < 4; i++) {
         for (int ii = 0; ii < 4; ii++) {
            ColorButton button = new ColorButton(counter);
            button.setPreferredSize(new Dimension(20,20));
            button.setBackground(colors.get(counter));
            button.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  setColor(button.getValue());
                  square.setBackground(button.getBackground());
               }
            });
            buttonPanel.add(button);
            counter++;
         }
      }
      panel.add(label, createGbc(0, 0));
      panel.add(Box.createRigidArea(new Dimension(35, 0)), createGbc(1, 0));
      panel.add(buttonPanel, createGbc(2, 0));
      panel.add(Box.createRigidArea(new Dimension(40, 0)), createGbc(3, 0));
      panel.add(square, createGbc(4, 0));
      this.add(panel);
   }

   public void addSoundPanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JLabel label = new JLabel("Type the sound name:");
      JTextField textField = new JTextField();
      textField.setPreferredSize(new Dimension(120, 20));
      textField.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
            setSound(textField.getText());
         }
         @Override
         public void focusGained(FocusEvent e) {
         }
      });
      JLabel label2 = new JLabel(".wav");
      panel.add(label, createGbc(0, 0));
      panel.add(Box.createRigidArea(new Dimension(20, 0)), createGbc(1, 0));
      panel.add(textField, createGbc(2, 0));
      panel.add(label2, createGbc(3, 0));
      this.add(panel);
   }

   public void addVolumePanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JLabel label = new JLabel("Volume");
      JSlider slider = new JSlider(0, 100);
      JTextField textField = new JTextField();
      slider.setValue(100);
      slider.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            textField.setText(Integer.toString(slider.getValue()));
            setVolume(slider.getValue());
         }
      });
      textField.setPreferredSize(new Dimension(30, 20));
      textField.setText(Integer.toString(slider.getValue()));
      textField.addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {
            try {
               slider.setValue(Integer.parseInt(textField.getText()));
            } catch (NumberFormatException ex) {}
         }
         @Override
         public void focusGained(FocusEvent e) {
         }
      });
      panel.add(label, createGbc(0, 0));
      JPanel panel2 = new JPanel();
      panel2.add(slider);
      panel2.add(Box.createRigidArea(new Dimension(5, 0)), createGbc(1, 0));
      panel2.add(textField);
      panel.add(panel2, createGbc(0, 1));
      this.add(panel);
   }

   public void addClosePanel() {
      JPanel panel = new JPanel(new GridBagLayout());
      JButton ok = new  JButton("Ok");
      ok.setPreferredSize(new Dimension(75, 25));
      ok.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            closeOperation();
         }
      });
      JButton cancel = new  JButton("Cancel");
      cancel.setPreferredSize(new Dimension(75, 25));
      cancel.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            dispose();
         }
      });
      panel.add(ok);
      panel.add(Box.createRigidArea(new Dimension(15, 0)));
      panel.add(cancel);
      this.add(panel);
   }

   private GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      //gbc.insets = INSETS;
      return gbc;
   }

   private void inizializeColors() {
      colors.add(new Color(255, 255, 255));
      colors.add(new Color(0, 85, 0));
      colors.add(new Color(0, 170, 0));
      colors.add(new Color(0, 255, 0));
      colors.add(new Color(85, 0, 0));
      colors.add(new Color(85, 84, 0));
      colors.add(new Color(84, 170, 0));
      colors.add(new Color(85, 255, 0));
      colors.add(new Color(170, 0, 0));
      colors.add(new Color(170, 86, 0));
      colors.add(new Color(171, 170, 0));
      colors.add(new Color(170, 255, 0));
      colors.add(new Color(255, 0, 0));
      colors.add(new Color(255, 85, 0));
      colors.add(new Color(255, 170, 0));
      colors.add(new Color(255, 255, 0));
   }

   public void setColor(int counter) {
      this.buttonColor = colors.get(counter);
   }
   public void setSound(String sound) {
      this.sound = sound;
   }
   public void setVolume(int volume) {
      this.volume = volume;
   }



   //on close dialog --> set color, sound and volume



   public void closeOperation() {

      if (buttonColor == null) {
         colorNotChoosed();
         return;
      }
      if (sound == null || sound.isEmpty()) {
         soundInvalid();
         return;
      }
      if (volume == 0) {
         setVolume(100);
      }


      //salva data
      //setta tasto
      //usa data manager



      dispose();


   }

   public void colorNotChoosed() {
      JDialog dialog = new JDialog();
      dialog.setPreferredSize(new Dimension(350, 150));
      dialog.setLocation(getLocation().x, getLocation().y + 100);
      dialog.setAlwaysOnTop(true);
      dialog.setModal(true);
      JLabel label = new JLabel("Color not choosed");
      label.setHorizontalAlignment(JLabel.CENTER);
      dialog.add(label);
      dialog.pack();
      dialog.setVisible(true);
   }
   public void soundInvalid() {
      JDialog dialog = new JDialog();
      dialog.setPreferredSize(new Dimension(350, 150));
      dialog.setLocation(getLocation().x, getLocation().y + 100);
      dialog.setAlwaysOnTop(true);
      dialog.setModal(true);
      JLabel label = new JLabel("Invalid sound");
      label.setHorizontalAlignment(JLabel.CENTER);
      dialog.add(label);
      dialog.pack();
      dialog.setVisible(true);
   }


}
