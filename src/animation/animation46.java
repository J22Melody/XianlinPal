package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation46 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;
	

	
	//ÿ֡����ʱ��
	public static final int time=100;
	//��֡��
	public static final int num=30;
	
	public animation46(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

	
	}
	
	public void drawnext(Graphics g){
		g.drawImage(Method.ImageReader.work("animation/final"),0,0,null);
		

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