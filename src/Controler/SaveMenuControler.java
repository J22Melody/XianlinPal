package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class SaveMenuControler implements KeyListener {
	public GamePanel gp;

	public SaveMenuControler(GamePanel Gp) {
		gp=Gp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_UP:
			gp.menu.last();
			break;
		case KeyEvent.VK_DOWN:
			gp.menu.next();
			break; 
		case KeyEvent.VK_ESCAPE:
			gp.menu=gp.menu.decorated;
			gp.scene=58;
			break;
		case KeyEvent.VK_SPACE:
			Method.GameSaver.work(gp,gp.menu.state);
			gp.sp.play("save");
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
