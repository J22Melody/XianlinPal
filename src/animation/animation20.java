package animation;

import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation20 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=100;
	//总帧数
	public static final int num=13;
	
	public animation20(GamePanel Gp){
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
					case 2:

						gp.pl.roles.get(9).locX=15;
						gp.pl.roles.get(9).locY=13;
						gp.pl.roles.get(9).direction=MainControler.RIGHT;
						gp.pl.roles.get(9).scene=13;

						gp.pl.roles.get(7).locX=14;
						gp.pl.roles.get(7).locY=13;
						gp.pl.roles.get(7).direction=MainControler.RIGHT;
						gp.pl.roles.get(7).scene=13;
						break;
					case 4:
						gp.pl.roles.get(7).right();
						gp.pl.roles.get(9).right();
						break;
					case 6:
						gp.pl.roles.get(7).right();
						gp.pl.roles.get(9).right();
						break;
					case 8:
						gp.pl.roles.get(7).right();
						gp.pl.roles.get(9).right();
						break;
					case 10:
						gp.pl.roles.get(7).right();
						gp.pl.roles.get(9).right();
						break;
					case 11:
						gp.pl.roles.get(7).isMoving=false;
						gp.pl.roles.get(9).isMoving=false;
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


		gp.pl.roles.get(8).direction=MainControler.LEFT;
		
		
		
		
		gp.scene=200;


	}
	

}