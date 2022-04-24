package classes;

import javax.sound.sampled.*;

public class SoundPlayer {

   Clip clip;
   String sound;
   FloatControl gainControl;

   int column;
   int row;
   Mixer.Info infoDevice;



   public SoundPlayer() {

      try {
         clip = AudioSystem.getClip();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void play(DataManager dataManager) {
      if (dataManager.exists(column, row)) {
         sound = dataManager.getSound() + ".wav";

         Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
         //Mixer.Info info = mixerInfo[7];

         for (int i = 0; i < mixerInfo.length; i++){
            Mixer.Info info = mixerInfo[i];
            Line.Info outputLine = new Line.Info(SourceDataLine.class);
            Mixer mixer = AudioSystem.getMixer(info);
            if (mixer.isLineSupported(outputLine) && info.getName() == "Altoparlanti (BEHRINGER USB WDM AUDIO 2.8.40)") {
               infoDevice = info;
               //System.out.println(info.getName());
            }
         }

         try {
            clip = AudioSystem.getClip(infoDevice);
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("../sounds/" + sound));
            clip.open(inputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);


            //clip.open(inputStream);
            //clip = AudioSystem.getClip(info);





            clip.setFramePosition(0);
            clip.start();
            setVolume(dataManager.getVolume());
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

   public void stop() {
      if (clip == null) return;
      clip.stop();
      clip.close();
   }

   public boolean isRunning() {
      return clip.isRunning();
   }

   public void setColumnRow(int column, int row) {
      this.column = column;
      this.row = row;
   }

   public float getVolume() {
      return (float) Math.pow(10f, gainControl.getValue() / 20f);
   }

   public void setVolume(float volume) throws IllegalArgumentException {
      if (volume > 0f && volume < 1f) {
         gainControl.setValue(20f * (float) Math.log10(volume));
      }
   }
}
