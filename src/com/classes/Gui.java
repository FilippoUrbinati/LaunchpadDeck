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
