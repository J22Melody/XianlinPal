package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class TaskMenuControler implements KeyListener{

	public GamePanel gp;
	
	public TaskMenuControler(GamePanel Gp) {
		gp=Gp;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_ESCAPE:
			gp.menu.state=0;
			gp.menu=gp.menu.decorated;
			gp.scene=50;
			break;
		case KeyEvent.VK_UP:
			gp.menu.last();
			break;
		case KeyEvent.VK_DOWN:
			gp.menu.next();
			break;
		case KeyEvent.VK_RIGHT:
			if(gp.menu.substate==0){
				gp.menu.state=0;
				gp.menu.substate=1;
			}else{
				gp.menu.state=0;
				gp.menu.substate=0;
			}
			break;
		case KeyEvent.VK_LEFT:
			if(gp.menu.substate==0){
				gp.menu.state=0;
				gp.menu.substate=1;
			}else{
				gp.menu.state=0;
				gp.menu.substate=0;
			}
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

