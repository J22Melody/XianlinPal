package Menu;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Menu;

public class SkillMenu extends Menu{


	public SkillMenu(Menu Decorated){
		decorated=Decorated;
		gp=Decorated.gp;
	
	}
	
	public void draw(Graphics g){
		decorated.draw(g);
		g.drawImage(Method.ImageReader.work("Menu/SkillMenu"),60,40,null);
	}
}
