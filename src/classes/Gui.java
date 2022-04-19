package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Gui extends JFrame {

   DataManager dataManager;

   public Gui(DataManager dataManager) {
      this.dataManager = dataManager;

      setLayout();
      addFocusListener();

      setPreferredSize(new Dimension(495, 500));
      setLocation(500, 200);
      setResizable(false);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setAlwaysOnTop(true);

      pack();
      setVisible(true);
   }

   public void setLayout() {
      setLayout(new BorderLayout(12, 15));
      addTopPanel();
      addRightPanel();
      addCentralPanel();
   }

   public void addTopPanel() {
       JPanel panel = new JPanel(new GridLayout(1,8,10,10));
       panel.setBackground(Color.RED);
       panel.setPreferredSize(new Dimension(getWidth(), 42));
       addTopButtons(panel);
       add(panel, BorderLayout.NORTH);
   }

   public void addRightPanel() {
      JPanel panel = new JPanel(new GridLayout(8,1,10,10));
      panel.setBackground(Color.BLUE);
      panel.setPreferredSize(new Dimension(42, getHeight()));
      addRightButtons(panel);
      add(panel, BorderLayout.EAST);
   }

   public void addCentralPanel() {
      JPanel panel = new JPanel(new GridLayout(8, 8, 10, 10));
      panel.setBackground(Color.GREEN);
      addCentralButtons(panel);
      add(panel, BorderLayout.CENTER);
   }

   public void addTopButtons(JPanel panel) {
      ArrayList <TopButton> buttonList = new ArrayList<TopButton>();
      for (int i = 0; i < 8; i++) {
         buttonList.add(new TopButton(i));
         panel.add(buttonList.get(i));
      }
      panel.add(new SettingsButton());
   }

   public void addRightButtons(JPanel panel) {
      ArrayList <RightButton> buttonList = new ArrayList<RightButton>();
      for (int i = 0; i < 8; i++) {
         buttonList.add(new RightButton(i+1));
         panel.add(buttonList.get(i));
      }
   }

   public void addCentralButtons(JPanel panel) {
      ArrayList <CentralButton> buttonList = new ArrayList<CentralButton>();
      int counter = 0;
      for (int i = 1; i <= 8; i++) {      //row 1-8
         for (int ii = 0; ii < 8; ii++) {  //column 0-7
            CentralButton cb = new CentralButton(ii ,i, dataManager);
            if (dataManager.exists(cb.getColumn(), cb.getRow())) {
               cb.setBackground(dataManager.getGuiColor());
            }
            addRightClickListener(cb);
            buttonList.add(cb);
            panel.add(buttonList.get(counter));
            counter++;
         }
      }
   }

   public void addFocusListener() {
      addFocusListener(new FocusListener() {
         @Override
         public void focusLost(FocusEvent e) {

         }
         @Override
         public void focusGained(FocusEvent e) {
            setLayout();
         }
      });
   }




   /*
   *
   *
   *
   * bisogna creare un modo per switchare completamente tutto il pulsante
   *
   *
   *
   */
   //Switch function with the right click
   int columnFirst;
   int rowFirst;
   CentralButton firstButton;
   boolean isFirst = true;
   //method to add the listener
   public void addRightClickListener(CentralButton button) {
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
   public void switchButton(CentralButton button) {
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
