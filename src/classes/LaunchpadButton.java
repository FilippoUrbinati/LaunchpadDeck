package classes;

import com.sinius15.launchpad.Launchpad;
import com.sinius15.launchpad.events.ButtonListener;

public class LaunchpadButton {

   Launchpad launchpad;
   private int column;
   private int row;

   public LaunchpadButton(Launchpad launchpad, int column, int row) {
      this.launchpad = launchpad;
      this.column = column;
      this.row = row;
      setListener();
   }

   public void setListener() {

   }




}
