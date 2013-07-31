package Event;

import InterFaceAndAbstractClass.Event;
import Main.GamePanel;

public class Jump extends Event{
	public int scene;
	public int x;
	public int y;

	public Jump(GamePanel Gp, int Scene, int X, int Y) {
		gp=Gp;
		scene=Scene;
		x=X;
		y=Y;
	
	}

	@Override
	public void occur() {
		gp.scene=100;
		
		gp.pl.locX=x;
		gp.pl.locY=y;
		gp.pl.talkwith=-1;
		
		
		gp.pl.scene=scene;

		

	}

}
