package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CentralButton extends CustomButton {

   DataManager dataManager;

   int column;
   int row;
   int launchpadColor;
   Color guiColor;
   String sound;

   public CentralButton(int column, int row, DataManager dataManager) {
      this.column = column;
      this.row = row;
      this.dataManager = dataManager;

      setBorder(1, Color.BLACK);
      //setRadius(10);
      setListener();
   }

   public void setListener() {
      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               ButtonSetterDialog dialog = new ButtonSetterDialog(column, row, dataManager);

               //System.out.println(getColumn() + "" + getRow());
            }
         }
      });
   }


   public int getColumn() {
      return this.column;
   }
   public int getRow() {
      return this.row;
   }
   public void setColumn(int column) {
      this.column = column;
   }
   public void setRow(int row) {
      this.row = row;
   }

   public void setLaunchpadColor(int color) {
      //imposta colore tasto launchpad
   }
   public void setGuiColor(Color color) {
      setBackground(color);
   }
   public void setSound() {
      this.sound = sound;
   }

}
