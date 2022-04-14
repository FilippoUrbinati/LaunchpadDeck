package com.classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RightButton extends JButton {

  int row;

  public RightButton(int row) {
    setBackground(new Color(150, 150, 150));
    //setBorder(new RoundedBorder(10, 15));
    this.row = row;
  }

  public int getRow() {
    return this.row;
  }
  public void setRow(int row) {
    this.row = row;
  }


}
