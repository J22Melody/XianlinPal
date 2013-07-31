package Sound;


import java.io.File;
import java.io.IOException;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Sequence;
import javax.sound.midi.Sequencer;


public class MusicPlayer {

	private File file;
	private Sequence sequence;
	private Sequencer sequencer;
	
	public boolean On;
	

	
	public MusicPlayer(String filename) {
		On=true;
		
		try {
			sequencer=MidiSystem.getSequencer();
			sequencer.open();
		} catch (MidiUnavailableException e) {
			e.printStackTrace();
		}
		
		loadMusic(filename);
		playMusic();
	}

	public void loadMusic(String filename){
		file=new File("music/"+filename+".mid");
		try {
			sequence=MidiSystem.getSequence(file);
		} catch (InvalidMidiDataException | IOException e) {
			e.printStackTrace();
		}
	}
	
	public void playMusic(){
		try {
			sequencer.setSequence(sequence);
		} catch (InvalidMidiDataException e) {
			e.printStackTrace();
		}
		
		sequencer.start();
      
	}
	
	public void stopPlaying(){
		sequencer.stop();
	}
	
	public boolean isStopped(){
		return !sequencer.isRunning();
	}
}
