package classes;

import javax.sound.sampled.*;

public class SoundPlayer {

   Clip clip;
   FloatControl gainControl;

   public SoundPlayer(String sound) {
      try {
         clip = AudioSystem.getClip();
         AudioInputStream  inputStream = AudioSystem.getAudioInputStream(getClass().getResourceAsStream("../sounds/" + sound));
         clip.open(inputStream);
         gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public void play() throws Exception{
      clip.setFramePosition(0);
      clip.start();
   }

   public void stop() {
      if (clip == null) return;
      clip.stop();
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
