package Event;

import Controler.MainControler;
import InterFaceAndAbstractClass.Event;
import Main.GamePanel;

public class EndDialog extends Event {
    public EndDialog(GamePanel Gp){
    	 gp=Gp;
        
    }

	public void occur(){
		if(gp.scene==70){
			gp.map.npcs.get(gp.pl.talkwith).enddialog();
		}
		if(gp.scene==71){
			switch(gp.pl.direction){
			case MainControler.LEFT:
				gp.pl.direction=MainControler.RIGHT;
				gp.pl.locX++;
				break;
			case MainControler.RIGHT:
				gp.pl.direction=MainControler.LEFT;
				gp.pl.locX--;
				break;
			case MainControler.UP:
				gp.pl.direction=MainControler.DOWN;
				gp.pl.locY++;
				break;
			case MainControler.DOWN:
				gp.pl.direction=MainControler.UP;
				gp.pl.locY--;
				break;
			}
		    gp.map.jumps.get(gp.pl.talkwith).enddialog();
		}
	}
}
