package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class OptionalTask4Controler implements KeyListener {
	public GamePanel gp;
	
	public OptionalTask4Controler(GamePanel Gp) {
		gp=Gp;
	}



	@Override
	public void keyPressed(KeyEvent arg0) {
		switch(arg0.getKeyCode()){
		case KeyEvent.VK_SPACE:
			if(gp.pl.ot4.count==0){
				gp.pl.ot4.next();
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
