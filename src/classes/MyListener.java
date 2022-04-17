package classes;

import com.sinius15.launchpad.Launchpad;
import com.sinius15.launchpad.events.ButtonListener;


public class MyListener implements ButtonListener {

   Launchpad launchpad;
   SoundPlayer soundPlayer = new SoundPlayer("only-quality.wav");

   public MyListener(Launchpad launchpad) {
      this.launchpad = launchpad;
   }
   boolean isActive;
   @Override
   public void onButtonDown(int colomn, int row) {

      if (colomn == 0 && row == 0) {
         if(isActive == false) {
            System.out.println("now it's red");
            launchpad.setLedOn(row, colomn, Launchpad.COLOR_RED_FULL);
            isActive = true;
         } else {
            System.out.println("now it's turned off");
            launchpad.setLedOff(row, colomn);
            isActive = false;
         }

         try {
            soundPlayer.play();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      if (colomn == 1 && row == 0) {
         if(isActive == false) {
            System.out.println("now it's red");
            launchpad.setLedOn(row, colomn, Launchpad.COLOR_RED_FULL);
            isActive = true;
         } else {
            System.out.println("now it's turned off");
            launchpad.setLedOff(row, colomn);
            isActive = false;
         }

         soundPlayer.setVolume(0.2f);
         //soundPlayer.stop();
      }
   }

   @Override
   public void onButtonUp(int colomn, int row) {
      if(colomn == 0 && row == 0) {
         //System.out.println("button released");
      }
   }

}
