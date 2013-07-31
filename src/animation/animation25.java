package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation25 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=100;
	//总帧数
	public static final int num=22;
	
	public animation25(GamePanel Gp){
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
                    	gp.pl.up();	
                    	gp.pl.roles.get(5).up();
						break;
                    case 2:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 3:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 4:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 5:
                    	gp.pl.roles.get(5).up();
                    	break;        
                    case 6:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 7:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 8:
                    	gp.pl.roles.get(5).up();
                    	break;        
                    case 9:
                    	gp.pl.roles.get(5).up();
                    	break;        
                    case 10:
                    	gp.pl.roles.get(5).up();
                    	break;        
                    case 11:
                    	gp.pl.roles.get(5).up();
                    	break;        
                    case 12:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 13:
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 14:
                    	gp.pl.roles.get(5).up();
                    	break;  
                    case 15:
                    	gp.pl.roles.get(5).right();
                    	break;  
                    case 16:
                    	gp.pl.isMoving=false;
                    	gp.pl.roles.get(5).up();
                    	break;
                    case 17:
                    	gp.pl.roles.get(5).up();
                    	break; 
                    case 18:
                    	gp.pl.roles.get(5).up();
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