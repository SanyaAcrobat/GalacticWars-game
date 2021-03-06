/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bubble.Audio;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Саня
 */
public class Audio {
    
    private AudioInputStream track;
    private Clip clip;
    private FloatControl volum;

    public Audio(String root) {
        try {
            track = AudioSystem.getAudioInputStream(new File(root));
            clip = AudioSystem.getClip();
        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void play(){
        try {
            clip.open(track);
            clip.setFramePosition(0);
            clip.start();
        } catch (LineUnavailableException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Audio.class.getName()).log(Level.SEVERE, null, ex);
        } catch(IllegalStateException ex){
            clip.setFramePosition(0);
            clip.start();
        }
    }
    
    public void stop(){
        clip.stop();
    }
}
