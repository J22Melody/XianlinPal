package animation;

import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation23 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=300;
	//��֡��
	public static final int num=12;
	
	public animation23(GamePanel Gp){
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
					case 2:
						gp.pl.roles.get(7).scene=10;
						gp.pl.roles.get(7).locX=gp.pl.locX;
						gp.pl.roles.get(7).locY=gp.pl.locY+7;
						gp.pl.roles.get(7).direction=MainControler.UP;
						break;
					case 5:
						gp.pl.roles.get(7).up();
						break;
					case 7:
						gp.pl.roles.get(7).up();
						break;
					case 9:
						gp.pl.roles.get(7).isMoving=false;
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


		gp.scene=200;


	}
	

}