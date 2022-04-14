package com.classes;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;


public class RoundedBorder implements Border {

   //corner radius
   private int radius;
   //border size
   private int size;



   private String constant;

   public RoundedBorder (int size, int radius) {
      this.radius = radius;
      this.size = size;
    }

   @Override
   public Insets getBorderInsets(Component c) {
      return new Insets(this.size, this.size, this.size, this.size);
   }

   @Override
   public boolean isBorderOpaque() {
      return true;
   }

   @Override
   public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {

      Graphics2D graphics2D = (Graphics2D) g;
      //Set  anti-alias for SMOOTH corners;
      graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      //graphics2D.setColor(c.getBackground());


      graphics2D.fillRoundRect(x,y,width,height,this.radius,this.radius);


   }
}
