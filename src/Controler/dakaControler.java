package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class dakaControler implements KeyListener{
	private static final int DOWN = 0;
    private static final int LEFT = 1;
    private static final int RIGHT = 2;
    private static final int UP = 3;
    
	public GamePanel gp;

	public dakaControler(GamePanel Gp) {
		gp=Gp;
	}
	
	public void keyPressed(KeyEvent e) {

		if(!gp.pl.dk.gameover){
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				if(gp.pl.dk.role.x>40){
					gp.pl.dk.directionRole=LEFT;
					gp.pl.dk.isMove=true;
				}
			}
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){

				if(gp.pl.dk.role.x<590){
					gp.pl.dk.directionRole=RIGHT;
					gp.pl.dk.isMove=true;
				}
			}
			
			if(e.getKeyCode()==KeyEvent.VK_UP){
				gp.pl.dk.directionRole=UP;
				if(gp.pl.dk.role.y>80){
					gp.pl.dk.isMove=true;
					
				}
			}
			
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				gp.pl.dk.directionRole=DOWN;
				if(gp.pl.dk.role.y<390){
					gp.pl.dk.isMove=true;
				}

			}
		}else{
			if(e.getKeyCode()==KeyEvent.VK_SPACE){
				gp.scene=gp.pl.scene;
				if(gp.pl.dk.isWin()){
					//½±Àø		
					gp.pl.Temp[10]++;
					switch(gp.pl.TeamNum){
					case 1:
						gp.pl.ST++;
						gp.pl.IQ++;
						gp.pl.RP++;
						break;
					case 2:
						gp.pl.ST++;
						gp.pl.IQ++;
						gp.pl.RP++;
						gp.pl.ST2++;
						gp.pl.IQ2++;
						gp.pl.RP2++;
						break;
					case 3:
						gp.pl.ST++;
						gp.pl.IQ++;
						gp.pl.RP++;
						gp.pl.ST2++;
						gp.pl.IQ2++;
						gp.pl.RP2++;
						gp.pl.ST3++;
						gp.pl.IQ3++;
						gp.pl.RP3++;
						break;
					case 4:
						gp.pl.ST++;
						gp.pl.IQ++;
						gp.pl.RP++;
						gp.pl.ST2++;
						gp.pl.IQ2++;
						gp.pl.RP2++;
						gp.pl.ST3++;
						gp.pl.IQ3++;
						gp.pl.RP3++;
						gp.pl.ST4++;
						gp.pl.IQ4++;
						gp.pl.RP4++;
						break;
					}
					
				}
			}
		}
	
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(!gp.pl.dk.gameover){
			if(e.getKeyCode()==KeyEvent.VK_LEFT){
				gp.pl.dk.isMove=false;
				gp.pl.dk.countRole=0;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_RIGHT){
				gp.pl.dk.isMove=false;
				gp.pl.dk.countRole=0;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_UP){
				gp.pl.dk.isMove=false;
				gp.pl.dk.countRole=0;
			}
			
			if(e.getKeyCode()==KeyEvent.VK_DOWN){
				gp.pl.dk.isMove=false;
				gp.pl.dk.countRole=0;

			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	

}