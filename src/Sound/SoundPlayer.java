package Sound;


import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;


public class SoundPlayer {
 
	private File file;
	private AudioInputStream stream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip clip;
	
	//ÊÇ·ñ¿ªÆôÒôÐ§
	public boolean On;
	
	public SoundPlayer(){
		On=true;
	}
	
	public void play(String filename){
		if(On){
			loadSound(filename);
			playSound();
		}
	}
	
	public void loadSound(String filename){
		file=new File("sound/"+filename+".wav");
		try{
			stream=AudioSystem.getAudioInputStream(file);
		}catch(UnsupportedAudioFileException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		format=stream.getFormat();
	}
	
	public void playSound(){
		info=new DataLine.Info(Clip.class,format);
		try {
			clip=(Clip)AudioSystem.getLine(info);
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		try {
			clip.open(stream);
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
		}
		clip.start();
	}
}
