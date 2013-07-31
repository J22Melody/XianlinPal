package Painter;

import java.awt.Graphics;

import Main.GamePanel;

public class MainMenuPainter extends MainPainter{

	public MainMenuPainter(GamePanel Gp) {
		super(Gp);
	}
	
	public void draw(Graphics g) {
	    super.draw(g);
	    if(gp.menu!=null){
		    gp.menu.draw(g);
	    }

	    
	}

}
