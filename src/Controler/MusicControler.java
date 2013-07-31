package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class MusicControler implements KeyListener {
	public GamePanel gp;

	public MusicControler(GamePanel Gp) {
		gp=Gp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_SPACE:
			switch(gp.menu.state){
			case 0:
				if(!gp.mp.On){
					gp.mp.On=true;
					gp.mm.play(gp);
				}
				break;
			case 1:
				gp.mp.On=false;
				break;
			}
			gp.menu=gp.menu.decorated;
			gp.scene=58;
			break;
		case KeyEvent.VK_ESCAPE:
			gp.menu=gp.menu.decorated;
			gp.scene=58;
			break;
		case KeyEvent.VK_LEFT:
			gp.sp.play("choose");
			if(gp.menu.state!=0){
				gp.menu.state--;
			}
			break;
		case KeyEvent.VK_RIGHT:
			gp.sp.play("choose");
			if(gp.menu.state!=1){
				gp.menu.state++;
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
