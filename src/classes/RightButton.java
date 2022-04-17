package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RightButton extends CustomButton {

   int row;
   int column = 8;

   public RightButton(int row) {
      this.row = row;
      setBorder(1, Color.BLACK);
      setRadius(100);//big number set maximum radius
      setListener();
   }

   public void setListener() {
      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               //apri schermata setting per quel tasto
               System.out.println("riga: " + getRow());
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
   public void setRow(int row) {
      this.row = row;
   }

}
