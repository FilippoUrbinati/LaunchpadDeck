package classes;

import java.awt.*;
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;


public class CustomSlider extends BasicSliderUI {

   JSlider slider;

   public CustomSlider(JSlider slider) {
      super(slider);
      this.slider = slider;
   }

   @Override
   public void paintFocus(Graphics g) {
      
   }
   @Override
   public void paintThumb(Graphics g) {
      Graphics2D g2d =  (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      g2d.setColor(new Color(255, 0, 0));

      int x = thumbRect.x;
      int y = thumbRect.y;
      int width = thumbRect.width;
      int height = thumbRect.height;
      g2d.fillOval(x, y, width, height);

      int widthInner = width/2;
      int heightInner = widthInner;
      int xInner = x + (width-widthInner)/2;
      int yInner = y + (height-heightInner)/2;

   }

   @Override
   public void paintTrack(Graphics g) {
      Graphics2D g2d =  (Graphics2D) g;
      g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      int thumbX = slider.getValue()*slider.getSize().width/100;
      int height = 5;
      int y = (slider.getSize().height - height) / 2;
      int arcx = height;
      int arcy = height;

      int xLeft = 0;
      int widthLeft = thumbX;
      g2d.setColor(new Color(93, 3, 166));
      g2d.fillRoundRect(xLeft, y, widthLeft-1, height, arcx, arcy);//-1 fixs  a little bug

      int xRight = thumbX;
      int widthRight = slider.getSize().width - widthLeft;
      g2d.setColor(new Color(128, 128, 128));
      g2d.fillRoundRect(xRight, y, widthRight, height, arcx, arcy);
   }

   @Override
   public void calculateThumbSize() {
      super.calculateThumbSize();
      thumbRect.setSize(20, 20);
   }
}
