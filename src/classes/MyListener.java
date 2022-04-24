package classes;

import com.sinius15.launchpad.Launchpad;
import com.sinius15.launchpad.events.ButtonListener;


public class MyListener implements ButtonListener {

   Launchpad launchpad;
   DataManager dataManager;
   Gui gui;

   SoundPlayer soundPlayer = new SoundPlayer();

   public MyListener(Launchpad launchpad, DataManager dataManager, Gui gui) {
      this.launchpad = launchpad;
      this.dataManager = dataManager;
      this.gui = gui;
   }


   boolean isActive;
   @Override
   public void onButtonDown(int row, int column) {

      if (column == 8) {
         //turn off all buttons
         for (int i = 1; i <= 8; i++) { //row from 1 to 8 to not change first row
            for (int ii = 0; ii < 9; ii++) {
               launchpad.setLedOff(ii, i);
            }
         }
         gui.setPage(row);
         gui.updateCentralPanel();
         launchpad.setLedOn(column, row, Launchpad.COLOR_RED_FULL);
      } else {
         dataManager.saveAudioDevice("ciao");
         dataManager.loadAudioDevice();

         soundPlayer.setPageColumnRow(gui.getPage(), column, row);
         if (soundPlayer.isRunning()) {
            soundPlayer.stop();
         } else {

            soundPlayer.play(dataManager);
            //soundPlayer.setVolume(0.2f);
         }
      }


   }

   @Override
   public void onButtonUp(int colomn, int row) {
      if(colomn == 0 && row == 0) {
         //System.out.println("button released");
      }
   }

}
