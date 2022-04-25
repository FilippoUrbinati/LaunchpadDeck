package classes;

import java.awt.*;
import java.io.*;
import java.util.*;
import java.lang.reflect.*;
import com.sinius15.launchpad.*;
import com.google.gson.*;
import com.google.gson.reflect.*;

public class DataManager {

   Launchpad launchpad;

   int page = 1;

   private ButtonId buttonId;
   private int launchpadColor;
   private ColorData guiColor;
   private String sound;
   private int volume;

   ArrayList<LaunchpadButton> buttonList = new ArrayList<LaunchpadButton>();
   LaunchpadButton lb;

   private String location = "./data.json";
   private String locationAudio = "./audio-output.txt";
   private File fileAudioLocation = new File("./audio-output.txt");
   FileWriter writer;
   FileReader reader;
   BufferedReader readerb;
   Gson gson = new Gson();

   public DataManager(Launchpad launchpad) {
      this.launchpad = launchpad;
   }

   public void saveData() {
      try {
         writer = new FileWriter(location);
         gson.toJson(buttonList, writer);
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
         e.printStackTrace();
      }
   }

   public void loadData() {
      //fill ArrayList
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
   }


   public void addLaunchpadButton(LaunchpadButton lb) {
      buttonList.add(lb);
   }
   public void removeButton(int page, int column, int row) {
      for (LaunchpadButton lb : buttonList) {
         if (lb.getButtonId().getPage() == page && lb.getButtonId().getColumn() == column && lb.getButtonId().getRow() == row) {
            buttonList.remove(lb);
            return;
         }
      }
   }

   public boolean exists(int page, int column, int row) {
      for (LaunchpadButton lb : buttonList) {
         if (lb.getButtonId().getPage() == page && lb.getButtonId().getColumn() == column && lb.getButtonId().getRow() == row) {
            this.lb = lb;
            return true;
         }
      }
      return false;
   }

   public Color getGuiColor() {
      return new Color(lb.getGuiColor().getRed(), lb.getGuiColor().getGreen(), lb.getGuiColor().getBlue());
   }
   public int getLaunchpadColor() {
      return lb.getLaunchpadColor();
   }
   public String getSound() {
      return lb.getSound();
   }
   public int getVolume() {
      return lb.getVolume();
   }

   public void saveAudioDevice(String audioDevice) {
      //imposta audio device
      try {
         writer = new FileWriter(locationAudio);
         writer.write(audioDevice);
         writer.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   public String loadAudioDevice() {
      String audioDevice;
      try {
         readerb = new BufferedReader(new FileReader(fileAudioLocation));
         audioDevice = readerb.readLine();
         if (audioDevice == null) {
            return "Driver audio principale";
         } else {
            return audioDevice;
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      return "Driver audio principale";
   }

   public void setLEDPage(int page) {
      this.page = page;
      //reset led
      for (int i = 1; i <= 8; i++) { //row from 1 to 8 to not change first row
         for (int ii = 0; ii <= 8; ii++) {
            launchpad.setLedOff(ii, i);
         }
      }
      //turn on button in that page + right button page
      for (LaunchpadButton lb : buttonList) {
         if (lb.getButtonId().getPage() == page) {
            launchpad.setLedOn(lb.getButtonId().getColumn(), lb.getButtonId().getRow(), lb.getLaunchpadColor());
         }
      }
      launchpad.setLedOn(8, page, Launchpad.COLOR_RED_FULL);
   }
   public int getPage() {
      return page;
   }
   public void turnOffLed() {
      for (int i = 1; i <= 8; i++) { //row from 1 to 8 to not change first row
         for (int ii = 0; ii <= 8; ii++) {
            launchpad.setLedOff(ii, i);
         }
      }
   }

}
