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
      dataManager.loadData();
      Gui gui = new Gui(dataManager);

      //adding the listener for the launchpad buttons
      launchpad.addButtonListener(new MyListener(launchpad, dataManager, gui));
      launchpad.setLedOn(8, 1, Launchpad.COLOR_RED_FULL);

      //IMPORTANTE deve essere chiamato all'apertura






      /*LaunchpadButton button = new LaunchpadButton();
      button.setColumn(0);
      button.setRow(0);
      button.setLaunchpadColor(15);
      button.setGuiColor(new ColorData(255, 0, 0));
      button.setSound("ciao.wav");
      Gson gson = new Gson();
      String string = gson.toJson(button);
      System.out.println(string);*/

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
