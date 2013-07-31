package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;
import Main.Map;

public class animation29 extends animation{
	
	
	//�Ƿ񲥷�
	public boolean go;
	//���ڲ���֡
	public int state;
	//��ʱ��
	public int count;
	
	private String s;
	private int x;
	private int i;
	private int t;

	
	//ÿ֡����ʱ��
	public static final int time=200;
	//��֡��
	public static final int num=10;
	
	public animation29(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

		s="���ս��ҡ�";
		x=30;
		i=0;
		t=1;
	}
	
	public void drawnext(Graphics g){
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

		gp.pl.scene=13;
		gp.pl.locX=21;
		gp.pl.locY=20;
		gp.pl.direction=MainControler.LEFT;
		gp.pl.exist=true;
		
		gp.pl.roles.get(5).scene=13;
		gp.pl.roles.get(5).locX=19;
		gp.pl.roles.get(5).locY=20;
		gp.pl.roles.get(5).direction=MainControler.RIGHT;
		
		gp.pl.roles.get(6).scene=13;
		gp.pl.roles.get(6).locX=17;
		gp.pl.roles.get(6).locY=20;
		gp.pl.roles.get(6).direction=MainControler.RIGHT;
		
		
		gp.map=new Map(gp);
		gp.scene=200;

	}
	

}