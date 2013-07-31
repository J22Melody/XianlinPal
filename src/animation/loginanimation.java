package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;

public class loginanimation extends animation{
	public int offset;
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;
	
	//每帧持续时间
	public int time;
	//总帧数
	public int num;
	
	

	public loginanimation(){

		offset=0;
		count=0;
		state=0;
        go=false;


	}
	
	public void drawnext(Graphics g){
		if(go){
			count++;
			if(count==time/GameFrame.FPS){
				if(state!=num-1){
					state++;
				}else{
					state=0;
				}
				count=0;
			}
		}
			
		offset=offset+1;
		if(offset>800){
			offset=0;
		}
		g.drawImage(Method.ImageReader.work("login/BG"),0,0,800-offset,480,offset,0,800,480,null);
		g.drawImage(Method.ImageReader.work("login/BG"),800-offset,0,800,480,0,0,offset,480,null);
	
	
	}
	
	
	
	public void play(){
		go=true;
		
	}
	
	public void stop(){
		go=false;
	}
	

}
