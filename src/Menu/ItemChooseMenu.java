package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class ItemChooseMenu extends Menu {

	public ItemChooseMenu(Menu Decorated) {
		decorated=Decorated;
		gp=decorated.gp;
		state=0;
		maxstate=gp.pl.TeamNum-1;
	}
	
	public void draw(Graphics g){
		decorated.draw(g);
		
		g.drawImage(Method.ImageReader.work("menu/ItemChooseMenu"+maxstate+state),310+90*(decorated.decorated.state%5),170+70*(decorated.decorated.state/5),null);
	}
}
