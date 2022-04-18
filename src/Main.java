import com.sinius15.launchpad.*;
import classes.*;
import org.jsresources.MidiCommon;
import com.google.gson.*;

public class Main {

   public static void main(String[] args) {

      //IMPORTANTE deve essere chiamato all'apertura
      DataManager dataManager = new DataManager();
      dataManager.loadData();


      Gui gui = new Gui(dataManager);


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
