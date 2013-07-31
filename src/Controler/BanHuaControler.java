package Controler;
import java.awt.event.*;

import Main.GamePanel;
public class BanHuaControler implements KeyListener{
	private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
	public GamePanel gp;

	public BanHuaControler(GamePanel Gp) {
		gp=Gp;
	}
	
	public void keyPressed(KeyEvent e) {
		if(!gp.pl.bh.gameover){
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				gp.pl.bh.directionRole=LEFT;
				gp.pl.bh.isMove=true;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				gp.pl.bh.directionRole=RIGHT;
				gp.pl.bh.isMove=true;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_UP){
				gp.pl.bh.directionRole=UP;
				gp.pl.bh.isMove=true;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				gp.pl.bh.directionRole=DOWN;
				gp.pl.bh.isMove=true;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
				gp.scene=gp.pl.scene;
			}
			
			
		}else{
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
				gp.scene=gp.pl.scene;
				//½±Àø
				gp.pl.Temp[7]++;
				switch(gp.pl.TeamNum){
				case 1:
					gp.pl.RP+=2;
					gp.pl.ST++;
					break;
				case 2:
					gp.pl.RP+=2;
					gp.pl.ST++;
					gp.pl.RP2+=2;
					gp.pl.ST2++;
					break;
				case 3:
					gp.pl.RP+=2;
					gp.pl.ST++;
					gp.pl.RP2+=2;
					gp.pl.ST2++;
					gp.pl.RP3+=2;
					gp.pl.ST3++;
					break;
				case 4:
					gp.pl.RP+=2;
					gp.pl.ST++;
					gp.pl.RP2+=2;
					gp.pl.ST2++;
					gp.pl.RP3+=2;
					gp.pl.ST3++;
					gp.pl.RP4+=2;
					gp.pl.ST4++;
					break;
	    		}
			}
		}
		
	}

	public void keyReleased(KeyEvent e) {
		if(!gp.pl.bh.gameover){
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				gp.pl.bh.isMove=false;
				gp.pl.bh.countRole=0;
		    }
		
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			gp.pl.bh.isMove=false;
			gp.pl.bh.countRole=0;
		    }
		
		if(e.getKeyCode()==KeyEvent.VK_UP){
			gp.pl.bh.isMove=false;
			gp.pl.bh.countRole=0;
		    }
		
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			gp.pl.bh.isMove=false;
			gp.pl.bh.countRole=0;
		    }
		}
		
	}


	public void keyTyped(KeyEvent e) {
		
	}

}
