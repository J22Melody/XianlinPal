package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class sleepanimation extends animation {

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
		
		public boolean temp;
		
		public sleepanimation(GamePanel Gp){
			gp=Gp;
			count=0;
			state=0;
	        go=false;

	        gp.pa=new promptanimation(gp,"�����ָ���ֵ");
	        gp.sp.play("sleep");
	        
	        temp=false;
		}
		
		public void drawnext(Graphics g){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			g.drawString("zzZ ������", 100,100);
			if(go){
				count++;
				if(count==time*GameFrame.FPS/1000){
					if(state!=num-1){
						if(state==3){
							if(gp.pl.Temp[1]==0){
								double i=100*gp.pl.TeamNum*Math.random();
								switch(gp.pl.TeamNum){
								case 1:
									if(i<((100-gp.pl.EP))){
										gp.pa=new promptanimation(gp,"�ӿα�����  GPA�½�");
										temp=true;

										gp.pl.GPA--;						
									}
									break;
								case 2:
									if(i<((200-gp.pl.EP-gp.pl.EP2))){
										gp.pa=new promptanimation(gp,"�ӿα�����  GPA�½�");
										temp=true;
				
										gp.pl.GPA--;
										gp.pl.GPA2--;
									}
									break;
								case 3:
									if(i<((300-gp.pl.EP-gp.pl.EP2-gp.pl.EP3))){
										gp.pa=new promptanimation(gp,"�ӿα����� GPA�½�");
										temp=true;
	
										gp.pl.GPA--;
										gp.pl.GPA2--; 
										gp.pl.GPA3--;
									}
									break;
								case 4:
									if(i<((400-gp.pl.EP-gp.pl.EP2-gp.pl.EP3-gp.pl.EP4))){
										gp.pa=new promptanimation(gp,"�ӿα����� GPA�½�");
										temp=true;

										gp.pl.GPA--;
										gp.pl.GPA2--;
										gp.pl.GPA3--;
										gp.pl.GPA4--;
									}
									break;
								}
								
							}
						    gp.pl.Temp[1]=0;                      
						}
					    state++;	
					}
					else{
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
			
			if(temp){
				gp.pl.Temp[12]++;
			}
	

			if(gp.pl.mt.level==100){
				if(gp.pl.Temp[0]==7){
					gp.scene=gp.pl.scene;
					
					gp.pa=new promptanimation(gp,"�����и���");
					gp.pl.mt.level++;
					
				}else{
					gp.scene=gp.pl.scene;
		            
					gp.pa=new promptanimation(gp,"����deadline����"+(7-gp.pl.Temp[0])+"��");
				}
			}
		
				
			
	
			
			if(gp.pl.mt.level==261){
				if(gp.pl.Temp[0]==5){
					gp.scene=gp.pl.scene;
					
					gp.pa=new promptanimation(gp,"�����и���");
					gp.pl.mt.level++;
				}else{
					gp.scene=gp.pl.scene;
		            
					gp.pa=new promptanimation(gp,"����deadline����"+(5-gp.pl.Temp[0])+"��");
				}
			}
				
			
		}
			
}
