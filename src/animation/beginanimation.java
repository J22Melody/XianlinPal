package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class beginanimation extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;

	
	//每帧持续时间
	public static final int time=100;
			
	public static final int num=50;
	
	public beginanimation(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

	}
	
	public void drawnext(Graphics g){
		g.fillRect(0, 0, 800, 480);

		//试用渐变效果
		if(state>=5&&state<25){
			g.drawImage(Method.AlhpaImage.work("animation/play",state-5),0,0,null);
		}
        if(state>=25&&state<45){
			g.drawImage(Method.AlhpaImage.work("animation/play",45-state),0,0,null);
		}
        
//        if(state>=45&&state<65){
//			g.drawImage(Method.AlhpaImage.work("animation/begin2",state-45),0,0,null);
//		}
//        if(state>=65&&state<85){
//			g.drawImage(Method.AlhpaImage.work("animation/begin2",85-state),0,0,null);
//		}
//        
//        if(state>=85&&state<105){
//			g.drawImage(Method.AlhpaImage.work("animation/play",state-85),0,0,null);
//		}
//        if(state>=105&&state<125){
//			g.drawImage(Method.AlhpaImage.work("animation/play",125-state),0,0,null);
//		}

 

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

		Method.SaveLoader.work(gp,10);
		gp.pl.mt.update();

	}
	

}
