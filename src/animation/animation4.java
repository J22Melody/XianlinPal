package animation;

import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation4 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=200;
	//��֡��
	public static final int num=6;
	
	public animation4(GamePanel Gp){
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
					case 0:
						gp.pl.roles.get(0).up();						
						break;
					case 1:
						gp.pl.roles.get(1).right();				
						break;
					case 2:
						gp.pl.roles.get(0).disappear();					
						gp.pl.roles.get(1).up();
						break;
					case 4:
						gp.pl.roles.get(1).disappear();
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

		
		gp.pl.isMoving=false;
		gp.pl.direction=MainControler.DOWN;		
		gp.scene=200;
		gp.pl.mt.going=true;
		
	

	}
	

}