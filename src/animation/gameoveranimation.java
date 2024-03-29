package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class gameoveranimation extends animation {

	    //是否播放
		public boolean go;
		//正在播放帧
		public int state;
		//计时器
		public int count;

		
		//每帧持续时间
		public static final int time=300;
		//总帧数
		public static final int num=10;
		
		public gameoveranimation(GamePanel Gp){
			gp=Gp;
			count=0;
			state=0;
	        go=false;

	        gp.sp.play("gameover");

		}
		
		public void drawnext(Graphics g){
			g.fillRect(0, 0, 800, 480);

			g.drawImage(Method.ImageReader.work("animation/gameover"),0,0,null);

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

			gp.scene=0;
            
		

		}
		

}