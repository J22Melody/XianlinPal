package animation;

import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation26 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=200;
	//��֡��
	public static final int num=14;
	
	public animation26(GamePanel Gp){
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
                    	gp.pl.exist=false;	
                    	gp.pl.roles.get(5).disappear();
                    	gp.pl.roles.get(6).disappear();
						break;
                    case 3:
                    	gp.pl.roles.get(7).right();
					    break;
                    case 4:
                    	gp.pl.roles.get(7).right();
					    break;
                    case 5:
                    	gp.pl.roles.get(7).right();
					    break;
                    case 6:
                    	gp.pl.roles.get(7).right();
					    break;
                    case 7:
                    	gp.pl.roles.get(7).up();
                    	break;
                    case 8:
                    	gp.pl.roles.get(7).up();
            			gp.pa=new promptanimation(gp,"ŷ���ʰ����Ƶ���֦");
                    	break;
                    case 9:
                    	gp.pl.roles.get(7).up();
                    	break;
                    case 10:
                    	gp.pl.roles.get(7).up();
                    	break;
                    case 11:
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