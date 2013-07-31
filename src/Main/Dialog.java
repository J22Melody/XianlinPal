package Main;

import java.util.ArrayList;

import InterFaceAndAbstractClass.Event;

public class Dialog {
	public boolean canChoose;
	public int state;
	public String content;
	public ArrayList<Event> event;

	
	public Dialog(){
		state=0;
		canChoose=false;
		event=new ArrayList<Event>();
	}


	public void last() {
		if(state!=0){
			state--;
		}else{
			state=event.size()-1;
		}
	}


	public void next() {
		if(state!=event.size()-1){
			state++;
		}else{
			state=0;
		}
	}


	public void occur() {
		event.get(state).occur();
	}
	

	
	

}
