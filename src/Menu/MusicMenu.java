package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class MusicMenu extends Menu {

	public MusicMenu(Menu Decorated) {
		decorated=Decorated;
		gp=decorated.gp;
		state=0;
		maxstate=1;
	}
	
	public void draw(Graphics g){
		decorated.draw(g);
		
		g.drawImage(Method.ImageReader.work("menu/Sound"+state),0,0,null);
	}
}
