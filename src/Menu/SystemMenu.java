package Menu;

import java.awt.Graphics;
import InterFaceAndAbstractClass.Menu;

public class SystemMenu extends Menu{

	public SystemMenu(Menu Decorated) {
		state=0;
		maxstate=4;
		decorated=Decorated;
		gp=Decorated.gp;
	}

	public void draw(Graphics g) {
		decorated.draw(g);
		g.drawImage(Method.ImageReader.work("Menu/SystemMenu"+state),30,80,null);

	}

}
