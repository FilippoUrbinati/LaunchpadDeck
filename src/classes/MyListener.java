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




   }

   @Override
   public void onButtonUp(int colomn, int row) {
      if(colomn == 0 && row == 0) {
         //System.out.println("button released");
      }
   }

}
