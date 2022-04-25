package classes;

import javax.sound.sampled.*;

public class SoundPlayer {

   Clip clip;
   String sound;
   FloatControl gainControl;

   int page;
   int column;
   int row;
   String infoName = "Driver audio principale";
   String currentInfoName = " ";
   Mixer.Info infoOutput;



   public SoundPlayer() {

      try {
         clip = AudioSystem.getClip();
      } catch (Exception e) {
         e.printStackTrace();
      }

   }

   public void play(DataManager dataManager) {
      if (dataManager.exists(page, column, row)) {
         try {
            sound = dataManager.getSound() + ".wav";

            infoName = dataManager.loadAudioDevice();
            if (currentInfoName != infoName) {
               updateInfo();
               clip = AudioSystem.getClip(infoOutput);
            }
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("../sounds/" + sound));
            clip.open(inputStream);
            gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);


            //clip.open(inputStream);
            //clip = AudioSystem.getClip(info);

            clip.setFramePosition(0);
            clip.start();
            setVolume((float) dataManager.getVolume()/100);
         } catch (Exception e) {
            e.printStackTrace();
         }
      }

   }

   public void updateInfo() {
      Mixer.Info[] mixerInfo = AudioSystem.getMixerInfo();
      for (int i = 0; i < mixerInfo.length; i++){
         Mixer.Info info = mixerInfo[i];
         Line.Info outputLine = new Line.Info(SourceDataLine.class);
         Mixer mixer = AudioSystem.getMixer(info);
         if (mixer.isLineSupported(outputLine)) {
            if (info.getName().equals(infoName)) {
               currentInfoName = infoName;
               infoOutput = info;
               return;
            }
         }
      }
   }

   public void stop() {
      if (clip == null) return;
      setVolume(0f);
      clip.stop();
      clip.flush();
      clip.close();
   }

   public boolean isRunning() {
      return clip.isRunning();
   }

   public void setPageColumnRow(int page, int column, int row) {
      this.page = page;
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
