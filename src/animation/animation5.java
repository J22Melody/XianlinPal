package animation;

import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation5 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=100;
	//��֡��
	public static final int num=16;
	
	public animation5(GamePanel Gp){
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
						gp.pl.down();
						break;
					case 2:
		                gp.pl.right();
						break;
					case 5:
                        gp.pl.down();
						break;
					case 9:
                        gp.pl.left();
						break;
					case 12:
						gp.pl.down();
						break;
					case 15:
						gp.pl.isMoving=false;
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
		gp.pl.direction=MainControler.RIGHT;		
		gp.scene=200;
		gp.pl.mt.going=true;
        gp.pl.roles.get(2).direction=MainControler.LEFT;  
	}
	

}