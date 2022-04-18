package classes;

import javax.swing.*;

public class ColorButton extends JButton {

   int i;

   public ColorButton(int i) {
      this.i = i;
   }

   public int getValue() {
      return this.i;
   }
}
