package animation;

import java.awt.Color;
import java.awt.Graphics;

import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation17 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;

	
	//ÿ֡����ʱ��(Ŀǰ��Ϸ��֡��Ϊ10����timeΪ200��
	public static final int time=200;
	//��֡��
	public static final int num=32;
	
	private String s;
	private int x;
	private int i;
	private int t;
	
	public animation17(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;
        
        s="����Сʱ�󡣡���";
		x=30;
		i=0;
		t=1;


        
	}
	
	public void drawnext(Graphics g){
		
		if(state<=20){
			gp.sp.play("jia");
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);
			g.drawString("ǽ����̦�������̵�̫�졣",100,100);
			g.drawString("����������������������",100,130);			
			g.drawString("������������Զ������������ʱ�⣬һʱ�п���ǧ������",100,180);
		}


		
		if(state>20){
			g.fillRect(0, 0, 800, 480);
			g.setColor(Color.WHITE);

			String temps=s.substring(0,t);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t!=s.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t<s.length()){
				t++;
			}
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

		gp.scene=202;


	}
	

}