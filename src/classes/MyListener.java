package classes;

import com.sinius15.launchpad.Launchpad;
import com.sinius15.launchpad.events.ButtonListener;


public class MyListener implements ButtonListener {

   Launchpad launchpad;
   DataManager dataManager;
   SoundPlayer soundPlayer = new SoundPlayer();

   public MyListener(Launchpad launchpad, DataManager dataManager) {
      this.launchpad = launchpad;
      this.dataManager = dataManager;
   }
   boolean isActive;
   @Override
   public void onButtonDown(int row, int column) {

      soundPlayer.setColumnRow(column, row);
      if (soundPlayer.isRunning()) {
         soundPlayer.stop();
      } else {

         soundPlayer.play(dataManager);
         //soundPlayer.setVolume(0.2f);
      }



   }

   @Override
   public void onButtonUp(int colomn, int row) {
      if(colomn == 0 && row == 0) {
         //System.out.println("button released");
      }
   }

}
