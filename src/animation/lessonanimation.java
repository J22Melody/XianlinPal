package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class lessonanimation extends animation {

	//�Ƿ񲥷�
		public boolean go;
		//���ڲ���֡
		public int state;
		//��ʱ��
		public int count;

		
		//ÿ֡����ʱ��
		public static final int time=300;
		//��֡��
		public static final int num=10;
		
		public lessonanimation(GamePanel Gp){
			gp=Gp;
			count=0;
			state=0;
	        go=false;


		}
		
		public void drawnext(Graphics g){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			g.drawString("�Ͽ���..", 100,100);
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

			gp.pl.Temp[11]++;
			gp.scene=gp.pl.scene;
            
			gp.pa=new promptanimation(gp,"ѧ�ּ������ˡ�");

		}
		

}