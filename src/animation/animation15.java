package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation15 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间(目前游戏主帧率为10、即time为200）
	public static final int time=200;
	//总帧数
	public static final int num=40;
	
	public animation15(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;


        
	}
	
	public void drawnext(Graphics g){
		
		if(state<=15){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			g.drawString("于是秦舢开始了对这本天书般的微积分的研究。",100,100);
		}


		if(state>15){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			g.drawString("N个小时不知不觉中溜走了。。。",100,100);
		}



		if(go){
			count++;
			if(count==time*GameFrame.FPS/1000){
				if(state!=num-1){
		
				
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

		gp.scene=203;


	}
	

}