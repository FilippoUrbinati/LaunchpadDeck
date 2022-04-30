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
      int width = slider.getSize().width;
      int height = slider.getSize().height;


      g.setColor(new Color(0, 0, 255));
      g.fillRoundRect(0, 0, width, height, 0, 0);
   }
   @Override
   public void paintLabels(Graphics g) {

   }
   @Override
   public void paintThumb(Graphics g) {
      g.setColor(new Color(255, 0, 0));
   }
   @Override
   public void paintTicks(Graphics g) {
      int width = slider.getSize().width;
      int height = slider.getSize().height;


      g.setColor(new Color(0, 0, 255));
      g.fillRoundRect(0, 0, width, height, 0, 0);
   }
   @Override
   public void paintTrack(Graphics g) {

      int width = slider.getSize().width;
      int height = slider.getSize().height;


      g.setColor(new Color(0, 255, 0));
      //g.fillRoundRect(0, 0, width, height, 0, 0);
   }



}
