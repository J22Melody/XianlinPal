package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class SkillMenuControler implements KeyListener{

	public GamePanel gp;
	
	public SkillMenuControler(GamePanel Gp) {
		gp=Gp;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_ESCAPE:
			gp.menu=gp.menu.decorated;
			gp.scene=50;
			break;
		}	
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
