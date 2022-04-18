package classes;

public class LaunchpadButton {

   private int column;
   private int row;
   private int launchpadColor;
   private ColorData guiColor;
   private String sound;
   private int volume;

   public LaunchpadButton(int column, int row, int launchpadColor, ColorData guiColor, String sound, int volume) {
      this.column = column;
      this.row = row;
      this.launchpadColor = launchpadColor;
      this.guiColor = guiColor;
      this.sound = sound;
      this.volume = volume;
   }

   public int getColumn() {
      return this.column;
   }
   public void setColumn(int column) {
      this.column = column;
   }
   public int getRow() {
      return this.row;
   }
   public void setRow(int row) {
      this.row = row;
   }
   public int getLaunchpadColor() {
      return this.launchpadColor;
   }
   public void setLaunchpadColor(int launchpadColor) {
      this.launchpadColor = launchpadColor;
   }
   public ColorData getGuiColor() {
      return guiColor;
   }
   public void setGuiColor(ColorData guiColor) {
      this.guiColor = guiColor;
   }
   public String getSound() {
      return this.sound;
   }
   public void setSound(String sound) {
      this.sound = sound;
   }
   public int getVolume() {
      return this.volume;
   }
   public void setVolume(int volume) {
      this.volume = volume;
   }
}
