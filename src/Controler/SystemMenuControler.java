package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Menu.LoadMenu;
import Menu.MusicMenu;
import Menu.SaveMenu;
import Menu.SoundMenu;

public class SystemMenuControler implements KeyListener {
	public GamePanel gp;

	public SystemMenuControler(GamePanel Gp) {
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
		case KeyEvent.VK_SPACE:
			switch(gp.menu.state){
			case 0:
				gp.menu=new SaveMenu(gp.menu);
				gp.scene=59;
				break;
			case 1:
				gp.menu=new LoadMenu(gp.menu);
				gp.scene=60;
				break;
			case 2:
				gp.menu=new MusicMenu(gp.menu);
				gp.scene=61;
				break;
			case 3:
				gp.menu=new SoundMenu(gp.menu);
				gp.scene=62;
				break;
			case 4:
				gp.scene=0;
				break;
			}
			break;
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
