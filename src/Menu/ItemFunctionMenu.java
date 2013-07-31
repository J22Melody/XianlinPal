package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class ItemFunctionMenu extends Menu {
	
	public ItemFunctionMenu(Menu Decorated) {
		decorated=Decorated;
		gp=decorated.gp;
		state=0;
		maxstate=1;
	}
	
	public void draw(Graphics g){
		decorated.draw(g);
		
		g.drawImage(Method.ImageReader.work("menu/ItemSubMenu"+state),250+90*(decorated.state%5),150+70*(decorated.state/5),null);
	}

}
