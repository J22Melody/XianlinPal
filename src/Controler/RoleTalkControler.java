package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class RoleTalkControler implements KeyListener {
	public GamePanel gp;

	public RoleTalkControler(GamePanel Gp) {
		gp=Gp;
		gp.pl.wholeads=1;
		gp.pl.isMoving=false;
	}


	@Override
	public void keyPressed(KeyEvent arg0) {
		int keycode=arg0.getKeyCode();
		switch(keycode){
		case KeyEvent.VK_SPACE:
			if(gp.pl.talkcount==0){
				gp.pl.roles.get(gp.pl.talkwith).nextwords();	
				gp.pl.talkcount++;
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
