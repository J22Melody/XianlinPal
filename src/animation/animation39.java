package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation39 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=100;
	//��֡��
	public static final int num=12;
	
	public animation39(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;


        gp.pl.roles.get(8).locX=34;
        gp.pl.roles.get(8).locY=20;
        gp.pl.roles.get(8).scene=32;
        
   
        
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
                    	gp.pl.roles.get(8).up();
						break;
                    case 2:
                    	gp.pl.roles.get(8).up();
                    	break;
                    case 3:
                    	gp.pl.roles.get(8).right();
                    	break;
                    case 4:
                    	gp.pl.roles.get(8).right();
                    	break;
                    case 5:
                    	gp.pl.roles.get(8).right();
                    	break;        
                    case 6:
                    	gp.pl.roles.get(8).right();
                    	break;
                    case 7:
                      	gp.pl.roles.get(8).isMoving=false;
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