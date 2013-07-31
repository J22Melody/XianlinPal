package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class promptanimation extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��
	public static final int time=150;
	//��֡��
	public static final int num=15;
	
	
	//��ʾ��
	public String word;
	
	public promptanimation(GamePanel Gp,String s){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        word=s;
        
        play();
        if(gp.scene!=80){
            gp.sp.play("prompt");
        }else{
        	gp.sp.play("fight");
        }
        	

	}
	
	public void drawnext(Graphics g){
		
 

		if(go){
			g.drawImage(Method.AlhpaImage.work("menu/prompt",15-state),310,130,null);
			g.setColor(Color.BLACK);
			g.drawString(word,330+6*(12-word.length()),155);
			
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


	}
	

}