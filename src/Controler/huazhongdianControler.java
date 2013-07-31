package Controler;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Main.GamePanel;

public class huazhongdianControler implements KeyListener{
	public GamePanel gp;

	public huazhongdianControler(GamePanel Gp) {
		gp=Gp;
	}


	public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_LEFT){
			if(gp.pl.hzd.m>0&&gp.pl.hzd.m<=4){
				gp.pl.hzd.m=gp.pl.hzd.m-1;
				gp.sp.play("choose");
				  
			}
			 
			
		}
		if(e.getKeyCode()==KeyEvent.VK_RIGHT){
			if(gp.pl.hzd.m>=0&&gp.pl.hzd.m<=3){
				gp.pl.hzd.m=gp.pl.hzd.m+1;
				gp.sp.play("choose");
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_UP){
			if(gp.pl.hzd.n>=1&&gp.pl.hzd.n<=4){
				gp.pl.hzd.n=gp.pl.hzd.n-1;
				gp.sp.play("choose");
			}
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
			if(gp.pl.hzd.n>=0&&gp.pl.hzd.n<=3){
				gp.pl.hzd.n=gp.pl.hzd.n+1;
				gp.sp.play("choose");
			}

		}
		
		if(e.getKeyCode()==KeyEvent.VK_SPACE){
			gp.pl.hzd.i=gp.pl.hzd.n+gp.pl.hzd.m*5;
			if(gp.pl.hzd.number<=gp.pl.hzd.NUMBER){
				
				if(gp.pl.hzd.isZd[gp.pl.hzd.i]==false&&gp.pl.hzd.number<gp.pl.hzd.NUMBER){
					gp.pl.hzd.color[gp.pl.hzd.i]=Color.green;
					gp.pl.hzd.isZd[gp.pl.hzd.i]=true;
					gp.pl.hzd.number++;
				    
				}
				else if(gp.pl.hzd.isZd[gp.pl.hzd.i]==true){
					gp.pl.hzd.color[gp.pl.hzd.i]=Color.BLACK;
					gp.pl.hzd.isZd[gp.pl.hzd.i]=false;
					gp.pl.hzd.number--;
				}
			}
			
			
		}
		
		 if(e.getKeyCode()==KeyEvent.VK_ENTER ){
			 if(gp.pl.hzd.state==0){
				 gp.pl.hzd.isTrue();
				 gp.pl.hzd.start=false;
				 gp.pl.hzd.end=true;
				 gp.pl.hzd.state++;
				 gp.sp.play("delline");
			 }else{
				 gp.pl.hzd.end();
			 }
			
			 
		 }
	}
	
	public void keyReleased(KeyEvent e){
		
	}
	public void keyTyped(KeyEvent e){
				
	}
	

}
