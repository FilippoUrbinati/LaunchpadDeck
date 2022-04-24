package classes;

public class LaunchpadButton {

   private ButtonId buttonId;
   private int launchpadColor;
   private ColorData guiColor;
   private String sound;
   private int volume;

   public LaunchpadButton(ButtonId buttonId, int launchpadColor, ColorData guiColor, String sound, int volume) {
      this.buttonId = buttonId;
      this.launchpadColor = launchpadColor;
      this.guiColor = guiColor;
      this.sound = sound;
      this.volume = volume;
   }

   public ButtonId getButtonId() {
      return this.buttonId;
   }
   public void setButtonId(ButtonId buttonId) {
      this.buttonId = buttonId;
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
