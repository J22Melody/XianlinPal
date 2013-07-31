package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Menu.ConditionMenu;
import Menu.ItemMenu;
import Menu.SkillMenu;
import Menu.SystemMenu;
import Menu.TaskMenu;

public class MainMenuControler implements KeyListener{
	public GamePanel gp;

	public MainMenuControler(GamePanel Gp) {
		gp=Gp;
	}


	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_UP:
			gp.menu.last();
			break;
		case KeyEvent.VK_DOWN:
			gp.menu.next();
			break;
		case KeyEvent.VK_ESCAPE:
			gp.scene=gp.pl.scene;
			gp.menu=null;
			break;
		case KeyEvent.VK_SPACE:
			switch(gp.menu.state){
			case 0:
			    gp.menu=new ConditionMenu(gp.menu);
				gp.scene=51;			
				break;
			case 1:
				gp.menu=new ItemMenu(gp.menu);
				gp.scene=52;
				break;
			case 2:
				gp.menu=new SkillMenu(gp.menu);
				gp.scene=56;
				break;
			case 3:
				gp.menu=new TaskMenu(gp.menu);
				gp.scene=57;
				break;
			case 4:
				gp.menu=new SystemMenu(gp.menu);
				gp.scene=58;
				break;
			}
			break;
	
		}
	
	}


	public void keyReleased(KeyEvent arg0) {
	
	}


	public void keyTyped(KeyEvent arg0) {
	
	}

}
