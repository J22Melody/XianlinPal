package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation15 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=200;
	//��֡��
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
			g.drawString("����������ʼ�˶��Ȿ������΢���ֵ��о���",100,100);
		}


		if(state>15){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			g.drawString("N��Сʱ��֪�����������ˡ�����",100,100);
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