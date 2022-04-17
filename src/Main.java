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
      launchpad.showColorPallette();
      launchpad.addButtonListener(new MyListener(launchpad));
      Gui gui = new Gui();





      //1. Default constructor
      //Gson gson = new Gson();

      //2. Using GsonBuilder
      /*Gson gson = new GsonBuilder()
                     .disableHtmlEscaping()
                     .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                     .setPrettyPrinting()
                     .serializeNulls()
                     .create();


      Employee employee = new Employee();
      employee.setId(1);
      employee.setFirstName("Lokesh");
      employee.setLastName("Gupta");


      System.out.println(gson.toJson(employee));*/
   }


}
