package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation38 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=100;
	//总帧数
	public static final int num=15;
	
	public animation38(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;


   
        
	}
	
	public void drawnext(Graphics g){
		
		if(gp.map!=null){
			gp.map.draw(g);
		}
		
		if(gp.pl!=null){
			gp.pl.draw(g);
		}
	

		if(go){
			count++;
			if(count==time*GameFrame.FPS/1000){
				if(state!=num-1){
					switch(state){
                    case 1:
                    	gp.pl.right();
                    	gp.pl.roles.get(5).up();
                    	gp.pl.roles.get(6).up();
                    	gp.pl.roles.get(7).right();
						break;
                    case 2:
                    	gp.pl.up();
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).up();
                    	gp.pl.roles.get(7).right();
                    	break;
                    case 3:
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).right();
                    	gp.pl.roles.get(7).right();
                    	break;
                    case 4:
                    	gp.pl.right();
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).right();
                    	gp.pl.roles.get(7).right();
                    	break;
                    case 5:
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).right();
                    	gp.pl.roles.get(7).right();
                    	break;        
                    case 6:
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).right();
                    	gp.pl.roles.get(7).right();
                    	break;
                    case 7:
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).right();
                    	gp.pl.roles.get(7).right();
                    	break;
                    case 8:
                    	gp.pl.roles.get(5).right();
                    	gp.pl.roles.get(6).right();
                      	gp.pl.roles.get(7).isMoving=false;
                    	break;        
                    case 9:
                    	gp.pl.roles.get(5).isMoving=false;
                    	gp.pl.roles.get(6).isMoving=false; 
                    	break;        
                    case 12:
                    	gp.pl.isMoving=false;
                    	break;        
                   
					}
					state++;
				}else{
					stop();
				}
				count=0;
			}
			
			
		}
	
	}
	
	public void play(){
		go=true;
		
	}
	
	public void stop(){
		go=false;


		gp.scene=200;


	}
	

}