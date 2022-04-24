package classes;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Gui extends JFrame {

   DataManager dataManager;
   JPanel centralPanel = new JPanel(new GridLayout(8, 8, 10, 10));

   int page = 1;

   public Gui(DataManager dataManager) {
      this.dataManager = dataManager;
      dataManager.setLEDPage(page);

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
      centralPanel();
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

   public void centralPanel() {
      centralPanel.setBackground(Color.GREEN);
      addCentralButtons(centralPanel);
      add(centralPanel, BorderLayout.CENTER);
   }

   public void updateCentralPanel() {
         centralPanel.removeAll();
         addCentralButtons(centralPanel);
         centralPanel.revalidate();
         centralPanel.repaint();//I don't know if it is necessary
   }

   public void addTopButtons(JPanel panel) {
      ArrayList <TopButton> buttonList = new ArrayList<TopButton>();
      for (int i = 0; i < 8; i++) {
         buttonList.add(new TopButton(i));
         panel.add(buttonList.get(i));
      }
      panel.add(new SettingsButton(dataManager));
   }

   public void addRightButtons(JPanel panel) {
      ArrayList <CustomButton> buttonList = new ArrayList<CustomButton>();
      for (int i = 0; i < 8; i++) {
         int pageNumber = i;
         CustomButton button = new CustomButton();
         button.setBorder(1, Color.BLACK);
         button.setRadius(100);//big number set maximum radius
         if (i == 0) {
            button.setBackground(LaunchpadColor.RED_FULL);
         }
         button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               page = pageNumber+1;
               updateCentralPanel();
               for (CustomButton cb : buttonList) {
                  cb.setBackground(Color.WHITE);
               }
               button.setBackground(LaunchpadColor.RED_FULL);
            }
         });
         buttonList.add(button);
         panel.add(button);
      }
   }

   public void addCentralButtons(JPanel panel) {
      ArrayList <CustomButton> buttonList = new ArrayList<CustomButton>();
      int counter = 0;
      for (int i = 1; i <= 8; i++) {      //row 1-8
         for (int ii = 0; ii < 8; ii++) {  //column 0-7
            CustomButton cb = new CustomButton();
            cb.setBorder(1, Color.BLACK);
            int column = ii;
            int row = i;
            cb.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent e) {
                  ButtonSetterDialog dialog = new ButtonSetterDialog(page, column, row, dataManager);
                  dialog.addWindowListener(new WindowAdapter() {
                     @Override
                     public void windowClosed(WindowEvent e) {
                        if (dialog.saveData()) {
                           dialog.closeOperation();
                           //ricarica panel central buttons
                           updateCentralPanel();
                        }
                     }
                  });
               }
            });
            if (dataManager.exists(page, ii, i)) {
               cb.setBackground(dataManager.getGuiColor());
            }
            //addRightClickListener(cb);
            buttonList.add(cb);
            panel.add(cb);
            counter++;
         }
      }


   }

   public void setPage(int page) {
      this.page = page;
   }
   public int getPage( ) {
      return this.page;
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
   * !!!NOT WORKING!!!
   * ora si usa custom button che non ha column e row
   *
   *
   //Switch function with the right click
   int columnFirst;
   int rowFirst;
   CustomButton firstButton;
   boolean isFirst = true;
   //method to add the listener
   public void addRightClickListener(CustomButton button) {
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
   public void switchButton(CustomButton button) {
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
   }*/

}
