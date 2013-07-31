package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Menu.ItemUseMenu;

public class ItemChooseControler implements KeyListener {
	public GamePanel gp;
	
	public ItemChooseControler(GamePanel Gp) {
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
			gp.pl.Bag.get(gp.menu.decorated.decorated.state).use(gp.menu.state+1);
			gp.menu=new ItemUseMenu(gp.menu.decorated.decorated);
			gp.scene=55;
			break;
		case KeyEvent.VK_ESCAPE:
			gp.menu=gp.menu.decorated;
			gp.scene=53;
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
