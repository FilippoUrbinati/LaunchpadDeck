package com.classes;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;
//import java.io.*;
//import java.util.*;

public class Gui extends JFrame {
   public Gui() {

      setLayout();

      setPreferredSize(new Dimension(500, 500));
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setVisible(true);
   }
   
   public void addTopPanel() {
       JPanel panel = new JPanel();
       //nel panel ci va un altro panel (8 bottoni tondi) e un bottone per i settings
       
       add(panel, BorderLayout.NORTH);
   }
   
   public void addLeftPanel() {
       JPanel panel = new JPanel(new FlowLayout.CENTER);
       
       
       addButtons(panel);
       
       
       add(panel, BorderLayout.EAST);
   }
   
   public void addCentralPanel() {
       JPanel panel = new JPanel();
       
       
       add(panel, BorderLayout.CENTER);
   }
   
   
   
   public void addButtons(JPanel panel) {
       ArrayList <JButton> buttonList
       
       
       for (int i = 0; i < 8; i++) {
           panel.add(buttonList[i]);
       }
   }

   public void setLayout() {
      setLayout(new BorderLayout());


      JPanel b1 = new JPanel();
      b1.setSize(new Dimension(100, 100));
      b1.setBackground(new Color(255, 0, 0));
      JPanel b2 = new JPanel();
      b2.setSize(new Dimension(100, 100));
      b2.setBackground(new Color(0, 255, 0));
      JPanel b3 = new JPanel();
      b3.setSize(new Dimension(100, 100));
      b3.setBackground(new Color(0, 0, 255));

      add(b1, BorderLayout.NORTH);
      add(b2, BorderLayout.CENTER);
      add(b3, BorderLayout.EAST);
   }

}
