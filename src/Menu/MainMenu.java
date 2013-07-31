package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;
import Main.GamePanel;

public class MainMenu extends Menu{
	
	public MainMenu(GamePanel Gp) {
		gp=Gp;
		state=0;
		maxstate=4;
	
	}

	public void draw(Graphics g) {
		g.drawImage(Method.ImageReader.work("Menu/MainMenu"+state),0,0,null);	

	}

	
}
