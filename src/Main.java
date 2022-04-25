import com.sinius15.launchpad.*;
import classes.*;
import org.jsresources.MidiCommon;
import javax.sound.midi.MidiUnavailableException;

public class Main {

   public static void main(String[] args) throws LaunchpadException, MidiUnavailableException {

      //inizialize launchpad
      Launchpad launchpad = new Launchpad("Launchpad Mini");
      launchpad.open();
      System.out.println("Connection: " + launchpad.isConnected());
      launchpad.reset();

      //create dataManager object and the gui
      DataManager dataManager = new DataManager(launchpad);
      //IMPORTANT it must be called
      dataManager.loadData();
      Gui gui = new Gui(dataManager);

      //adding the listener for the launchpad buttons
      launchpad.addButtonListener(new MyListener(launchpad, dataManager, gui));
      launchpad.setLedOn(8, 1, Launchpad.COLOR_RED_FULL);




   }


}
