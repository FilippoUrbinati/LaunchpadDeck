package classes;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import com.sinius15.launchpad.*;
import javax.sound.midi.MidiUnavailableException;
import com.google.gson.*;
import com.google.gson.reflect.*;

public class DataManager {

   Launchpad launchpad;

   private int column;
   private int row;
   private int launchpadColor;
   private ColorData guiColor;
   private String sound;
   private int volume;

   ArrayList<LaunchpadButton> buttonList = new ArrayList<LaunchpadButton>();
   LaunchpadButton lb;

   private String location = "./data.json";
   FileWriter writer;
   FileReader reader;
   Gson gson = new Gson();

   public DataManager() {
      try {
         launchpad = new Launchpad("Launchpad Mini");
         launchpad.open();
      } catch(LaunchpadException e) {
         e.printStackTrace();
      } catch(MidiUnavailableException e) {
         e.printStackTrace();
      }
      System.out.println("Connection: " + launchpad.isConnected());

      launchpad.reset();
      //launchpad.showColorPallette();
      //launchpad.addButtonListener(new MyListener(launchpad));
   }

   public void saveData() {
      try {
         writer = new FileWriter(location);
         gson.toJson(buttonList, writer);
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public void loadData() {
      //riempi ArrayList
      try {
         reader = new FileReader(location);
         Type listType = new TypeToken<ArrayList<LaunchpadButton>>(){}.getType();
         buttonList = gson.fromJson(reader, listType);
         if (buttonList == null) {
            buttonList = new ArrayList<LaunchpadButton>();
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      //imposta i tasti
      for (LaunchpadButton lb : buttonList) {
         launchpad.setLedOn(lb.getColumn(), lb.getRow(), lb.getLaunchpadColor());
      }
   }


   public void addLaunchpadButton(LaunchpadButton lb) {
      buttonList.add(lb);
   }

   public Color getGuiColor() {
      return new Color(lb.getGuiColor().getRed(), lb.getGuiColor().getGreen(), lb.getGuiColor().getBlue());
   }

   public boolean exists(CentralButton button) {
      for (LaunchpadButton lb : buttonList) {
         if (lb.getColumn() == button.getColumn() && lb.getRow() == button.getRow()) {
            this.lb = lb;
            return true;
         }
      }
      return false;
   }
}
