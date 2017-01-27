package numbers.alarmclock;

import javax.sound.sampled.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by MHSL on 27.01.2017.
 */
public class AlarmClock {
    
    public static void main(String[] args) {
        System.out.print("Input amount of seconds which you want to set up in timer: ");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            long time = Long.parseLong(reader.readLine()) * 1000;
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    File soundFile = new File("D:/Something/Sounds/arrow_x.wav");
                    try {
                        AudioInputStream audio = AudioSystem.getAudioInputStream(soundFile);
                        Clip clip = AudioSystem.getClip();
                        clip.open(audio);
                        clip.setFramePosition(0);
                        clip.start();
                        Thread.sleep(clip.getMicrosecondLength() / 1000);
                        clip.stop();
                        clip.close();
                        System.exit(0);
                    } catch (UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, time);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
