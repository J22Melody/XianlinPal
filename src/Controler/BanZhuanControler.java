package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class BanZhuanControler implements KeyListener{
	
	public GamePanel gp;

	public BanZhuanControler(GamePanel Gp) {
		gp=Gp;
	}
	
	 // 键盘监听
    public void keyPressed(KeyEvent e) {
    	if(gp.pl.bz.gameover(gp.pl.bz.x, gp.pl.bz.y)==0){
    		  switch (e.getKeyCode()) {
    	        case KeyEvent.VK_DOWN:
    	            gp.pl.bz.down();
    	            break;
    	        case KeyEvent.VK_UP:
    	        	gp.pl.bz.turn();
    	            break;
    	        case KeyEvent.VK_RIGHT:
    	        	gp.pl.bz.right();
    	            break;
    	        case KeyEvent.VK_LEFT:
    	        	gp.pl.bz.left();
    	            break;
    	        }
    	}else{
    		switch (e.getKeyCode()) {
 	        case KeyEvent.VK_SPACE:
 	        	 gp.scene=gp.pl.scene;
 	        	if(gp.pl.bz.gameover(gp.pl.bz.x,gp.pl.bz.y)==2){	    
 	        		//奖励
 	        		gp.pl.Temp[7]++;
 	        		switch(gp.pl.TeamNum){
					case 1:
						gp.pl.ST+=2;
						gp.pl.RP++;
						break;
					case 2:
						gp.pl.ST+=2;
						gp.pl.RP++;
						gp.pl.ST2+=2;
						gp.pl.RP2++;
						break;
					case 3:
						gp.pl.ST+=2;
						gp.pl.RP++;
						gp.pl.ST2+=2;
						gp.pl.RP2++;
						gp.pl.ST3+=2;
						gp.pl.RP3++;
						break;
					case 4:
						gp.pl.ST+=2;
						gp.pl.RP++;
						gp.pl.ST2+=2;
						gp.pl.RP2++;
						gp.pl.ST3+=2;
						gp.pl.RP3++;
						gp.pl.ST4+=2;
						gp.pl.RP4++;
						break;
 	        	}
 	       
 	        
    		 }
 	           break;
    		}
    	}
      

    }

    // 无用
    public void keyReleased(KeyEvent e) {
    }

    // 无用
    public void keyTyped(KeyEvent e) {
    }

}
