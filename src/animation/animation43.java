package animation;

import java.awt.Color;
import java.awt.Graphics;

import Controler.MainControler;
import InterFaceAndAbstractClass.animation;
import Main.GameFrame;
import Main.GamePanel;

public class animation43 extends animation{
	
	
	//是否播放
	public boolean go;
	//正在播放帧
	public int state;
	//计时器
	public int count;
	
	private String s1;
	private String s2;
	private int x;
	private int i;
	private int t1;
	private int t2;

	
	//每帧持续时间
	public static final int time=200;
	//总帧数
	public static final int num=30;
	
	public animation43(GamePanel Gp){
		gp=Gp;
		count=0;
		state=0;
        go=false;

		s1="秦舢、欧阳歆、何小婉、杨枳。";
		s2="几个昏黄的日日夜夜在奋斗中不知不觉过去。";
		x=30;
		i=0;
		t1=1;
		t2=1;
	}
	
	public void drawnext(Graphics g){
		g.fillRect(0, 0, 800, 480);
		g.setColor(Color.WHITE);
		
		if(state<15){
			String temps=s1.substring(0,t1);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t1!=s1.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t1<s1.length()){
				t1++;
			}
		}
		
		if(state>=15){
			String temps=s2.substring(0,t2);
			
			int k=temps.length()/x;
			for(i=0;i<=k;i++){
				String temp=null;
				if(i!=k){
					temp=temps.substring(i*x,(i+1)*x);
				}else{
					temp=temps.substring(i*x,temps.length());
				}
				if(i==k&&t2!=s2.length()){
					g.drawString(temp+"_",100,100+30*i);
				}else{
					g.drawString(temp,100,100+30*i);
				}
			
				
			}

			if(t2<s2.length()){
				t2++;
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

		gp.pl.locX=21;
		gp.pl.locY=20;
		gp.pl.direction=MainControler.UP;
		gp.pl.scene=16;
	
		gp.pl.roles.get(7).locX=23;
		gp.pl.roles.get(7).locY=20;
		gp.pl.roles.get(7).direction=MainControler.UP;
		gp.pl.roles.get(7).scene=16;
		
		gp.pl.roles.get(6).locX=19;
		gp.pl.roles.get(6).locY=20;
		gp.pl.roles.get(6).direction=MainControler.UP;
		gp.pl.roles.get(6).scene=16;
		
		gp.pl.roles.get(5).locX=17;
		gp.pl.roles.get(5).locY=20;
		gp.pl.roles.get(5).direction=MainControler.UP;
		gp.pl.roles.get(5).scene=16;
	
		gp.scene=200;


	}
	

}