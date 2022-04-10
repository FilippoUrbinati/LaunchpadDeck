package com.sinius15.launchpad;

import org.jsresources.MidiCommon;
import javax.sound.midi.MidiUnavailableException;

public class Main {

   public static void main(String[] args) throws LaunchpadException, MidiUnavailableException {
      Launchpad launchpad = new Launchpad("Launchpad Mini");
      System.out.println(launchpad.isConnected());
      launchpad.open();
      launchpad.reset();
      launchpad.addButtonListener(new MyListener(launchpad));
      for (String s : MidiCommon.listDevices(true, true)) {
         System.out.println(s);
      }
   }


}
