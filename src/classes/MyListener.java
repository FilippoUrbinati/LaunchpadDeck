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
            launchpad.setLedOn(colomn, row, 12);
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
            launchpad.setLedOn(colomn, row, 28);
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
         launchpad.setLedOn(colomn, row, 44);
      }
      if (row == 3 && colomn == 0) {
         launchpad.setLedOn(colomn, row, 60);
      }
      if (row == 4 && colomn == 0) {
         launchpad.setLedOn(colomn, row, 13);
      }
      if (row == 5 && colomn == 0) {
         launchpad.setLedOn(colomn, row, 29);
      }
      if (row == 6 && colomn == 0) {
         launchpad.setLedOn(colomn, row, 45);
      }
      if (row == 7 && colomn == 0) {
         launchpad.setLedOn(colomn, row, 61);
      }
      if (row == 8 && colomn == 0) {
         launchpad.setLedOn(colomn, row, 14);
      }
      if (row == 0 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 30);
      }
      if (row == 1 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 46);
      }
      if (row == 2 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 62);
      }
      if (row == 3 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 15);
      }
      if (row == 4 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 31);
      }
      if (row == 5 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 47);
      }
      if (row == 6 && colomn == 1) {
         launchpad.setLedOn(colomn, row, 63);
      }



   }

   @Override
   public void onButtonUp(int colomn, int row) {
      if(colomn == 0 && row == 0) {
         //System.out.println("button released");
      }
   }

}
