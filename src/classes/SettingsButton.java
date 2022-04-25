package classes;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.imageio.ImageIO;
import javax.sound.sampled.*;

public class SettingsButton extends JButton {

   DataManager dataManager;
   String infoName = "Driver audio principale";

   public SettingsButton(DataManager dataManager) {
      this.dataManager = dataManager;
      infoName = dataManager.loadAudioDevice();
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
               showAudioDialog(e.getXOnScreen(), e.getYOnScreen());
            }
         }
      });
   }

   public void showAudioDialog(int x, int y) {
      JDialog dialog = new JDialog();
      //dialog.setModal(true);
      dialog.setUndecorated(true);
      /**/
      dialog.setAlwaysOnTop(true);
      /**/
      JComboBox<String> box = new JComboBox<String>();
      box.setPreferredSize(new Dimension(150, 20));
      ArrayList<Mixer.Info> list = getOutputList();
      for (Mixer.Info info : list) {
         box.addItem(info.getName());
      }
      box.setSelectedItem(infoName);
      box.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            infoName = (String) box.getSelectedItem();
            dialog.dispose();
            dataManager.saveAudioDevice(infoName);
         }
      });
      box.addFocusListener(new FocusAdapter() {
         @Override
         public void focusLost(FocusEvent e) {
            dialog.dispose();
         }
      });
      dialog.add(box);
      dialog.pack();
      dialog.setLocation(x-dialog.getPreferredSize().width, y);
      dialog.setVisible(true);
   }

   public ArrayList<Mixer.Info> getOutputList() {
      ArrayList<Mixer.Info> list = new ArrayList<Mixer.Info>();
      Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
      for (int i = 0; i < mixerInfo.length; i++){
         Mixer.Info info = mixerInfo[i];
         Line.Info outputLine = new Line.Info(SourceDataLine.class);
         Mixer mixer = AudioSystem.getMixer(info);
         if (mixer.isLineSupported(outputLine)) {
            list.add(info);
         }
      }
      return list;
   }

}
