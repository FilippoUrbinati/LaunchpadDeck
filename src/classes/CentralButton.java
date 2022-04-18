package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CentralButton extends CustomButton {

   int column;
   int row;

   public CentralButton(int column, int row) {
      this.column = column;
      this.row = row;
      setBorder(1, Color.BLACK);
      //setRadius(10);
      setListener();
   }

   public void setListener() {
      addMouseListener(new MouseAdapter() {
         @Override
         public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
               ButtonSetterDialog dialog = new ButtonSetterDialog();

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

}
