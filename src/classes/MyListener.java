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
   public void onButtonDown(int row, int colomn) {

      if (row == 0 && colomn == 0) {
         if(isActive == false) {
            System.out.println("now it's red");
            launchpad.setLedOn(colomn, row, Launchpad.COLOR_RED_LOW);
            isActive = true;
         } else {
            System.out.println("now it's turned off");
            launchpad.setLedOff(colomn, row);
            isActive = false;
         }

         try {
            soundPlayer.play();
         } catch (Exception e) {
            e.printStackTrace();
         }
      }
      if (row == 1 && colomn == 0) {
         if(isActive == false) {
            System.out.println("now it's red");
            launchpad.setLedOn(colomn, row, Launchpad.COLOR_RED_FULL);
            isActive = true;
         } else {
            System.out.println("now it's turned off");
            launchpad.setLedOff(colomn, row);
            isActive = false;
         }

         soundPlayer.setVolume(0.2f);
         //soundPlayer.stop();
      }
      if (row == 2 && colomn == 0) {
         launchpad.setLedOn(colomn, row, Launchpad.COLOR_AMBER_LOW);
      }
      if (row == 3 && colomn == 0) {
         launchpad.setLedOn(colomn, row, Launchpad.COLOR_AMBER_FULL);
      }
      if (row == 4 && colomn == 0) {
         launchpad.setLedOn(colomn, row, Launchpad.COLOR_YELLOW_FULL);
      }
      if (row == 5 && colomn == 0) {
         launchpad.setLedOn(colomn, row, Launchpad.COLOR_GREEN_LOW);
      }
      if (row == 6 && colomn == 0) {
         launchpad.setLedOn(colomn, row, Launchpad.COLOR_GREEN_FULL);
      }
   }

   @Override
   public void onButtonUp(int colomn, int row) {
      if(colomn == 0 && row == 0) {
         //System.out.println("button released");
      }
   }

}
