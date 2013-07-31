package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class MainTaskControler implements KeyListener {
	public GamePanel gp;
	
	public MainTaskControler(GamePanel Gp) {
		gp=Gp;
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_SPACE:
			if(gp.pl.mt.count==0){
				gp.pl.mt.next();
				gp.pl.mt.count++;
			}
			break;
		}

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
