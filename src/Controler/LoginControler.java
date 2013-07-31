package Controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class LoginControler implements KeyListener{
	public int state;
	public GamePanel gp;

	public LoginControler(GamePanel Gp) {
		gp=Gp;
	}


	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();	
		if(!gp.lm.SubMenuExist){
			switch(keyCode){
			case KeyEvent.VK_SPACE:
				switch(gp.lm.state){
				case 0:
					gp.scene=101;
			        gp.lm.state=0;
			        gp.lm.SubState=0;
			        gp.lm.SubMenuExist=false;
			        break;
				case 1:
					gp.lm.SubMenuExist=true;
					break;
				case 2:
					gp.lm.SubMenuExist=true;
					break;
				case 3:
					System.exit(0);
				}				
				break;
			case KeyEvent.VK_UP:
				gp.sp.play("choose");
			    if(gp.lm.state==0){
			    	
			    }else{
			    	gp.lm.state--;
			    }
				break;
			case KeyEvent.VK_DOWN:
				gp.sp.play("choose");
				 if(gp.lm.state==3){
				    	
				    }else{
				    	gp.lm.state++;
				    }		
				break;
			}
		}
		else{
			if(gp.lm.state==1){
				switch(keyCode){
				case KeyEvent.VK_SPACE:
			        Method.SaveLoader.work(gp,gp.lm.SubState);
			        gp.sp.play("save");
					break;
				case KeyEvent.VK_UP:
					gp.sp.play("choose");
				    if(gp.lm.SubState!=0){
				    	gp.lm.SubState--;
				    }
					break;
				case KeyEvent.VK_DOWN:
					gp.sp.play("choose");
					if(gp.lm.SubState!=4){
						gp.lm.SubState++;
					}
					break;
				case KeyEvent.VK_ESCAPE:
					gp.lm.SubState=0;
					gp.lm.SubMenuExist=false;
				}		
			}
	        if(gp.lm.state==2){
	        	switch(keyCode){
	        	case KeyEvent.VK_ESCAPE:
					gp.lm.SubMenuExist=false;
				}		
	        	
			}
			
		}	
	}


	public void keyReleased(KeyEvent e) {
	
	}

	
	public void keyTyped(KeyEvent e) {
	
	}

}
