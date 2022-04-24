package classes;

import com.sinius15.launchpad.Launchpad;
import com.sinius15.launchpad.events.ButtonListener;


public class MyListener implements ButtonListener {

   Launchpad launchpad;
   DataManager dataManager;
   Gui gui;

   int page = 1;

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
         page = row;
         gui.setPage(row);
         //gui.updateLaun(); //toglilo se no cambia la pagina anche nella gui
         dataManager.setLEDPage(page);
      } else {
         dataManager.saveAudioDevice("ciao");
         dataManager.loadAudioDevice();

         soundPlayer.setPageColumnRow(page, column, row);
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
