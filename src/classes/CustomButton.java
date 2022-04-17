package classes;

import java.awt.*;
import javax.swing.*;

public class CustomButton extends JButton {

   private int radius = 0;
   private int borderSize = 2;
   private Color borderColor = Color.BLACK;

   public CustomButton() {
      setContentAreaFilled(false);
      setBorderPainted(false);
      setFocusable(false);
   }

   public void setBorder(int size, Color color) {
      this.borderSize = size * 2;
      this.borderColor = color;
   }
   public int getBorderSize() {
      return this.borderSize;
   }
   public Color getBorderColor() {
      return this.borderColor;
   }

   public void setRadius(int radius) {
      this.radius = radius;
   }

   @Override
   public void paintComponent(Graphics g) {
      Graphics2D g2 = (Graphics2D) g;
      g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      super.paintComponent(g);
      //paint border (rect in a bigger rect)
      g2.setColor(getBorderColor());
      g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
      g2.setColor(getBackground());
      g2.fillRoundRect(borderSize/2, borderSize/2, getWidth()-borderSize, getHeight()-borderSize, radius, radius);
   }











   /*public int getRow() {
      return this.row;
   }
   public void setRow(int row) {
      this.row = row;
   }*/


}
