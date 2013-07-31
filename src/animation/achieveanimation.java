package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class achieveanimation extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间
	public static final int time=150;
	//总帧数
	public static final int num=20;
	
	
	//提示语
	public String word;
	
	public achieveanimation(GamePanel Gp,String s){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        word=s;
        
        play();
        gp.sp.play("achievement");


	}
	
	public void drawnext(Graphics g){
		
 

		if(go){
			g.drawImage(Method.ImageReader.work("achievement/"+word),0,-50,null);
			g.drawImage(Method.ImageReader.work("achievement/word"),0,-50,null);
			
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


	}
	

}