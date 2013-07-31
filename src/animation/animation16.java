package animation;

import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation16 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=100;
	//��֡��
	public static final int num=8;
	
	public animation16(GamePanel Gp){
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
					case 1:
						gp.pl.right();				
						break;					
					case 4:
						gp.pl.locY--;
						gp.pl.isMoving=false;
						gp.pl.direction=MainControler.UP;
						break;
					case 5:
						gp.pl.direction=MainControler.LEFT;
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

		gp.scene=202;



	}
	

}