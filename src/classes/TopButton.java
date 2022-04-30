package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TopButton extends CustomButton {

   int row = 0;
   int column;

   public TopButton(int column) {
      this.column = column;
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
               System.out.println("colonna: " + getColumn());
            }
         }
      });
   }

   public int getColumn() {
      return this.column;
   }
   public void setColumn(int column) {
      this.column = column;
   }
   public int getRow() {
      return this.row;
   }

}
