package Painter;

import java.awt.Graphics;

import InterFaceAndAbstractClass.Painter;
import Main.GamePanel;



public class MainPainter implements Painter{
	public GamePanel gp;
	public MainPainter(GamePanel Gp){
		gp=Gp;
	}


	public void draw(Graphics g) {
		
		if(gp.map!=null){
			gp.map.draw(g);
		}
		
		if(gp.pl!=null){
			gp.pl.draw(g);
		}
	
		if(gp.scene==70){
			gp.map.npcs.get(gp.pl.talkwith).drawdialog(g);
		}
		
		if(gp.scene==71){
			gp.map.jumps.get(gp.pl.talkwith).drawdialog(g);
		}
		
		if(gp.scene==72){
			gp.pl.roles.get(gp.pl.talkwith).drawdialog(g);
		}
	}

}
