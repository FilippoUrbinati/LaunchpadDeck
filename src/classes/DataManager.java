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

   private ButtonId buttonId;
   private int launchpadColor;
   private ColorData guiColor;
   private String sound;
   private int volume;

   ArrayList<LaunchpadButton> buttonList = new ArrayList<LaunchpadButton>();
   LaunchpadButton lb;

   private String location = "./data.json";
   private String locationAudio = "./audio-output.json";
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
      launchpad.addButtonListener(new MyListener(launchpad, this));
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
         launchpad.setLedOn(lb.getButtonId().getColumn(), lb.getButtonId().getRow(), lb.getLaunchpadColor());
      }
   }


   public void addLaunchpadButton(LaunchpadButton lb) {
      buttonList.add(lb);
   }
   public void removeButton(/*int page,*/ int column, int row) {
      for (LaunchpadButton lb : buttonList) {
         if (/*lb.getButtonId.getPage() == page && */lb.getButtonId().getColumn() == column && lb.getButtonId().getRow() == row) {
            buttonList.remove(lb);
            return;
         }
      }
   }


   public boolean exists(int column, int row) {
      for (LaunchpadButton lb : buttonList) {
         if (lb.getButtonId().getColumn() == column && lb.getButtonId().getRow() == row) {
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

   public void loadAudioDevice() {
      //carica audio device
      String audioDevice;
      char[] array = new char[50];
      try {
         reader = new FileReader(locationAudio);
         reader.read(array);
         System.out.println(array);
      } catch (IOException e) {
         e.printStackTrace();
      }
      //return audioDevice;
   }



}
