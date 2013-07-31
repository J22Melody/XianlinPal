package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import animation.promptanimation;

import Main.GamePanel;
import Menu.MainMenu;

public class MainControler implements KeyListener{

	public GamePanel gp;
	
	//方向常量
	public static final int DOWN = 0;
	public static final int UP = 3;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	
	public MainControler(GamePanel Gp){
		gp=Gp;
	}

	
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(gp.pl.movable){
			switch (keyCode) {
            case KeyEvent.VK_LEFT :
            	gp.pl.left();
            	break;        
            case KeyEvent.VK_RIGHT : 
                gp.pl.right();
                break;         	
            case KeyEvent.VK_UP :     
                gp.pl.up();
                break;              
            case KeyEvent.VK_DOWN :   
            	gp.pl.down();
                break;  
            case KeyEvent.VK_ESCAPE:
            	gp.pl.isMoving=false;
            	gp.menu=new MainMenu(gp);
            	gp.scene=50;
            	break;
            case KeyEvent.VK_SPACE:
            	if((gp.pl.mt.level==69||gp.pl.mt.level==101||gp.pl.mt.level==147||gp.pl.mt.level==262||gp.pl.mt.level==268||gp.pl.mt.level==306||gp.pl.mt.level==313||gp.pl.mt.level==449)&&gp.pl.scene==11&&((gp.pl.direction==MainControler.RIGHT&&gp.pl.locX==20&&gp.pl.locY==21)||(gp.pl.direction==MainControler.UP&&gp.pl.locX==21&&gp.pl.locY==22))){
            		gp.pa=new promptanimation(gp,"现在不是睡觉的时候");
            	}else if(gp.pl.mt.CanGo()){
                	gp.pl.mt.update();
            	}else if(gp.pl.ot1.CanGo()){
            		gp.pl.ot1.update();
            	}else if(gp.pl.ot2.CanGo()){
            		gp.pl.ot2.update();
            	}else if(gp.pl.ot3.CanGo()){
            		gp.pl.ot3.update();
            	}else if(gp.pl.ot4.CanGo()){
            		gp.pl.ot4.update();
            	}else if(gp.pl.ot5.CanGo()){
            		gp.pl.ot5.update();
            	}else if(gp.pl.ot6.CanGo()){
            		gp.pl.ot6.update();
            	}else if(gp.pl.ot7.CanGo()){
            		gp.pl.ot7.update();
            	}else if(gp.pl.ot8.CanGo()){
            		gp.pl.ot8.update();
            	}else if(gp.pl.DK.CanGo()){
            		gp.pl.DK.update();
            	}else if(gp.pl.PT.CanGo()){
            		gp.pl.PT.update();
            	}else{
                	Method.TryToTalk.work(gp);
            	}     	
            	break;
            case KeyEvent.VK_CONTROL: 
            	gp.pl.ChangeLeader();
            	break;
			}			
		}
	}


	public void keyReleased(KeyEvent e) {
		int keyCode = e.getKeyCode();
			switch (keyCode) {
            case KeyEvent.VK_LEFT :
            	 gp.pl.isMoving=false;
                 break;        
            case KeyEvent.VK_RIGHT : 
            	 gp.pl.isMoving=false;
                 break;         	
            case KeyEvent.VK_UP :     
            	 gp.pl.isMoving=false;
                 break;              
            case KeyEvent.VK_DOWN :   
            	 gp.pl.isMoving=false;
            	 break;
			}     			
		
	}


	public void keyTyped(KeyEvent e) {
	
	}

}
