package Painter;

import java.awt.Graphics;

import animation.loginanimation;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;

public class LoginPainter implements Painter{
	public GamePanel gp;
	public loginanimation ll;
	
	public LoginPainter(GamePanel Gp){
		gp=Gp;
		ll=new loginanimation();
		
	}

	public void draw(Graphics g) {


		ll.drawnext(g);
		gp.lm.draw(g);
	}

}
