import com.sinius15.launchpad.*;
import classes.*;
import org.jsresources.MidiCommon;
import javax.sound.midi.MidiUnavailableException;
import com.google.gson.*;

public class Main {

   public static void main(String[] args) throws LaunchpadException, MidiUnavailableException {
      Launchpad launchpad = new Launchpad("Launchpad Mini");
      System.out.println("Connection: " + launchpad.isConnected());
      launchpad.open();
      launchpad.reset();
      launchpad.addButtonListener(new MyListener(launchpad));
      Gui gui = new Gui();


   }


}
