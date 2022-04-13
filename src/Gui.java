package com.classes;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import java.io.*;
import java.util.*;


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
    panel.setBackground(Color.RED);
    //nel panel ci va un altro panel (8 bottoni tondi) e un bottone per i settings

    add(panel, BorderLayout.NORTH);
  }

  public void addLeftPanel() {
    JPanel panel = new JPanel(new GridLayout(8,1,10,10));
    panel.setBackground(Color.BLUE);

    addRightButtons(panel);


    add(panel, BorderLayout.EAST);
  }

  public void addCentralPanel() {
    JPanel panel = new JPanel(new GridLayout(8, 8, 10, 10));
    panel.setBackground(Color.GREEN);
    addCentralButtons(panel);
    add(panel, BorderLayout.CENTER);
  }

  public void addRightButtons(JPanel panel) {
    ArrayList <RightButton> buttonList = new ArrayList<RightButton>();
    for (int i = 0; i < 8; i++) {
      buttonList.add(new RightButton(i+1));
      buttonList.get(i).setBorder(new RoundedBorder(10, 15));
      panel.add(buttonList.get(i));
    }
  }

  public void addCentralButtons(JPanel panel) {
    ArrayList <SquareButton> buttonList = new ArrayList<SquareButton>();
    int counter = 0;
    for (int i = 1; i <= 8; i++) {      //row 1-8
      for (int ii = 0; ii < 8; ii++) {  //column 0-7
        buttonList.add(new SquareButton(i,ii));
        if (i == 2 && ii == 2) { //x,y --> 3,2
          buttonList.get(counter).setBackground(Color.GREEN);
        }
        if (i == 6 && ii == 7) {
          buttonList.get(counter).setBackground(Color.BLUE);
        }
        addRightClickListener(buttonList.get(counter));
        panel.add(buttonList.get(counter));
        counter++;
      }
    }
  }

  public void setLayout() {
    setLayout(new BorderLayout());
    addTopPanel();
    addLeftPanel();
    addCentralPanel();
  }



  //Switch function with the right click
  int columnFirst;
  int rowFirst;
  SquareButton firstButton;
  boolean isFirst = true;
  //method to add the listener
  public void addRightClickListener(SquareButton button) {
    button.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
            isFirst = true;
        }
        if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
            switchButton(button);
        }
      }
    });
  }
  //method which actually switch
  public void switchButton(SquareButton button) {
    if (isFirst) {
      firstButton = button;
      isFirst = false;
    } else {
      columnFirst = firstButton.getColumn();
      rowFirst = firstButton.getRow();
      firstButton.setColumn(button.getColumn());
      firstButton.setRow(button.getRow());
      button.setColumn(columnFirst);
      button.setRow(rowFirst);
      isFirst = true;
    }
  }

}
