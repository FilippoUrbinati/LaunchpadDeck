package com.classes;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;


public class SquareButton extends JButton {

    int column;
    int row;
    SquareButton squareButton;

    public SquareButton(int column, int row) {

        setBorder(new LineBorder(Color.BLACK, 3));
        setListener();
        this.column = column;
        this.row = row;
    }

    public void setListener() {
      addMouseListener(new MouseAdapter() {
          @Override
          public void mouseClicked(MouseEvent e) {
              if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
                  //apri schermata setting per quel tasto
                  System.out.println(getColumn() + "" + getRow());
              }

          }
      });
    }



    public int getColumn() {
      return this.column;
    }
    public int getRow() {
      return this.row;
    }
    public void setColumn(int column) {
      this.column = column;
    }
    public void setRow(int row) {
      this.row = row;
    }



}
