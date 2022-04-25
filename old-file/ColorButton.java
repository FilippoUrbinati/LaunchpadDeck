package classes;

import javax.swing.*;

//used for the dialog
public class ColorButton extends JButton {

   int i;

   public ColorButton(int i) {
      this.i = i;
   }

   public int getValue() {
      return this.i;
   }
}
