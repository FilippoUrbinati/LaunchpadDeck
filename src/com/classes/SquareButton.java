package com.classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class SquareButton extends JButton {
    
    int column;
    int row;
    
    
    public SquareButton(int column, int row) {
        
        setPreferredSize(new Dimension(50, 50));
        setBorder(new LineBorder(Color.BLACK, 5));
    
        this.column = column;
        this.row = row;
    }
    
    
    addMouseListener(new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 1) {
                //apri schermata setting per quel tasto
                System.out.println(getColumn() + "" + getRow());
            }
            if (SwingUtilities.isRightMouseButton(e) && e.getClickCount() == 1) {
                switchButton(this);
            }
        }
        public void mouseExited(MouseEvent e) {
        }
        public void mouseEntered(MouseEvent e) {
        }
        public void mousePressed(MouseEvent e) {
        }
        public void mouseReleased(MouseEvent e) {
        }
    });
    
    int columnFirst;
    int rowFirst;
    SquareButton firstButton;
    boolean isFirst = true;
    
    public void switchButton(SquareButton button) {
        if (isFirst) {
            firstButton = button;
            isFirst = false;
        } else {
            columnFirst = firstButton.getColumn();
            rowFirst = firstButton.getRow();
            firstButton.setColumn(getColumn());
            firstButton.setRow(getRow());
            setColumn(columnFirst);
            setRow(rowFirst);
            isFirst = true;
        }
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

