package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Menu.ItemChooseMenu;
import Menu.ItemUseMenu;

public class ItemFunctionControler implements KeyListener {
	public GamePanel gp;

	public ItemFunctionControler(GamePanel Gp) {
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
			gp.scene=52;
			break;
		case KeyEvent.VK_SPACE:
			if(gp.menu.state==0){
				if(gp.pl.TeamNum!=1){
					gp.menu=new ItemChooseMenu(gp.menu);
					gp.scene=54;
				}else{
					gp.pl.Bag.get(gp.menu.decorated.state).use(1);
					gp.menu=new ItemUseMenu(gp.menu.decorated);
					gp.scene=55;
				}
			}else{
				gp.pl.Bag.get(gp.menu.decorated.state).discard();
				gp.menu=gp.menu.decorated;
				gp.scene=52;
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
