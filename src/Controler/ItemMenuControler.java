package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;
import Menu.ItemFunctionMenu;

public class ItemMenuControler implements KeyListener{
	public GamePanel gp;
	
	public ItemMenuControler(GamePanel Gp){
		gp=Gp;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_ESCAPE:
			gp.menu=gp.menu.decorated;
			gp.scene=50;
			break;
		case KeyEvent.VK_LEFT:
			gp.sp.play("choose");
			if(gp.menu.state!=0&&gp.menu.state!=5&&gp.menu.state!=10&&gp.menu.state!=15){
				gp.menu.state--;
			}else{
				gp.menu.state+=4;
			}
			break;
		case KeyEvent.VK_RIGHT:
			gp.sp.play("choose");
			if(gp.menu.state!=4&&gp.menu.state!=9&&gp.menu.state!=14&&gp.menu.state!=19){
				gp.menu.state++;
			}else{
				gp.menu.state-=4;
			}
			break;
		case KeyEvent.VK_UP:
			gp.sp.play("choose");
			if(gp.menu.state!=0&&gp.menu.state!=1&&gp.menu.state!=2&&gp.menu.state!=3&&gp.menu.state!=4){
				gp.menu.state-=5;
			}else{
				gp.menu.state+=15;
			}
			break;
		case KeyEvent.VK_DOWN:
			gp.sp.play("choose");
			if(gp.menu.state!=15&&gp.menu.state!=16&&gp.menu.state!=17&&gp.menu.state!=18&&gp.menu.state!=19){
				gp.menu.state+=5;
			}else{
				gp.menu.state-=15;
			}
			break;
		case KeyEvent.VK_SPACE:
			if(gp.menu.state<gp.pl.Bag.size()){
				gp.menu=new ItemFunctionMenu(gp.menu);
				gp.scene=53;
			}
			
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
